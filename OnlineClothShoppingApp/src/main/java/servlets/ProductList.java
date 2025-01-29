package servlets;

import java.io.IOException;
import java.util.List;
import DAOimpl.ProductsDAOimpl; // Import DAO implementation for Products
import dao.ProductDAO;          // Import DAO interface for Products

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Products;          // Import the Products model class

// Annotation to map this servlet to the URL "/ProductList"
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {

    /**
     * Handles HTTP requests (GET or POST) using the service method.
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve the cloth type ID and name from the request parameters
        String typeId = request.getParameter("clothTypeId"); // Cloth type ID
        String typeName = request.getParameter("clothTypeName"); // Cloth type name

        // List to store the fetched products
        List<Products> productList;

        // Check if the typeId is not null and not empty
        if (typeId != null && !typeId.isEmpty()) {
            // Convert typeId from String to integer
            int type_id = Integer.parseInt(typeId);

            // Initialize the Product DAO implementation
            ProductDAO mdao = new ProductsDAOimpl();

            // Fetch the list of products for the given cloth type ID
            productList = mdao.fetchOne(type_id);

            // Get the current session (or create a new one if it doesn't exist)
            HttpSession session = request.getSession();

            // Store the fetched products, type ID, and type name in the session
            session.setAttribute("typeId", typeId);
            session.setAttribute("ProductList", productList);
            session.setAttribute("type_Name", typeName);

            // Redirect the user to the product list page (PList.jsp)
            response.sendRedirect("PList.jsp");
        } else {
            // If typeId is null or empty, redirect the user to the failure page
            response.sendRedirect("failure.html");
        }
    }
}
