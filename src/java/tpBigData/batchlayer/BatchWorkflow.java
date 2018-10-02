package tpBigData.batchlayer;

import cascalog.ops.IdentityBuffer;
import cascalog.ops.RandLong;
import com.backtype.cascading.tap.PailTap;
import com.backtype.cascading.tap.PailTap.PailTapOptions;
import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.PailSpec;
import com.backtype.hadoop.pail.PailStructure;
import com.twitter.maple.tap.StdoutTap;
import jcascalog.Api;
import jcascalog.Subquery;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import tpBigData.tap.DataPailStructure;
import tpBigData.tap.SplitDataPailStructure;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The entire batch layer for ... This is a purely recomputation
 * based implementation. Additional efficiency can be achieved by adding an
 * incremental batch layer as discussed in Chapter 18.
 */
@SuppressWarnings("unchecked")
public class BatchWorkflow {
    public static final String ROOT = "/tmp/root/";
    public static final String DATA_ROOT = ROOT + "data/";
    public static final String MASTER_ROOT = DATA_ROOT + "master";
    public static final String NEW_ROOT = DATA_ROOT + "new";
    public static final String TEMP_ROOT = "/tmp/temp/";


    public static void batchWorkflow() throws IOException {
        setApplicationConf();

        Pail masterPail = new Pail(MASTER_ROOT);
        Pail newDataPail = new Pail(NEW_ROOT);

        ingest(masterPail, newDataPail);
    }

    public static void ingest(Pail masterPail, Pail newDataPail)
            throws IOException {
        FileSystem fs = FileSystem.get(new Configuration());
        fs.delete(new Path(TEMP_ROOT), true);
        fs.mkdirs(new Path(TEMP_ROOT));
        String snapshotPath = TEMP_ROOT + "newDataSnapshot";

        Pail snapshotPail = newDataPail.snapshot(snapshotPath);
        appendNewDataToMasterDataPail(masterPail, snapshotPath);
        newDataPail.deleteSnapshot(snapshotPail);
    }

    public static void appendNewDataToMasterDataPail(Pail masterPail,
                                                     String snapshotPath) throws IOException {
        Pail shreddedPail = shred(snapshotPath);
        masterPail.absorb(shreddedPail);
    }


    public static Pail shred(String dataPath) throws IOException {
        String shreddedPath = TEMP_ROOT + "shredded";

        PailTap source = dataTap(dataPath);
        PailTap sink = splitDataTap(shreddedPath);

        Subquery reduced = new Subquery("?rand", "?data")
                .predicate(new RandLong(), "?rand")
                .predicate(source, "_", "?data-in")
                .predicate(new IdentityBuffer(), "?data-in").out("?data");

        Api.execute(
                sink,
                new Subquery("?data")
                        .predicate(reduced, "_", "?data"));
        Pail shreddedPail = new Pail(shreddedPath);
        shreddedPail.consolidate();
        return shreddedPail;
    }

    public static void setApplicationConf() {
        Map conf = new HashMap();
        String sers = "backtype.hadoop.ThriftSerialization";
        sers += ",";
        sers += "org.apache.hadoop.io.serializer.WritableSerialization";
        conf.put("io.serializations", sers);
        Api.setApplicationConf(conf);
    }

    public static PailTap splitDataTap(String path) {
        PailTapOptions opts = new PailTapOptions();
        opts.spec = new PailSpec(
                (PailStructure) new SplitDataPailStructure());
        return new PailTap(path, opts);
    }

    public static PailTap dataTap(String path) {
        PailTapOptions opts = new PailTapOptions();
        opts.spec = new PailSpec(
                (PailStructure) new DataPailStructure());
        return new PailTap(path, opts);
    }
}
