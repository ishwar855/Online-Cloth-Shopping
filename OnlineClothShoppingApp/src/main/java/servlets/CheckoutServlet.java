package servlets;

import java.io.IOException;
import java.sql.Timestamp;
import DAOimpl.Cart;
import DAOimpl.OrderItemDAOimpl;
import DAOimpl.OrdersDAOimpl;
import dao.OrderItemDAO;
import dao.OrdersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CartItem;
import model.OrderItem;
import model.Orders;
import model.User;

// Annotation to define the servlet mapping
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
    
    // DAO instances for interacting with the database
    private OrdersDAO OrderDAO;         // For managing order-related data
    private OrderItemDAO orderItemDAO;  // For managing order item-related data

    /**
     * Initializes the servlet and DAO objects.
     */
    @Override
    public void init() throws ServletException {
        try {
            // Instantiate DAO implementations
            OrderDAO = new OrdersDAOimpl();
            orderItemDAO = new OrderItemDAOimpl();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace in case of initialization errors
        }
    }

    /**
     * Handles POST requests for the checkout process.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve the current session
        HttpSession session = request.getSession();
        
        // Retrieve the cart and logged-in user objects from the session
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("loggedInUser");
        
        // Retrieve the shipping address from the request
        String address = request.getParameter("address");
        
        // Retrieve the typeId from the session
        int typeId = Integer.parseInt((String) session.getAttribute("typeId"));
        
        // Check if the cart is not empty
        if (cart != null) {
            // Retrieve the payment method from the request
            String paymentMode = request.getParameter("paymentMethod");
            
            // Create a new `Orders` object to store order details
            Orders order = new Orders();
            order.setUserId(user.getId());                  // Set the user ID
            order.setTypeId(typeId);                       // Set the type ID
            order.setOrder_date(new Timestamp(0));         // Set the order date (currently hardcoded)
            order.setPaymentMode(paymentMode);             // Set the payment mode
            order.setStatus("pending");                    // Set the initial status to "pending"

            // Variables to calculate total order amount and store order details
            int totalAmount = 0; // Total amount of the order
            int quantity = 0;    // Quantity of the product
            int proId = 0;       // Product ID

            // Iterate through the cart items to calculate the total amount and retrieve details
            for (CartItem item : cart.getItems().values()) {
                proId = item.getItemId();                         // Get the product ID
                quantity = item.getQuantity();                    // Get the quantity of the item
                totalAmount += item.getQuantity() * item.getPrice(); // Calculate total amount
            }
            order.setTotalAmount(totalAmount); // Set the total amount in the order
            
            // Add the order to the database and get the result
            int find = OrderDAO.addOrder(order);

            // Create and populate an `OrderItem` object to store item details
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(typeId);            // Set the order ID
            orderItem.setProductId(proId);           // Set the product ID
            orderItem.setPrice(totalAmount);         // Set the price
            orderItem.setQuantity(quantity);         // Set the quantity

            // Add the order item to the database and get the result
            int find2 = orderItemDAO.addOrder(orderItem);

            // Check if both the order and order item were successfully added
            if (find != 0 && find2 != 0) {
                // Store the address and order ID in the session
                session.setAttribute("address", address);
                session.setAttribute("orderId", typeId);

                // Redirect to the order confirmation page
                response.sendRedirect("orderConfirm.jsp");
            } else {
                // If the order creation fails, redirect to the home page
                response.sendRedirect("home.jsp");
            }
        } else {
            // If the cart is empty, redirect to the home page
            response.sendRedirect("home.jsp");
        }
    }
}
