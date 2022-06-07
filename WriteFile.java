import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteFile {

    public void write(String data, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(data);
            fw.close();
        } catch (IOException error) {
            error.printStackTrace();
            System.out.println("An error occurred.");
        }
    }

    public void writeAppend(String data, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException error) {
            System.out.println("An error occurred.");
            error.printStackTrace();
        }
    }
}
