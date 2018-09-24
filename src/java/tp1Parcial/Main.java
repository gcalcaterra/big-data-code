package tp1Parcial;

import com.backtype.hadoop.pail.Pail;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import tp1Parcial.batchlayer.BatchWorkflow;
import tp1Parcial.schema.Data;
import tp1Parcial.schema.FactsEdge;
import tp1Parcial.tap.DataPailStructure;
import tp1Parcial.tap.SplitDataPailStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

import static tp1Parcial.batchlayer.BatchWorkflow.MASTER_ROOT;
import static tp1Parcial.batchlayer.BatchWorkflow.batchWorkflow;
import static tp1Parcial.test.DataProcess.makeFacts;

public class Main {
    public static void main(String args[]) throws Exception {
        if (args.length != 1  ) {
            System.out.println("Modo de uso:");
            System.out.println("hadoop jar <path/al/.jar> <path/a/data>");
            return;
        }

        if (!new File(args[0]).exists()){
            System.out.println("No existe el directorio: " + args[0]);
            return;
        }

        String path = args[0];

        initTestData(path);
        batchWorkflow();
        showData();
    }

    public static void initTestData(String path) throws Exception {
        FileSystem fs = FileSystem.get(new Configuration());
        fs.delete(new Path(BatchWorkflow.DATA_ROOT), true);
        fs.mkdirs(new Path(BatchWorkflow.DATA_ROOT));

        Pail masterPail = Pail.create(BatchWorkflow.MASTER_ROOT, new SplitDataPailStructure());
        Pail newPail = Pail.create(BatchWorkflow.NEW_ROOT, new DataPailStructure());

        Pail.TypedRecordOutputStream os;

        //Carga al hdfs los archivos de la carpeta indicada en path
        File f = new File(path);
        File[] files = f.listFiles();

        for (File file : files) {
            BufferedReader reader = null;

            try {
                os = newPail.openWrite();

                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine(); // Lee la cabecera y la ignora

                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(",");

                    long timeSecs = new Date().getTime();
                    String internetUseId = tokens[0];
                    String individualTypeId = tokens[1];
                    String geographyId = tokens[2];
                    int year = Integer.parseInt(tokens[3]);
                    int units = Integer.parseInt(
                                    tokens[4]
                                    .replace("u", "")
                                    .replace("b", "")
                                    .replace("n", "")
                                    .replace(":", "-1")
                                    .trim()
                    );


                    os.writeObject(makeFacts(timeSecs, internetUseId, individualTypeId, geographyId, year, units));


                }

                os.close();

            } finally {
                if (reader != null) {
                    reader.close();
                }

            }
        }
    }

    public static void showData() throws Exception {
        Pail masterPail = new Pail(MASTER_ROOT);
        Pail.PailIterator iterator = masterPail.iterator();

        while (iterator.hasNext()) {
            Data next = (Data) iterator.next();
            FactsEdge factsEdge = next.get_dataUnit().get_factsEdge();

            String internetUseId = factsEdge.get_internetUse().get_id();
            String individualTypeId = factsEdge.get_individualType().get_id();
            String geographyId = factsEdge.get_geography().get_id();
            int year = factsEdge.get_year();
            int units = factsEdge.get_units();

            System.out.println(String.format("internetUse= %-15s individualType= %-20s geography= %-15s year= %-10d units= %-3d",
                    internetUseId, individualTypeId, geographyId, year, units
            ));
        }

    }

}
