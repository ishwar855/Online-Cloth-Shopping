<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Track Your Order</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f7fc;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            max-width: 900px;
            margin: 30px auto;
            background: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        .header {
            text-align: center;
            margin-bottom: 40px;
        }

        .header h1 {
            font-size: 2.5rem;
            color: #333;
            font-weight: 600;
        }

        .order-info {
            text-align: center;
            margin-bottom: 40px;
        }

        .order-info p {
            font-size: 18px;
            color: #555;
        }

        .steps {
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: relative;
            margin: 30px 0;
            padding: 0 10px;
        }

        .step {
            text-align: center;
            position: relative;
            z-index: 1;
            flex: 1;
        }

        .step-circle {
            width: 60px;
            height: 60px;
            border-radius: 50%;
            background: #ccc;
            margin: 0 auto 10px;
            line-height: 60px;
            color: white;
            font-weight: bold;
            font-size: 20px;
            transition: background-color 0.3s;
        }

        .step.active .step-circle {
            background: #4CAF50;
        }

        .step p {
            font-size: 16px;
            color: #555;
        }

        .step-line {
            position: absolute;
            top: 27px;
            left: 0;
            right: 0;
            height: 4px;
            background: #ccc;
            z-index: 0;
        }

        .step-line-active {
            position: absolute;
            top: 27px;
            left: 0;
            height: 4px;
            background: #4CAF50;
            z-index: 1;
            width: 50%; /* Adjust dynamically for active steps */
        }

        .button {
            display: block;
            background-color: #4CAF50;
            color: white;
            padding: 12px 30px;
            font-size: 18px;
            text-align: center;
            border-radius: 25px;
            text-decoration: none;
            margin: 20px auto;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Track Your Order</h1>
        </div>
        <div class="order-info">
            <% 
                Object orderIdObj = session.getAttribute("orderId");
                String orderId = (orderIdObj != null) ? String.valueOf(orderIdObj) : "Not Available";
            %>
            <p><strong>Order ID:</strong> <%= orderIdObj != null ? orderIdObj : "Not Available" %></p>
            <p><strong>Estimated Delivery:</strong> 1-2 Days</p>
        </div>
        <div class="steps">
            <!-- Step 1: Order Placed -->
            <div class="step active">
                <div class="step-circle">1</div>
                <p>Order Placed</p>
            </div>
            <!-- Line Between Steps -->
            <div class="step-line"></div>
            <div class="step-line-active"></div>
            <!-- Step 2: Dispatched -->
            <div class="step active">
                <div class="step-circle">2</div>
                <p>Dispatched</p>
            </div>
            <!-- Line Between Steps -->
            <div class="step-line"></div>
            <div class="step-line-active"></div>
            <!-- Step 3: Out for Delivery -->
            <div class="step">
                <div class="step-circle">3</div>
                <p>Out for Delivery</p>
            </div>
            <!-- Line Between Steps -->
            <div class="step-line"></div>
            <div class="step-line-active"></div>
            <!-- Step 4: Delivered -->
            <div class="step">
                <div class="step-circle">4</div>
                <p>Delivered</p>
            </div>
        </div>
        <a href="home.jsp" class="button">Return to Menu</a>
    </div>
</body>
</html>
