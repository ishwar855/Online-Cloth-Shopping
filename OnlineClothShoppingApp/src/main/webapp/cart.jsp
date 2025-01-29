<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, DAOimpl.Cart, model.CartItem" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .cart-item {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            padding: 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .cart-item img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 4px;
        }
        .item-details {
            flex-grow: 1;
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-right: 20px;
        }
        .item-info {
            flex-grow: 1;
        }
        .item-info h3 {
            margin: 0 0 10px 0;
            color: #333;
        }
        .price {
            font-weight: bold;
            color: #e53935;
        }
        .quantity-control {
            display: flex;
            align-items: center;
            margin: 10px 0;
        }
        .quantity-btn {
            background-color: #f0f0f0;
            border: none;
            color: #333;
            font-size: 18px;
            width: 30px;
            height: 30px;
            cursor: pointer;
            border-radius: 4px;
        }
        .quantity-btn:hover {
            background-color: #e0e0e0;
        }
        .quantity {
            margin: 0 10px;
            font-size: 16px;
        }
        .remove-btn {
            background-color: #e53935;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 14px;
        }
        .remove-btn:hover {
            background-color: #c62828;
        }
        .total {
            text-align: right;
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
        }
        .action-btn {
            display: inline-block;
            background-color: #4caf50;
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 4px;
            font-size: 16px;
            margin-right: 10px;
        }
        .action-btn:hover {
            background-color: #45a049;
        }
        .action-btn.disabled {
            background-color: #cccccc;
            cursor: not-allowed;
        }
        .empty-cart {
            text-align: center;
            font-size: 18px;
            color: #666;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Shopping Cart</h1>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            Map<Integer, CartItem> items = (cart != null) ? cart.getItems() : new HashMap<>();
            double totalAmount = 0;
        %>
        <% if (items.isEmpty()) { %>
            <p class="empty-cart">Your cart is empty.</p>
        <% } else { %>
            <% for (CartItem item : items.values()) {
                totalAmount += item.getPrice() * item.getQuantity();
            %>
                <div class="cart-item">
                    <div class="item-details">
                        <div class="item-info">
                            <h3><%= item.getProductName() %></h3>
                            <p class="price">Price: Rs. <%= item.getPrice() %></p>
                            <div class="quantity-control">
                                <form action="CartServlet" method="post" style="display: inline;">
                                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                    <input type="hidden" name="action" value="decrease">
                                    <button type="submit" class="quantity-btn">-</button>
                                </form>
                                <span class="quantity"><%= item.getQuantity() %></span>
                                <form action="CartServlet" method="post" style="display: inline;">
                                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                    <input type="hidden" name="action" value="increase">
                                    <button type="submit" class="quantity-btn">+</button>
                                </form>
                            </div>
                            <p>Total: Rs. <%= item.getPrice() * item.getQuantity() %></p>
                            <form action="CartServlet" method="post">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <input type="hidden" name="action" value="remove">
                                <button type="submit" class="remove-btn">Remove</button>
                            </form>
                        </div>
                    </div>
                    <img src="<%= request.getContextPath() + "/" + item.getImageUrl() %>" alt="<%= item.getProductName() %>" onerror="this.src='<%= request.getContextPath() %>/images/placeholder.jpg'">
                </div>
            <% } %>
            <div class="total">
                <h3>Grand Total: Rs. <%= String.format("%.2f", totalAmount) %></h3>
            </div>
        <% } %>
        <div>
            <a href="PList.jsp" class="action-btn">Add More Items</a>
            <% if (!items.isEmpty()) { %>
                <a href="checkout.jsp" class="action-btn">Proceed to Checkout</a>
            <% } else { %>
                <span class="action-btn disabled">Proceed to Checkout</span>
            <% } %>
        </div>
    </div>
</body>
</html>

