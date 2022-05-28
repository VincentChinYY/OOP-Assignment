public class PayByCash implements PaymentMethod {
    @Override
    public void makePayment() {
        System.out.println("Pay By Cash: ");
        System.out.println("Change: ");
    }
}
