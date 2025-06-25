package Payment;

public class EWallet implements PaymentMethod {
    public void processPayment() {
        System.out.println("This order has been paid using E-Wallet.");
    }
}
