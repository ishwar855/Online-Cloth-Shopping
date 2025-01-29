package DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;

public class UserDAOimpl implements UserDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/clothshopping";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "kandmule";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a new user
    @Override
    public int insert(User u) {
        String query = "INSERT INTO user (first_name, last_name, mobile, email, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, u.getFirst_name());
            statement.setString(2, u.getLast_name());
            statement.setLong(3, u.getMobile());
            statement.setString(4, u.getEmail());
            statement.setString(5, u.getPassword());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);  // Returning the generated ID of the new user
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;  // Returning -1 if insertion failed
    }

    // Method to fetch all users (for administrative purposes)
    @Override
    public List<User> fetchAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                long mobile = resultSet.getLong("mobile");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                User user = new User(id, firstName, lastName, mobile, email, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Method to fetch user by email and password (for login)
    @Override
    public User fetchUserByEmailAndPassword(String email, String password) {
        User user = null;
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            // Set email and password parameters
            ps.setString(1, email);
            ps.setString(2, password);

            // Execute query
            ResultSet rs = ps.executeQuery();

            // If user is found
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id")); // Set user ID
                user.setFirst_name(rs.getString("first_name")); // Set first name
                user.setLast_name(rs.getString("last_name"));   // Set last name
                user.setMobile(rs.getLong("mobile"));            // Set mobile number
                user.setEmail(rs.getString("email"));           // Set email
                user.setPassword(rs.getString("password"));     // Set password
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user; // Return user object or null if not found
    }

}

