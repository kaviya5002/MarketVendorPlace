import com.campus.ecommerce.DBConnection;
package com.campus.ecommerce;
import java.sql.*;

public class ReportService {
    private Connection conn;

    public ReportService() {
        conn = DBConnection.getConnection();
    }

    // Total sales per vendor
    public void viewSalesByVendor() {
        String query = "SELECT u.name AS vendor_name, SUM(p.price * o.quantity) AS total_sales " +
                       "FROM orders o " +
                       "JOIN products p ON o.product_id = p.id " +
                       "JOIN users u ON p.vendor_id = u.id " +
                       "GROUP BY u.name";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n=== Sales by Vendor ===");
            System.out.printf("%-20s | %-10s\n", "Vendor Name", "Total Sales");
            System.out.println("------------------------------------");

            while (rs.next()) {
                System.out.printf("%-20s | %.2f\n",
                        rs.getString("vendor_name"),
                        rs.getDouble("total_sales"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Total platform revenue
    public void viewTotalRevenue() {
        String query = "SELECT SUM(p.price * o.quantity) AS revenue " +
                       "FROM orders o JOIN products p ON o.product_id = p.id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                System.out.println("\nTotal Platform Revenue: ₹" + rs.getDouble("revenue"));
            } else {
                System.out.println("No sales yet.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
