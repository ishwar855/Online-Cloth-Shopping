package servlets;

import DAOimpl.ClothTypeDAOimpl; // Import DAO implementation
import dao.ClothTypeDAO;         // Import DAO interface
import model.ClothTypes;         // Import ClothTypes model class
import model.User;               // Import User model class

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

// Annotation to define the servlet mapping
@WebServlet("/GetClothTypes")
public class GetClothTypes extends HttpServlet {

    // DAO instance for fetching cloth types from the database
    private ClothTypeDAO clothTypeDAO;

    /**
     * Initializes the servlet by setting up the DAO instance.
     */
    @Override
    public void init() throws ServletException {
        // Initialize the DAO implementation for cloth types
        clothTypeDAO = new ClothTypeDAOimpl();
    }

    /**
     * Handles GET requests to fetch cloth types.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve the current session without creating a new one (if it doesn't exist)
        HttpSession session = request.getSession(false);

        // Check if a logged-in user is stored in the session
        User loggedInUser = (session != null) ? (User) session.getAttribute("loggedInUser") : null;

        if (loggedInUser == null) {
            // If no logged-in user exists, redirect to the login page
            response.sendRedirect("login.html");
            return; // Stop further execution
        }

        // Fetch the list of cloth types from the database using the DAO
        List<ClothTypes> clothTypesList = clothTypeDAO.fetchAll();

        // Store the retrieved list of cloth types in the session
        session.setAttribute("clothTypesList", clothTypesList);

        // Redirect the user to the home page (or another appropriate page)
        response.sendRedirect("home.jsp");
    }
}
