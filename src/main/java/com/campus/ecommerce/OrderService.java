package com.campus.ecommerce;
import java.sql.*;
import java.util.Scanner;

public class OrderService {

    public void placeOrder(int buyerId) {
        Scanner sc = new Scanner(System.in);
        double total = 0;

        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            System.out.println("\n=== 🛍 Available Products ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Price: ₹" + rs.getDouble("price") +
                                   ", Stock: " + rs.getInt("stock"));
            }

            System.out.print("\nEnter product ID to buy: ");
            int productId = sc.nextInt();
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            // Get product details
            PreparedStatement ps = con.prepareStatement("SELECT price, stock FROM products WHERE id=?");
            ps.setInt(1, productId);
            ResultSet productRs = ps.executeQuery();

            if (productRs.next()) {
                double price = productRs.getDouble("price");
                int stock = productRs.getInt("stock");

                if (quantity > stock) {
                    System.out.println("❌ Not enough stock available!");
                    return;
                }

                total = price * quantity;

                // Insert into orders table
                PreparedStatement orderStmt = con.prepareStatement(
                    "INSERT INTO orders (user_id, total) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
                orderStmt.setInt(1, buyerId);
                orderStmt.setDouble(2, total);
                orderStmt.executeUpdate();

                // Get order ID
                ResultSet keys = orderStmt.getGeneratedKeys();
                keys.next();
                int orderId = keys.getInt(1);

                // Insert into order_items
                PreparedStatement itemStmt = con.prepareStatement(
                    "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)");
                itemStmt.setInt(1, orderId);
                itemStmt.setInt(2, productId);
                itemStmt.setInt(3, quantity);
                itemStmt.executeUpdate();

                // Update stock
                PreparedStatement updateStock = con.prepareStatement(
                    "UPDATE products SET stock = stock - ? WHERE id = ?");
                updateStock.setInt(1, quantity);
                updateStock.setInt(2, productId);
                updateStock.executeUpdate();

                System.out.println("✅ Order placed successfully! Total: ₹" + total);
            } else {
                System.out.println("❌ Product not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllOrders() {
        String query = "SELECT id, user_id, total, order_date FROM orders";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\n=== 📦 Orders List ===");
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("id") +
                                   ", Buyer ID: " + rs.getInt("user_id") +
                                   ", Total: ₹" + rs.getDouble("total") +
                                   ", Date: " + rs.getTimestamp("order_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
