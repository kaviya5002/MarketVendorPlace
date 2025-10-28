package com.campus.ecommerce;
import java.sql.*;

public class UserService {

    public void registerUser(User u) {
        String query = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole()); // Added role field

            ps.executeUpdate();
            System.out.println("✅ User registered successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllUsers() {
        String query = "SELECT id, name, email, role FROM users"; // changed user_id → id
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\n=== User List ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Email: " + rs.getString("email") +
                                   ", Role: " + rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

