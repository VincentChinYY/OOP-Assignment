public class Main {
    public static void main(String[] args) {
        Product productListObject[];
        productListObject = new Product[5];
        Product product1 = new Product("A001", "Product 1 Name", 10.00, 100);
        Product product2 = new Product("A002", "Product 2 Name", 20.00, 10);
        Product product3 = new Product("A003", "Product 3 Name", 30.00, 200);
        Product product4 = new Product("A004", "Product 4 Name", 40.00, 5);
        Product product5 = new Product("A005", "Product 5 Name", 50.00, 50);

        productListObject[0] = product1;
        productListObject[1] = product2;
        productListObject[2] = product3;
        productListObject[3] = product4;
        productListObject[4] = product5;
        
        String fileName = "Record.txt";
        CreateFile recordFile = new CreateFile();
        recordFile.createNewFile(fileName);
        Gui mainGui = new Gui(productListObject);
        mainGui.display();
    }
}