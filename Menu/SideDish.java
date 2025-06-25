package Menu;

public class SideDish extends Menu {
    private boolean isSweet;
    private boolean isSavory;

    public SideDish(String name, double price, boolean isSweet, boolean isSavory) {
        setName(name);
        setPrice(price);
        this.isSweet = isSweet;
        this.isSavory = isSavory;
    }

    
    public boolean isSweet() {
        return isSweet;
    }

    public boolean isSavory() {
        return isSavory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName() + (isSweet ? " (Sweet)" : "") + (isSavory ? " (Savory)" : "") + "...");
    }
}
