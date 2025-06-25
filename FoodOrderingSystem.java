// FoodOrderingSystem.java
import java.util.*;
import Payment.*;
import Delivery.*;
import Feedback.*;
import Menu.*;
import Promotion.*;
import User.*;

abstract class Food {
    private String name;
    private double price;

    Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void prepare();
}

class Pizza extends Food {
    Pizza() {
        super("Hawaiian Chicken", 40.90);
    }

    public void prepare() {
        System.out.println("Preparing Hawaiian Chicken...");
    }
}

class Burger extends Food {
    Burger() {
        super("Double Cheeseburger", 18.35);
    }

    public void prepare() {
        System.out.println("Preparing Double Cheeseburger...");
    }
}

interface Order {
    public void orderFood(Food food, PaymentMethod payment, Delivery delivery, Promotion promo);
}

class OfflineOrder implements Order {
    private static final double SERVICE_CHARGE = 2.0;

    public void orderFood(Food food, PaymentMethod payment, Delivery delivery, Promotion promo) {
        food.prepare();
        System.out.println(food.getName() + " ordered offline");

        double totalPrice = food.getPrice() + SERVICE_CHARGE;

        if(promo != null) {
            if(promo instanceof FlatPromotion) {totalPrice = ((FlatPromotion)promo).applyDiscount(totalPrice);}
            else if(promo instanceof FreeDeliveryPromotion) {((FreeDeliveryPromotion)promo).applyDiscount(totalPrice);}
            else if(promo instanceof PercentagePromotion) {totalPrice = ((PercentagePromotion)promo).applyDiscount(totalPrice);}
        }

        System.out.println("Total: " + totalPrice);
        payment.processPayment();

        delivery.showDeliveryDetails();
        System.out.println("---AFTER---");
        delivery.updateStatus("Out for order");
        delivery.updateLocation("City Centre");
        delivery.showDeliveryDetails();

        System.out.println();
    }
}

class OnlineOrder implements Order {
    private static final double SERVICE_CHARGE = 1.0;

    public void orderFood(Food food, PaymentMethod paymentMethod, Delivery delivery, Promotion promo) {
        food.prepare();
        System.out.println(food.getName() + " ordered online");

        double totalPrice = food.getPrice() + SERVICE_CHARGE;

        if(promo != null) {
            if(promo instanceof FlatPromotion) {totalPrice = ((FlatPromotion)promo).applyDiscount(totalPrice);}
            else if(promo instanceof FreeDeliveryPromotion) {((FreeDeliveryPromotion)promo).applyDiscount(totalPrice);}
            else if(promo instanceof PercentagePromotion) {totalPrice = ((PercentagePromotion)promo).applyDiscount(totalPrice);}
        }

        System.out.println("Total: " + totalPrice);

        paymentMethod.processPayment();

        delivery.showDeliveryDetails();
        System.out.println("---AFTER---");
        delivery.updateStatus("Out for order");
        delivery.updateLocation("City Centre");
        delivery.showDeliveryDetails();

        System.out.println();
    }

}

class Customer {
    private String name;
    public static double grandTotal = 0;
    Order order;
    public PaymentMethod payment;

    Customer(String name, Order order, PaymentMethod payment) {
        this.name = name;
        this.order = order;
        this.payment = payment;
    }

    public void placeOrder(Food food, PaymentMethod p, Promotion promo) {
        double service_charge = 0;

        if(order instanceof OnlineOrder) {
            OnlineOrder online = (OnlineOrder) order;
            online.orderFood(food, p, new Delivery("TRK1234", "Not ready", "Restaurant"), promo);
            service_charge = 1.0;
        } else if(order instanceof OfflineOrder) {
            OfflineOrder offline = (OfflineOrder) order;
            offline.orderFood(food, p, new Delivery("TRK5678", "Not ready", "Restaurant"), promo);
            service_charge = 2.0;
        }
        
        if(promo == null) {
            grandTotal = grandTotal + food.getPrice() + service_charge;
        } else {
            grandTotal = grandTotal + promo.applyDiscount(food.getPrice()) + service_charge;

        }
    }
}

class FoodOrderingSystem {
    //Method to add a customer to the system
    public static void addCustomer(Vector<Customer> cList, Customer c) { 
        cList.add(c); 
  }

  // Method to take orders from all customers in the system
    public static void takeOrders(Vector<Customer> cList) { 
        for (Customer c: cList) { 
            c.placeOrder(new Pizza(), c.payment, null); 
            c.placeOrder(new Burger(), c.payment, new PercentagePromotion("30% Off", 30)); 
        }
    }

    public static void main(String[] args) {
	    // Create a new customer list
	    Vector<Customer> cList = new Vector<>();

	    //Add customers to the system
	    addCustomer(cList, new Customer("Ahmad", new OnlineOrder(), new Card()));
	    addCustomer(cList, new Customer("Alice", new OfflineOrder(), new Cash()));

	    //Take orders from all customers
	    takeOrders(cList);
	    System.out.printf("Grand Total Sales = RM%.2f\n",  
        Customer.grandTotal);
    }
}