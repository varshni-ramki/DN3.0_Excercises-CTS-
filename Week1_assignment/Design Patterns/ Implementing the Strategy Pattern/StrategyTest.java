public class StrategyTest {
    public static void main(String[] args) {
        // Create the payment context
        PaymentContext paymentContext = new PaymentContext();

        // Use CreditCardPayment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(250.0);

        // Use PayPalPayment strategy
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(300.0);
    }
}
