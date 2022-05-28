import java.util.ArrayList;

public class Record {
    PaymentMethod paymentMethod;
    TaxCalculator taxCalculator;

    private Customer customer;
    private ArrayList<Product> products = new ArrayList<Product>();

    // private String branchName;
    // private String branchLocation;
    private String recordId;
    private String date;
    private double totalBeforeTax;
    private double totalAfterTax;
    private double tax;

    Record() {
        // this.branchName="";
        // this.branchLocation="";
        this.recordId = "";
        this.date = "";
        this.totalBeforeTax = 0.0;
        this.totalAfterTax = 0.0;
        this.tax = 0.0;
    }

    Record(String recordId, String date, double totalBeforeTax, double totalAfterTax, double tax) {
        this.recordId = recordId;
        this.date = date;
        this.totalBeforeTax = totalBeforeTax;
        this.totalAfterTax = totalAfterTax;
        this.tax = tax;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getDate() {
        return date;
    }

    public double getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public double getTotalAfterTax() {
        return totalAfterTax;
    }

    public double getTax() {
        return tax;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalBeforeTax(double totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }

    public void setTotalAfterTax(double totalAfterTax) {
        this.totalAfterTax = totalAfterTax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void addProduct(Product product) {
        products.add(product);
        calculateTotalBeforeTax();
        calculateTotalAfterTax();
    }

    public void calculateTotalBeforeTax() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        totalBeforeTax = total;
    }

    public void calculateTotalAfterTax() {
        totalAfterTax= taxCalculator.calculateTotalAfterTax(totalBeforeTax);
    }

    public void processOrder(){
        paymentMethod.makePayment();
    }
}
