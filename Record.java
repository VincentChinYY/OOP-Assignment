import java.util.ArrayList;

public class Record {
    PaymentMethod paymentMethod;
    TaxCalculator taxCalculator = new TaxCalculator();

    private Customer customer;
    private ArrayList<Product> products = new ArrayList<Product>();

    // private String branchName;
    // private String branchLocation;
    private String recordId;
    private String date;
    private double totalBeforeTax;
    private double totalAfterTax;
    private double tax;

    private CreditCard creditCard;
    private DebitCard debitCard;
    private double cash;

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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public double getCash() {
        return cash;
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

    public void setCreditCard(String cardNumber,String expireDate,String ccv) {
        this.creditCard = new CreditCard(cardNumber, expireDate, ccv);
    }

    public void setDebitCard(String cardNumber,String expireDate,String ccv,double cash) {
        this.debitCard = new DebitCard(cardNumber,expireDate,ccv,cash);
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setPaymentMethod(String paymentMethod) {
        if(paymentMethod=="creditCard"){
            this.paymentMethod=new PayByCreditCard(creditCard);
        }else if(paymentMethod=="debitCard"){
            this.paymentMethod=new PayByDebitCard(debitCard);
        }else{
            this.paymentMethod=new PayByCash(cash);
        }
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
        totalAfterTax = taxCalculator.calculateTotalAfterTax(totalBeforeTax);
    }

    public void processOrder() {
         paymentMethod.makePayment(totalAfterTax);
    }

    public void calculateTotal(Product product,int quantity){
        totalBeforeTax+=product.getPrice()*quantity;
        calculateTotalAfterTax();
    }
}
