public class TaxCalculator {

    double tax = 0.6;

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public double calculateTotalAfterTax(double totalBeforeTax) {
        return totalBeforeTax * (1.0 + tax);
    }
}
