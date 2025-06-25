package Promotion;

public class FreeDeliveryPromotion extends Promotion {
    public FreeDeliveryPromotion(String promoName) {
        super(promoName);
    }

    @Override
    public double applyDiscount(double total) {
        System.out.println("Free delivery applied.");
        return total;
    }
}