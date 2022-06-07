import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public ReadFile() {

    }

    public String readData(String fileName) {
        String data = "";
        try {
            File myObj = new File("Record.txt");
            Scanner myReader = new Scanner(myObj);

            // Read all the line in the file
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException error) {
            error.printStackTrace();
            System.out.println("File Not Existed.");
        }
        return data;
    }
}
