package src.com.java.code.design;


public class PaymentDesignMainClass {

    public static void main(String[] args) {
PaymentProcessor paymentProcessor=new PaymentProcessor();
paymentProcessor.executeTransaction(new CreditCardsPayments("123456789"),100.545d);
    }
}
