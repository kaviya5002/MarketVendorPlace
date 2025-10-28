package com.campus.ecommerce;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class DBConnection {

    private static Connection con = null;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Properties props = new Properties();
                FileInputStream fis = new FileInputStream("db.properties");
                props.load(fis);

                String url = props.getProperty("url");
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(url, username, password);
                System.out.println("✅ Database connected successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
