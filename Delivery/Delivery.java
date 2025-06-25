package Delivery;

public class Delivery {
    private Tracking tracking;
    private Status status;
    private Location location;

    public Delivery(String trackingNumber, String initialStatus, String initialLocation) {
        this.tracking = new Tracking(trackingNumber);
        this.status = new Status(initialStatus);
        this.location = new Location(initialLocation);
    }

    public void updateStatus(String newStatus) {
        this.status.setStatus(newStatus);
    }

    public void updateLocation(String newLocation) {
        this.location.setLocation(newLocation);
    }

    public void showDeliveryDetails() {
        System.out.println("Tracking Number: " + tracking.getTrackingNumber());
        System.out.println("Status: " + status.getStatus());
        System.out.println("Location: " + location.getLocation());
    }
}
