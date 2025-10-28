package com.campus.ecommerce;
import java.sql.*;

public class ProductService {

    public void addProduct(Product p) {
        String query = "INSERT INTO products (name, price, stock, vendor_id) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getVendorId()); // ✅ vendor_id from user

            ps.executeUpdate();
            System.out.println("✅ Product added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllProducts() {
        String query = "SELECT id, name, price, stock, vendor_id FROM products";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\n=== Product List ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Price: ₹" + rs.getDouble("price") +
                                   ", Stock: " + rs.getInt("stock") +
                                   ", Vendor ID: " + rs.getInt("vendor_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
