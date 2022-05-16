import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple13;

/**
 * Eine Apache Flink Anmwendung unter Nutzung der Dataset API,
 * welche ebenfalls das CSV File einliest,
 * mit einer map-Transformation die ride_id extrahiert, und das Ergebnis in ein neues CSV File schreibt.
 */
public class IDCopy_Flink {

    public void run(int numberOfParallelism, String filePath_read, String filePath_write) throws Exception {
        // create the environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // set the number of parallelism
        env.setParallelism(numberOfParallelism);

        // read data from csv file
        DataSet<Tuple13<String, String, String, String, String, String, String, String, String, String, String, String, String>> input = env.readCsvFile(filePath_read)
                .types(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class);

        // get all the ride_id via map-transformation
        DataSet<Tuple1<String>> id = input.map(new IDMapper());

        // write the IDs into new csv file(s)
        id.writeAsCsv(filePath_write);

        env.execute();

        // calculate the runtime
        long runtime = env.getLastJobExecutionResult().getNetRuntime();
        System.out.println("Number of Parallelism = " + numberOfParallelism + ", Runtime: " + runtime + "ms\n");
    }

}
