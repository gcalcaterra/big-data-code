package tp1Parcial;

import backtype.hadoop.pail.Pail;
import tp1Parcial.batchlayer.BatchWorkflow;
import tp1Parcial.tap.DataPailStructure;
import tp1Parcial.tap.SplitDataPailStructure;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import static tp1Parcial.batchlayer.BatchWorkflow.batchWorkflow;
import static tp1Parcial.test.Data.makeEquiv;
import static tp1Parcial.test.Data.makePageview;

public class Main {
    public static void main(String args[]) throws Exception {
        initTestData();
        batchWorkflow();
    }

    public static void initTestData() throws Exception {
        FileSystem fs = FileSystem.get(new Configuration());
        fs.delete(new Path(BatchWorkflow.DATA_ROOT), true);
        fs.delete(new Path(BatchWorkflow.OUTPUTS_ROOT), true);
        fs.mkdirs(new Path(BatchWorkflow.DATA_ROOT));
        fs.mkdirs(new Path(BatchWorkflow.OUTPUTS_ROOT + "edb"));

        Pail masterPail = Pail.create(BatchWorkflow.MASTER_ROOT, new SplitDataPailStructure());
        Pail newPail = Pail.create(BatchWorkflow.NEW_ROOT, new DataPailStructure());

        Pail.TypedRecordOutputStream os = newPail.openWrite();

        //Aca tiene que cargar los datos de nuestro archivo...
        os.writeObject(makePageview(1, "http://foo.com/post1", 60));
        os.writeObject(makePageview(3, "http://foo.com/post1", 62));
        os.writeObject(makePageview(1, "http://foo.com/post1", 4000));
        os.writeObject(makePageview(1, "http://foo.com/post2", 4000));
        os.writeObject(makePageview(1, "http://foo.com/post2", 10000));
        os.writeObject(makePageview(5, "http://foo.com/post3", 10600));

        os.writeObject(makeEquiv(1, 3));
        os.writeObject(makeEquiv(3, 5));

        os.writeObject(makePageview(2, "http://foo.com/post1", 60));
        os.writeObject(makePageview(2, "http://foo.com/post3", 62));

        os.close();

    }
}
