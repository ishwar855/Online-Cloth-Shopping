package DAOimpl;

import dao.ClothTypeDAO;
import model.ClothTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothTypeDAOimpl implements ClothTypeDAO {

    // Database connection constants (replace with your actual DB details)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/clothshopping"; // Update with your database URL
    private static final String DB_USER = "root"; // Replace with your database username
    private static final String DB_PASSWORD = "kandmule"; // Replace with your database password

    // Method to fetch all cloth types from the database
    @Override
    public List<ClothTypes> fetchAll() {
        List<ClothTypes> clothTypesList = new ArrayList<>();
        String query = "SELECT * FROM categories"; // Query to fetch cloth types from the 'clothtypes' table

        // Single try-catch block for all operations
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set and add to the list
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String imgUrl = rs.getString("img_url");

                // Create a new ClothTypes object and add it to the list
                ClothTypes clothType = new ClothTypes(id, name, description, imgUrl);
                clothTypesList.add(clothType);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log the exception
        }

        return clothTypesList;
    }
}
