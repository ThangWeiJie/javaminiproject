package User;

public class Restaurant {
    private String name;
    private String location;

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addNewMenuItem(String itemName, double price) {
        System.out.println("Restaurant " + name + " added new menu item: " + 
                          itemName + " (RM" + price + ")");
    }
    
    public void prepareOrder(String orderDetails) {
        System.out.println("Restaurant " + name + " is preparing: " + orderDetails);
    }
}