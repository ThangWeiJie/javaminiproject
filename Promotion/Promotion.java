package Promotion;

public abstract class Promotion {
    protected String promoName;

    public Promotion(String promoName) {
        this.promoName = promoName;
    }

    public String getPromoName() {
        return promoName;
    }

    public abstract double applyDiscount(double total);
}






