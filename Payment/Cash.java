package Payment;

public class Cash implements PaymentMethod {
    public void processPayment() {
        System.out.println("This order has been paid using cash.");
    }
}
