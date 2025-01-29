<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #1d2671, #c33764);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #fff;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
            padding: 40px;
            width: 400px;
            text-align: center;
        }
        .login-container h2 {
            margin-bottom: 20px;
            font-size: 28px;
            color: #fff;
            text-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        }
        .login-container input {
            width: 100%;
            padding: 14px;
            margin: 10px 0;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            color: #333;
            background: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: box-shadow 0.3s ease-in-out;
        }
        .login-container input:focus {
            outline: none;
            box-shadow: 0 0 8px rgba(29, 38, 113, 0.6);
        }
        .login-container button {
            width: 100%;
            padding: 14px;
            margin-top: 20px;
            background: linear-gradient(45deg, #ff512f, #dd2476);
            color: white;
            font-size: 18px;
            font-weight: bold;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .login-container button:hover {
            transform: translateY(-3px);
            box-shadow: 0 12px 20px rgba(0, 0, 0, 0.4);
        }
        .login-container .footer {
            margin-top: 20px;
            font-size: 14px;
            color: #ddd;
        }
        .login-container .footer a {
            color: #ff6f61;
            text-decoration: none;
            font-weight: bold;
        }
        .login-container .footer a:hover {
            text-decoration: underline;
        }
        .error-message {
            color: #ff4d4d;
            font-size: 14px;
            margin-bottom: 15px;
            animation: fadeIn 0.5s ease-in-out;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-10px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login to Your Account</h2>
        <% if (request.getAttribute("error") != null) { %>
            <div class="error-message">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>
        <form action="LoginServlet" method="post">
            <input type="text" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <div class="footer">
            <p>Don't have an account? <a href="register.jsp">Sign Up</a></p>
        </div>
    </div>
</body>
</html>
