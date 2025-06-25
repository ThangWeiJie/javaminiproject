package User;

public class Driver {
    private String name;
    private String vehicleType;

    public Driver(String name, String vehicleType) {
        this.name = name;
        this.vehicleType = vehicleType;
    }

    public void deliverOrder(String orderDetails) {
        System.out.println("Driver " + name + " (" + vehicleType + 
                          ") is delivering: " + orderDetails);
    }

    public void updateDeliveryStatus(String status) {
        System.out.println("Delivery status updated to: " + status);
    }
}