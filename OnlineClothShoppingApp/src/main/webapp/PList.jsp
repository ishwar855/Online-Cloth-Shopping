<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.Products" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        /* Basic styling for the page */
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        h1, h2 {
            text-align: center;
            color: #333;
            margin-top: 30px;
            font-weight: 700;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }

        .card {
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .card img {
            width: 100%;
            height: 250px;
            object-fit: cover;
            border-bottom: 2px solid #ddd;
        }

        .card-content {
            padding: 15px;
            text-align: center;
        }

        .card-content h2 {
            color: #333;
            font-size: 1.6rem;
            margin: 15px 0;
        }

        .card-content p {
            color: #666;
            font-size: 1rem;
            line-height: 1.5;
            margin-bottom: 10px;
        }

        .card-footer {
            background-color: #f9f9f9;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .price {
            font-weight: bold;
            font-size: 1.3rem;
            color: #2c8b59;
        }

        .add-to-cart-btn {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1rem;
            transition: background-color 0.3s ease;
        }

        .add-to-cart-btn:hover {
            background-color: #218838;
        }

        .no-products {
            text-align: center;
            color: #555;
            font-size: 1.2rem;
            margin-top: 50px;
        }

        .product-grid .card img {
            transition: transform 0.3s ease;
        }

        .product-grid .card:hover img {
            transform: scale(1.05);
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .product-grid {
                grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            }
        }

        @media (max-width: 480px) {
            .product-grid {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>

<%
    // Retrieve category name from session
    String typeName = (String) session.getAttribute("type_Name");
    if (typeName != null && !typeName.isEmpty()) {
%>
    <h1>Products in <%= typeName %> Category</h1>
<%
    } else {
%>
    <h2>Category Name Not Available</h2>
<%
    }

    // Retrieve the list of products from session
    List<Products> pList = (List<Products>) session.getAttribute("ProductList");

    if (pList == null || pList.isEmpty()) {
%>
        <p class="no-products">No products available in this category.</p>
<%
    } else {
%>
        <div class="product-grid">
            <%
                // Loop through each product and display them
                for (Products p : pList) {
            %>
                <div class="card">
                    <a href="Cart?productId=<%= p.getProduct_id() %>">
                        <img src="<%= request.getContextPath() + "/" + p.getImg_path() %>" alt="<%= p.getName() %>">
                   	
                    </a>
                    <div class="card-content">
                        <h2><%= p.getName() %></h2>
                        <p><%= p.getDescription() %></p>
                        <p><%= p.getRatings() %> / 5</p>
                        <p><small>Product ID: <%= p.getProduct_id() %></small></p>
                    </div>
                    <div class="card-footer">
                        <span class="price">₹<%= p.getPrice() %></span>
                        <form action="CartServlet" method="post">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="productId" value="<%= p.getProduct_id() %>">
                            <input type="hidden" name="price" value="<%= p.getPrice() %>">
                            <input type="hidden" name="typeId" value="<%= p.getType_id() %>">
                            <input type="hidden" name="productName" value="<%= p.getName() %>">
                            <input type="hidden" name="productImage" value="<%= p.getImg_path() %>">
                            <button type="submit" class="add-to-cart-btn">Add to Cart</button>
                        </form>
                    </div>
                </div>
            <%
                }
            %>
        </div>
<%
    }
%>

</body>
</html>
