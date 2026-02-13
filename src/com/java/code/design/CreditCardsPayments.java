package src.com.java.code.design;

public class CreditCardsPayments implements  PaymentsMethod{
 private final String cardNumber;

    CreditCardsPayments(String cardNumber){
     this.cardNumber=cardNumber;
 }
    @Override
    public String paymentMethods(double amount) {
        return "Processing Credit Card payment of Rs." + amount + " using card: " + cardNumber;
    }
}
