public class PayByCash implements PaymentMethod {

    double cash;

    public PayByCash(double cash) {
        this.cash = cash;
    }

    @Override
    public void makePayment(double totalAfterTax) {
        System.out.println("Total: RM" + Math.round(totalAfterTax * 100.0) / 100.0);
        System.out.println("Pay By Cash: " + cash);
        System.out.println("Change: " + Math.round((cash - totalAfterTax) * 100.0) / 100.0);
    }
}
