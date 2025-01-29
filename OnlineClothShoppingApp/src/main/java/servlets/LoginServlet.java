package servlets;

import dao.UserDAO;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import DAOimpl.UserDAOimpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        // Initialize the UserDAO implementation
        userDAO = new UserDAOimpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve email and password from the request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate input
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Email and Password are required.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Fetch all users and check credentials
        List<User> allUsers = userDAO.fetchAll(); // Using the fetch-all method
        User matchedUser = null;

        for (User user : allUsers) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                matchedUser = user;
                break;
            }
        }

        if (matchedUser != null) {
            // Valid login, set session attributes
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", matchedUser); // Store User object in the session
            response.sendRedirect("GetClothTypes"); // Redirect to GetMedicineTypes servlet
        } else {
            // Invalid login, show error message
            request.setAttribute("error", "Invalid Email or Password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
