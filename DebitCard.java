public class DebitCard {
    private String cardNumber;
    private String expireDate;
    private String ccv;
    private double amount;

    DebitCard() {
        cardNumber = "";
        expireDate = "";
        ccv = "";
        amount=0.0;
    }

    DebitCard(String cardNumber, String expireDate, String ccv,double amount) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.ccv = ccv;
        this.amount=amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getCcv() {
        return ccv;
    }

    public double getAmount() {
        return amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
