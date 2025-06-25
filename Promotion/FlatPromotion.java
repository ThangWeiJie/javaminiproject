package Promotion;

public class FlatPromotion extends Promotion {
    private double amount;

    public FlatPromotion(String promoName, double amount) {
        super(promoName);
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double total) {
        return total - amount;
    }
}