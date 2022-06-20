import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // product initiation
        String productFilename = "ProductCSV.csv";  // Product CSV filename
        int productCount = (int)CSVFile.countLine(productFilename);  
        List<Product> productArrayList = CSVFile.readCSVProductFile(productFilename);
        Product[] productListObject = new Product[productCount];
        productListObject = productArrayList.toArray(productListObject);
        
        String fileName = "Record.txt";
        CreateFile recordFile = new CreateFile();
        recordFile.createNewFile(fileName);
        Gui mainGui = new Gui(productListObject);
        mainGui.display();
    }
}
