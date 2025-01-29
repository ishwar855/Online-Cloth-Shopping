<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
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
        .register-container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
            padding: 40px;
            width: 400px;
            text-align: center;
        }
        .register-container h2 {
            margin-bottom: 20px;
            font-size: 28px;
            color: #fff;
            text-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        }
        .register-container p {
            font-size: 14px;
            color: #ddd;
            margin-bottom: 30px;
        }
        .register-container input {
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
        .register-container input:focus {
            outline: none;
            box-shadow: 0 0 8px rgba(29, 38, 113, 0.6);
        }
        .register-container button {
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
        .register-container button:hover {
            transform: translateY(-3px);
            box-shadow: 0 12px 20px rgba(0, 0, 0, 0.4);
        }
        .register-container .footer {
            margin-top: 20px;
            font-size: 14px;
            color: #ddd;
        }
        .register-container .footer a {
            color: #ff6f61;
            text-decoration: none;
            font-weight: bold;
        }
        .register-container .footer a:hover {
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
    <div class="register-container">
        <h2>Join TrendHive</h2>
        <p>Create your account to explore the latest trends.</p>
        <form action="RegisterServlet" method="post">
            <input type="text" name="firstName" placeholder="First Name" required>
            <input type="text" name="lastName" placeholder="Last Name" required>
            <input type="text" name="mobile" placeholder="Mobile Number" pattern="[0-9]{10}" title="Enter a valid 10-digit mobile number" required>
            <input type="email" name="email" placeholder="Email Address" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
            <button type="submit">Sign Up</button>
        </form>
        <div class="footer">
            <p>Already have an account? <a href="login.jsp">Login</a></p>
        </div>
    </div>
</body>
</html>
	