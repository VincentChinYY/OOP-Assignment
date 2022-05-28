public class PayByCreditCard implements PaymentMethod {
    CreditCard creditCard;

    @Override
    public void makePayment() {
        System.out.println("Card Number" + creditCard.getCardNumber());
    }
}
