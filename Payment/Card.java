package Payment;

public class Card implements PaymentMethod {
    public void processPayment() {
        System.out.println("This order has been paid using debit card.");
    }
}
