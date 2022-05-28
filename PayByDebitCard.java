public class PayByDebitCard implements PaymentMethod {
    DebitCard debitCard;

    @Override
    public void makePayment() {
        System.out.println("Debit Card Number: " + debitCard.getCardNumber());
    }
}
