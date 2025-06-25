package Promotion;

public class PercentagePromotion extends Promotion {
    private double percent;

    public PercentagePromotion(String promoName, double percent) {
        super(promoName);
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double total) {
        return total - (total * percent / 100.0);
    }
}