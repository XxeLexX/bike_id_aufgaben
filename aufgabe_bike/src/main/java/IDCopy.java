import java.io.*;
import java.util.ArrayList;

/**
 * Eine Java-Anwendung,
 * die die CSV Zeilenweise einliest und jeweils den Wert der ersten Spalte (ride_id) in ein neues File schreibt
 */
public class IDCopy {

    // the IDs from the csv file will be stored here first,
    // then will be written to the new CSV file
    private ArrayList<String> allID = new ArrayList<>();

    // read CSV from file path
    public void myRead(String filePath_read) throws IOException {
        BufferedReader reader = null;
        String line = null;

        try{
            reader = new BufferedReader(new FileReader(filePath_read));
            while ((line = reader.readLine()) != null){
                String[] row = line.split(",");
                allID.add(row[0]);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            reader.close();
        }

        if (allID == null){
            System.err.println("Here is none of IDs\n");
        }
        //System.out.println("Number of IDs : " +  (allID.size()-1));
    }

    // write only the IDs to a new file
    public void myWrite(String filePath_write) throws IOException {
        BufferedWriter writer = null;

        if (allID == null){
            System.err.println("No IDs, nothing will be written\n");
        }

        try{
            writer = new BufferedWriter(new FileWriter(filePath_write));
            for (String a : allID){
                writer.write(a);
                writer.newLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }

    /**
     * read and write the IDs from CSV file, and the runtimes will also be calculated
     */
    public void run(String filePath_read, String filePath_write) throws IOException {
        // set a timer to calculate the application's runtime
        Long startTime = System.currentTimeMillis();
        Long timer = null;

        myRead(filePath_read);
        myWrite(filePath_write);

        Long endTime = System.currentTimeMillis();
        timer = endTime - startTime;
        System.out.println("Without Flink, Runtime: " + timer + "ms\n");
    }

}
