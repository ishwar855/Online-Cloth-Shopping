<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Success - Your Food App</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #a8e6cf, #dcedc1);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            padding: 2rem;
            width: 90%;
            max-width: 450px;
            text-align: center;
            overflow: hidden;
        }

        .card .icon {
            font-size: 5rem;
            color: #4CAF50;
            margin-bottom: 1rem;
            animation: pulse 1.5s infinite;
        }

        h1 {
            color: #2E7D32;
            font-size: 2rem;
            margin-bottom: 1rem;
        }

        p {
            color: #555;
            font-size: 1rem;
            margin-bottom: 1.5rem;
        }

        .order-number {
            background-color: #E8F5E9;
            border-radius: 8px;
            padding: 1rem;
            margin-bottom: 1.5rem;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .order-number p:first-child {
            color: #777;
            font-size: 1rem;
            margin-bottom: 0.5rem;
        }

        .order-number p:last-child {
            color: #388E3C;
            font-size: 1.6rem;
            font-weight: bold;
        }

        .info {
            margin-bottom: 1.5rem;
            font-size: 1rem;
            color: #555;
        }

        .info .time,
        .info .address {
            margin-bottom: 0.5rem;
        }

        .buttons {
            display: flex;
            justify-content: space-around;
            gap: 1.5rem;
        }

        .button {
            padding: 0.8rem 2rem;
            border-radius: 30px;
            text-decoration: none;
            font-weight: bold;
            transition: all 0.3s ease-in-out;
            display: inline-block;
            width: 45%;
            text-align: center;
        }

        .button-primary {
            background-color: #4CAF50;
            color: white;
            border: 2px solid #4CAF50;
        }

        .button-primary:hover {
            background-color: white;
            color: #4CAF50;
            border: 2px solid #4CAF50;
        }

        .button-secondary {
            background-color: #E8F5E9;
            color: #388E3C;
            border: 2px solid #388E3C;
        }

        .button-secondary:hover {
            background-color: #C8E6C9;
            color: #388E3C;
            border: 2px solid #388E3C;
        }

        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.1);
            }
            100% {
                transform: scale(1);
            }
        }

    </style>
</head>
<body>
    <div class="card">
        <div class="icon">&#10004;</div>
        <h1>Order Successful!</h1>
        <p>Thank you for your order. Your product is on its way!</p>
        <div class="order-number">
            <p>Order Number:</p>
            <p id="orderNumber">Loading...</p>
        </div>
        <div class="info">
            <div class="time">Estimated delivery time: 1-2 Days</div>
            <div class="address">Delivery address: 
                <%
                    String address = (String) session.getAttribute("address");
                    if (address == null) {
                        address = "Address not available"; // Fallback if address is not set
                    }
                %>
                <%= address %>
            </div>
        </div>
        <div class="buttons">
            <a href="track.jsp" class="button button-secondary">Track Order</a>
            <a href="home.jsp" class="button button-primary">Return to Menu</a>
        </div>
    </div>

    <script>
        // Generate a random order number
        document.getElementById('orderNumber').textContent = Math.floor(100000 + Math.random() * 900000).toString();
    </script>
</body>
</html>
