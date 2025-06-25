package User;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void manageMenu() {
        System.out.println("Admin " + username + " is managing the menu");
    }
    
    public void viewSalesReport(double grandTotal) {
        System.out.println("Admin " + username + " is viewing sales report");
        System.out.println("Grand Total: RM" + grandTotal);
    }
}