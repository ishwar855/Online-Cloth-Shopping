package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Override the doPost method to handle user registration
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/clothshopping";
        String dbUser = "root";
        String dbPassword = "kandmule";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query to insert new user into the database
            String sql = "INSERT INTO user (first_name, last_name, mobile, email, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, mobile);
            statement.setString(4, email);
            statement.setString(5, password);  // Consider hashing the password before saving it to the database

            // Execute the insert query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                // Registration successful, redirect to the login page
                response.sendRedirect("login.jsp");
            } else {
                // Registration failed
                out.println("<h3 style='color: red;'>Registration failed. Please try again.</h3>");
                out.println("<a href='register.jsp'>Back to Register</a>");
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            // Handle any exceptions that occur during the process
            e.printStackTrace();
            out.println("<h3 style='color: red;'>An error occurred. Please try again later.</h3>");
        }
    }
}
