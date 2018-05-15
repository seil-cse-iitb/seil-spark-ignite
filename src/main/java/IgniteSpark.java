import org.apache.ignite.spark.IgniteDataFrameSettings;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
public class IgniteSpark {
    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder()
                .master("spark://10.129.149.14:7077")
                .config("spark.logConf", true)
                .getOrCreate();

                String cfgPath = "/home/seil/softwares/apache-ignite-fabric-2.4.0-bin/examples/config/spark/example-shared-rdd.xml";

        Dataset<Row> df = sparkSession.read()
                .format(IgniteDataFrameSettings.FORMAT_IGNITE())              //Data source
                .option(IgniteDataFrameSettings.OPTION_TABLE(), "sch_3")     //Table to read.
                .option(IgniteDataFrameSettings.OPTION_CONFIG_FILE(), cfgPath) //Ignite config.
                .load();

//        df.createOrReplaceTempView("Persons");

//        Dataset<Row> igniteDF = sparkSession.sql(
//                "SELECT * FROM person WHERE name = 'Mary Major'");
    }
}
