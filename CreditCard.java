public class CreditCard {
    private String cardNumber;
    private String expireDate;
    private String ccv;

    CreditCard() {
        cardNumber = "";
        expireDate = "";
        ccv = "";
    }

    CreditCard(String cardNumber, String expireDate, String ccv) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.ccv = ccv;
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

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
}
