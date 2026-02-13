package src.com.java.code.design;

public class PaymentProcessor {
    // Synchronized method taake double-spending na ho

    public synchronized void executeTransaction(PaymentsMethod method, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
      String success=  method.paymentMethods(amount);
        System.out.println(success+"\n");
        System.out.println("Transaction Successful!\n");
    }
}
