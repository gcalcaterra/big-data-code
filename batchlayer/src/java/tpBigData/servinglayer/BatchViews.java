package tpBigData.servinglayer;

import cascading.flow.FlowProcess;
import cascading.operation.FunctionCall;
import cascading.tuple.Fields;
import cascading.tuple.Tuple;
import cascalog.CascalogFunction;
import com.backtype.cascading.tap.PailTap;
import com.twitter.maple.hbase.HBaseScheme;
import com.twitter.maple.hbase.HBaseTap;
import jcascalog.Api;
import jcascalog.Option;
import jcascalog.Subquery;
import jcascalog.op.Avg;
import jcascalog.op.GT;
import jcascalog.op.Max;
import jcascalog.op.Min;
import tpBigData.schema.Data;
import tpBigData.schema.FactsEdge;

import java.io.IOException;

import static tpBigData.batchlayer.BatchWorkflow.MASTER_ROOT;
import static tpBigData.batchlayer.BatchWorkflow.splitDataTap;

public class BatchViews {
    public static void batchViews() throws IOException {
        PailTap source = splitDataTap(MASTER_ROOT);

        Subquery reduced = new Subquery("?internetUseId", "?unitsMax", "?unitsMin", "?unitsAvg")
                .predicate(source, "_", "?data")
                .predicate(new ExtractFactsFields(), "?data").out("?internetUseId", "?individualTypeId", "?geographyId", "?year", "?units", "?timestamp")
                .predicate(Option.DISTINCT,"?internetUseId")
                .predicate(new GT(), "?units", -1) // -1 Significa sin datos, solo toma los mayores a -1
                .predicate(new Avg(), "?units").out("?unitsAvg")
                .predicate(new Max(), "?units").out("?unitsMax")
                .predicate(new Min(), "?units").out("?unitsMin")
                .predicate(Option.SORT, "?internetUseId");


        String tableName = "internetUse";
        String familyName = "internetUse_data";
        Fields keyFields = new Fields("?internetUseId");
        Fields valueFields = new Fields("?unitsMax", "?unitsMin", "?unitsAvg");

        HBaseScheme hBaseScheme = new HBaseScheme(keyFields, familyName, valueFields);
        HBaseTap hBaseTap = new HBaseTap(tableName, hBaseScheme);

        Api.execute(
                hBaseTap,
                reduced
        );

        //  Para solo mostrar en pantalla
        //Api.execute(
        //        new StdoutTap(),
        //        reduced
        //);
    }

    //Extrae los componentes de FactsEdge
    public static class ExtractFactsFields extends CascalogFunction {
        public void operate(FlowProcess process, FunctionCall call) {
            Data data = (Data) call.getArguments().getObject(0);
            FactsEdge factsEdge = data.get_dataUnit()
                    .get_factsEdge();

            call.getOutputCollector().add(new Tuple(
                    factsEdge.get_internetUse().get_id(),
                    factsEdge.get_individualType().get_id(),
                    factsEdge.get_geography().get_id(),
                    factsEdge.get_year(),
                    factsEdge.get_units(),
                    data.get_pedigree().get_trueAsOfSecs()
            ));
        }
    }
}



