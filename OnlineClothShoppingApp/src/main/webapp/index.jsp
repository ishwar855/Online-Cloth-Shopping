<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Clothing Store</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #1e3c72, #2a5298);
            color: #f5f5f5;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
            padding: 40px 30px;
            border-radius: 15px;
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(15px);
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.3);
            animation: pulse 8s infinite ease-in-out;
        }
        @keyframes pulse {
            0%, 100% {
                transform: scale(1);
                box-shadow: 0 15px 25px rgba(0, 0, 0, 0.3);
            }
            50% {
                transform: scale(1.05);
                box-shadow: 0 25px 40px rgba(0, 0, 0, 0.4);
            }
        }
        h1 {
            font-size: 3rem;
            margin-bottom: 15px;
            color: #fff;
            text-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
        }
        p {
            font-size: 1.2rem;
            margin-bottom: 25px;
            color: #e0e0e0;
        }
        .promo {
            font-size: 1rem;
            background: linear-gradient(90deg, #ff8c00, #ff007f);
            color: #fff;
            padding: 10px 20px;
            border-radius: 50px;
            margin: 20px auto;
            display: inline-block;
            font-weight: 600;
            letter-spacing: 1px;
            animation: glow 1.5s infinite alternate;
        }
        @keyframes glow {
            from {
                box-shadow: 0 0 15px rgba(255, 0, 127, 0.7);
            }
            to {
                box-shadow: 0 0 30px rgba(255, 0, 127, 1);
            }
        }
        .buttons {
            margin-top: 30px;
            display: flex;
            justify-content: center;
            gap: 20px;
        }
        .buttons a {
            text-decoration: none;
            color: white;
            background: linear-gradient(45deg, #ff512f, #dd2476);
            padding: 14px 28px;
            border-radius: 50px;
            font-size: 1rem;
            font-weight: 600;
            transition: transform 0.3s, box-shadow 0.3s;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .buttons a:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.4);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Exclusive Styles, Just for You<h2>
        <h1>Welcome to TrendHive</h1>
        
        
        <p>Don’t Just Dream It – Wear It!</p>
        
       
        <div class="buttons">
         
            <a href="login.jsp">Login in Cloth World</a>
           	
        </div>
        
    </div>
</body>
</html>
