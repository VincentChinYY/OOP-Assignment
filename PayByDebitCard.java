public class PayByDebitCard implements PaymentMethod {
    DebitCard debitCard;

    public PayByDebitCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    @Override
    public void makePayment(double totalAfterTax) {
        System.out.println("Total: RM" + Math.round(totalAfterTax * 100.0) / 100.0);

        System.out.println("Debit Card Number: " + debitCard.getCardNumber());
        System.out.println("Expire Date: "+debitCard.getExpireDate());
        System.out.println("CCV: "+debitCard.getCcv());
    }
}
