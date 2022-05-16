import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Eine Java-Anwendung,
 * die die CSV Zeilenweise einliest und jeweils den Wert der ersten Spalte (ride_id) in ein neues File schreibt
 */
public class IDCopy {
    public void run(String filePath_read, String filePath_write) {
        // set a timer to calculate the application's runtime
        long startTime = System.currentTimeMillis();
        long timer;

        try (Stream<String> streamTemp = Files.lines(Paths.get(filePath_read))){
            Writer writer = new FileWriter(filePath_write);

            Stream<String> temp = streamTemp.skip(1).map(n->n.substring(0,16));
            String temp2 = temp.collect(Collectors.joining(",\n"));
            writer.write("ride_id");
            writer.write("\n");
            writer.write(temp2);
            writer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        timer = endTime - startTime;
        System.out.println("Without Flink, Runtime: " + timer + "ms\n");
    }

}
