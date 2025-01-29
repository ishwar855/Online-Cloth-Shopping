package servlets;

import java.io.IOException;
import DAOimpl.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;
import java.util.logging.Logger;

// Annotation to define the servlet mapping
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Unique identifier for the servlet (used during deserialization)
    
    // Logger for logging important messages, errors, and actions for debugging or monitoring
    private static final Logger LOGGER = Logger.getLogger(CartServlet.class.getName());

    /**
     * Handles POST requests for cart operations such as adding, removing, increasing, 
     * or decreasing item quantities.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve the current session or create a new one if it doesn't exist
        HttpSession session = request.getSession();
        
        // Retrieve the cart object from the session
        Cart cart = (Cart) session.getAttribute("cart");
        
        // If the cart does not exist in the session, create a new one and set it in the session
        if (cart == null) {
            cart = new Cart(); // Create a new cart instance
            session.setAttribute("cart", cart); // Save the new cart in the session
        }
        
        try {
            // Get the action parameter from the request (e.g., add, remove, increase, decrease)
            String action = request.getParameter("action");
            LOGGER.info("Action: " + action); // Log the action being performed

            if ("add".equals(action)) { // Check if the action is to add an item to the cart
                // Parse item details from the request parameters
                int itemId = Integer.parseInt(request.getParameter("productId")); // Item ID
                int typeId = Integer.parseInt(request.getParameter("typeId")); // Type ID (if applicable)
                int itemPrice = Integer.parseInt(request.getParameter("price")); // Item price
                String itemName = request.getParameter("productName"); // Item name
                String imgPath = request.getParameter("productImage"); // Path to the item's image
                
                // If the item name is null or empty, assign a default name
                if (itemName == null || itemName.isEmpty()) {
                    itemName = "Unknown Item"; // Default item name
                }
                
                // Create a new CartItem object with the parsed details
                CartItem newItem = new CartItem(itemId, typeId, itemName, itemPrice, 1, imgPath);
                
                // Add the item to the cart
                cart.addItem(newItem);
                LOGGER.info("Added item: " + newItem); // Log the addition of the item
            } else {
                // For other actions (remove, increase, decrease), parse the item ID from the request
                int itemId = Integer.parseInt(request.getParameter("itemId"));
                switch (action) {
                    case "remove": // Remove the item from the cart
                        cart.removeItem(itemId);
                        LOGGER.info("Removed item: " + itemId); // Log the removal
                        break;
                    case "increase": // Increase the item's quantity in the cart
                        cart.increaseQuantity(itemId);
                        LOGGER.info("Increased quantity for item: " + itemId); // Log the increase
                        break;
                    case "decrease": // Decrease the item's quantity in the cart
                        cart.decreaseQuantity(itemId);
                        LOGGER.info("Decreased quantity for item: " + itemId); // Log the decrease
                        break;
                }
            }
        } catch (Exception e) {
            // Log any exception that occurs during the request processing
            LOGGER.severe("Error processing request: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
        }
        
        // After processing, update the cart object in the session
        session.setAttribute("cart", cart);
        
        // Log the size of the cart after the operation
        LOGGER.info("Cart size after operation: " + cart.getItems().size());
        
        // Redirect the user to the cart.jsp page to display the updated cart
        response.sendRedirect("cart.jsp");
    }
}
