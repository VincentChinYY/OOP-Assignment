public class PayByCreditCard implements PaymentMethod {
    CreditCard creditCard;

    public PayByCreditCard(CreditCard creditCard){
        this.creditCard=creditCard;
    }

    @Override
    public void makePayment(double totalAfterTax) {
        System.out.println("Total: RM" + Math.round(totalAfterTax * 100.0) / 100.0);
        System.out.println("Card Number: " + creditCard.getCardNumber());
        System.out.println("Expire Date: "+creditCard.getExpireDate());
        System.out.println("CCV: "+creditCard.getCcv());
    }
}
