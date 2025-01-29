package DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.OrderItemDAO;
import model.OrderItem;

public class OrderItemDAOimpl implements OrderItemDAO {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/clothshopping";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "kandmule";

    // SQL query for inserting an order item
    private static final String INSERT = "INSERT INTO order_item(order_id, product_id, price,quantity) VALUES(?, ?, ?, ?)";

    private Connection con;

    // Constructor to establish database connection
    public OrderItemDAOimpl() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC driver
        con = DriverManager.getConnection(URL, DB_USER, DB_PASS); // Establish connection
    }

    @Override
    public int addOrder(OrderItem order) {
        int status = 0; // Status to indicate success or failure of the operation

        try (PreparedStatement pstmt = con.prepareStatement(INSERT)) { // Auto-close the PreparedStatement
            // Set parameters for the SQL query
            pstmt.setInt(1, order.getOrderId());
            pstmt.setInt(2, order.getProductId());
            pstmt.setInt(3, order.getPrice());
            pstmt.setInt(4, order.getQuantity());

            // Execute the query and get the number of rows affected
            status = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log any SQL exceptions
        }

        return status; // Return the operation status (1 = success, 0 = failure)
    }
}
