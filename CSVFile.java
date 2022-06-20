import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    
    /**
     * Calculate the total product count by iterating the number of lines
     * @param filename 
     * @return total product count
     */
    public static long countLine(String filename) {
        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.readLine() != null)
                lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;  // number of lines or product
    }


    /**
     * Read from CSV and then create the object
     * @param productFilename
     * @return arraylist of products
     */
    public static List<Product> readCSVProductFile(String productFilename) {

        List<Product> products = new ArrayList<>();
        Path pathToFile = Paths.get(productFilename);

        try (BufferedReader bufferedreaderObject = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = bufferedreaderObject.readLine();

            while (line != null) {

                String[] variable = line.split(",");

                Product product = createProduct(variable);

                products.add(product);

                line = bufferedreaderObject.readLine();
            }

        } catch (Exception errorReadCSV) {
            errorReadCSV.printStackTrace();
        }

        return products;
    }


    /**
     * Create individual product in product arraylist
     * @param variable Used for constructor
     * @return Product
     */
    private static Product createProduct(String[] variable) {

        String id = variable[0];
        String name = variable[1];
        double price = Double.parseDouble(variable[2]);
        int quantity = Integer.parseInt(variable[3]);

        return new Product(id, name, price, quantity);
    }

}
