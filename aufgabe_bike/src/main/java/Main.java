public class Main {
    public static void main(String[] args) throws Exception {

        // set the path to read and write
        String readPath = "/Users/lxx/Desktop/Aufgaben/aufgabe_bike/src/main/resources/202201-citibike-tripdata.csv";
        String writePath_0 = "/Users/lxx/Desktop/Aufgaben/aufgabe_bike/src/main/resources/id_withoutFlink.csv";

        // get ride_id without Flink
        IDCopy idCopy = new IDCopy();
        idCopy.run(readPath,writePath_0);

        // get ride_id with Flink
        // test number of parallelism 1,2 and 3

        IDCopy_Flink idCopy_flink = new IDCopy_Flink();
        for (int i = 1; i <= 4; i ++){
            String writePath_temp = "/Users/lxx/Desktop/Aufgaben/aufgabe_bike/src/main/resources/" + "para_" + i + "_id_withFlink.csv";
            idCopy_flink.run(i,readPath,writePath_temp);
        }
    }
}
