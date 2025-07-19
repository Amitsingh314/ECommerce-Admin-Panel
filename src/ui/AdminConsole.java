package ui;

import dao.ProductDAO;
import dao.CustomerDAO;
import dao.OrderDAO;
import model.Product;
import model.Customer;
import model.Order;
import java.util.*;

public class AdminConsole {
    static Scanner sc = new Scanner(System.in);
    static ProductDAO productDAO = new ProductDAO();
    static CustomerDAO customerDAO = new CustomerDAO();
    static OrderDAO orderDAO = new OrderDAO();

    public static void showMenu() {
        while (true) {
            System.out.println("\n=== Admin Panel ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. View Customers");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> viewCustomers();
                case 4 -> viewOrders();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addProduct() {
        Product p = new Product();
        System.out.print("Product Name: "); p.setName(sc.next());
        System.out.print("Description: "); p.setDescription(sc.next());
        System.out.print("Price: "); p.setPrice(sc.nextDouble());
        System.out.print("Stock: "); p.setStock(sc.nextInt());
        try {
            productDAO.addProduct(p);
            System.out.println("Product added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewProducts() {
        try {
            for (Product p : productDAO.getAllProducts()) {
                System.out.println(p.getId() + ": " + p.getName() + " - ₹" + p.getPrice() + ", Stock: " + p.getStock());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewCustomers() {
        try {
            for (Customer c : customerDAO.getAllCustomers()) {
                System.out.println(c.getId() + ": " + c.getName() + ", Email: " + c.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewOrders() {
        try {
            for (Order o : orderDAO.getAllOrders()) {
                System.out.println("Order ID: " + o.getId() + ", Customer ID: " + o.getCustomerId() + ", Product ID: " + o.getProductId() + ", Quantity: " + o.getQuantity() + ", Status: " + o.getStatus());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
