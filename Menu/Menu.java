package Menu;

//Menu
public abstract class Menu { 
    private double price;
    private String name;

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void prepare(); 
}


