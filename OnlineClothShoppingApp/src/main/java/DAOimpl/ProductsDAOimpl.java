package DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import model.Products;

public class ProductsDAOimpl implements ProductDAO {
    // Database credentials and URL
    static String url = "jdbc:mysql://localhost:3306/clothshopping";
    static String dbUser = "root";
    static String dbPass = "kandmule";

    // Query to fetch products by type_id
    static String query = "SELECT * FROM products WHERE type_id=?";
    
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet resultSet;

    @Override
    public List<Products> fetchOne(int type_id) {
        List<Products> pList = new ArrayList<>();
        
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            con = DriverManager.getConnection(url, dbUser, dbPass);

            // Prepare the SQL statement
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, type_id); // Set the type_id parameter

            // Execute the query
            resultSet = pstmt.executeQuery();

            // Iterate through the result set and populate the products list
            while (resultSet.next()) {
                pList.add(new Products(
                    resultSet.getInt("product_id"),
                    resultSet.getInt("type_id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getInt("price"),
                    resultSet.getString("img_path"),
                    resultSet.getFloat("ratings")
                    
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details if any
        } 
        
        return pList;
    }
}
