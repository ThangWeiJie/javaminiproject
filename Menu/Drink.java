
package Menu;

public class Drink extends Menu {
    private int volumeInMl;
    private boolean isCold;

    public Drink(String name, double price, int volumeInMl, boolean isCold) { 
        setName(name);
        setPrice(price);
        this.volumeInMl = volumeInMl;
        this.isCold = isCold;
    }

    // Getters for new attributes
    public int getVolumeInMl() {
        return volumeInMl;
    }

    public boolean isCold() {
        return isCold;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName() + " (" + volumeInMl + "ml, " + (isCold ? "cold" : "hot") + ")...");
    }
}
