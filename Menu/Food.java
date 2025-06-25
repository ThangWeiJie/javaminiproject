package Menu;

public class Food extends Menu { 

    public Food(String name, double price) { 
        setName(name);
        setPrice(price);
    }
    @Override
    public void prepare() {
        System.out.println("Preparing " + getName() + "...");
    }
}
