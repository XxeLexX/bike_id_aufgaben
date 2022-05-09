import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple1;

/**
 * Eine Apache Flink Anmwendung unter Nutzung der Dataset API,
 * welche ebenfalls das CSV File einliest,
 * mit einer map-Transformation die ride_id extrahiert, und das Ergebnis in ein neues CSV File schreibt.
 */
public class IDCopy_Flink {

    public void run(int numberOfParallelism, String filePath_read, String filePath_write) throws Exception {
        Long timer = null;
        Long startTime = System.currentTimeMillis();
        // create the environment
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // set the number of parallelism
        env.setParallelism(numberOfParallelism);

        // read data from csv file
        DataSet<Bike> input = env.readCsvFile(filePath_read)
                .fieldDelimiter(",")
                .pojoType(Bike.class, "ride_id", "rideable_type", "started_at", "ended_at", "start_station_name", "start_station_id", "end_station_name", "end_station_id", "start_lat", "start_lng", "end_lat", "end_lng", "member_casual");
        //input.print();

        // get all the ride_id via map-transformation
        DataSet<Tuple1<String>> id = input.map(new MapFunction<>() {
            @Override
            public Tuple1<String> map(Bike bike) {
                return new Tuple1<>(bike.getRide_id());
            }
        });
        //id.print();

        // write the IDs into new csv file(s)
        id.writeAsCsv(filePath_write);

        env.execute();

        // calculate the runtime
        Long endTime = System.currentTimeMillis();
        timer = endTime - startTime;
        System.out.println("Number of Parallelism = " + numberOfParallelism + ", Runtime: " + timer + "ms\n");
    }

}
