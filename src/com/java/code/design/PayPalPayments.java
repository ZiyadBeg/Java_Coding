package src.com.java.code.design;

public class PayPalPayments implements PaymentsMethod {
    private final String email;

    public PayPalPayments(String email) {
        this.email = email;
    }

    @Override
    public String paymentMethods(double amount) {
        return "Processing PayPal payment of Rs." + amount + " for email: " + email;
    }
}
