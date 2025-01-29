<%@ page import="java.util.List" %>
<%@ page import="model.ClothTypes" %>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clothing Shop - Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            background: #f3f4f6;
            color: #333;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        header {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(10px);
            position: sticky;
            top: 0;
            z-index: 1000;
            padding: 0.8rem 0;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        nav {
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 1.8rem;
            font-weight: bold;
            color: #2c3e50;
            letter-spacing: 1px;
            cursor: pointer;
        }

        .nav-links {
            display: flex;
            gap: 2rem;
            list-style: none;
        }

        .nav-links a {
            font-size: 1rem;
            color: #2c3e50;
            font-weight: 600;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .nav-links a:hover {
            color: #3498db;
        }

        .hero {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
            padding: 6rem 1rem;
            background: url('hero-background.jpg') no-repeat center/cover;
            color: white;
            position: relative;
        }

        .hero::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.4);
            z-index: -1;
        }

        .hero h1 {
            font-size: 3rem;
            font-weight: bold;
            margin-bottom: 1rem;
        }

        .hero p {
            font-size: 1.2rem;
            margin-bottom: 2rem;
            max-width: 700px;
        }

        .hero .btn {
            display: inline-block;
            padding: 0.8rem 2.5rem;
            background-color: white;
            color: #2575fc;
            text-decoration: none;
            border-radius: 50px;
            font-size: 1rem;
            font-weight: bold;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .hero .btn:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
        }

        main {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 1rem;
        }

        main h2 {
            font-size: 2.5rem;
            color: #444;
            text-align: center;
            margin-bottom: 2rem;
        }

			.card-container {
		    display: grid;
		    grid-template-columns: repeat(3, 1fr); /* 3 categories per row */
		    gap: 1rem 1rem; /* 2rem vertical gap, 1rem horizontal gap */
		    margin-top: 2rem; /* Optional: Adjust for spacing between the categories and the previous section */
		}



        .card {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: scale(1.03);
            box-shadow: 0 15px 25px rgba(0, 0, 0, 0.2);
        }

        .card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .card-content {
            padding: 1.5rem;
            text-align: center;
        }

        .card-content h3 {
            font-size: 1.5rem;
            color: #2c3e50;
            margin-bottom: 0.5rem;
        }

        .card-content p {
            color: #666;
            font-size: 0.9rem;
            line-height: 1.5;
        }

        footer {
            background: #2c3e50;
            color: white;
            text-align: center;
            padding: 2rem;
            margin-top: auto;
        }

        footer .social-icons {
            margin-top: 1rem;
            display: flex;
            justify-content: center;
            gap: 1rem;
        }

        footer .social-icons a {
            color: white;
            text-decoration: none;
            font-size: 1.5rem;
            transition: color 0.3s ease;
        }

        footer .social-icons a:hover {
            color: #3498db;
        }

        footer form {
            margin-top: 1rem;
        }

        footer input[type="email"] {
            padding: 0.8rem;
            border: none;
            border-radius: 4px;
            margin-right: 0.5rem;
        }

        footer button {
            padding: 0.8rem 1.2rem;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        footer button:hover {
            background-color: #1d6fa5;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <div class="logo">TrendHive</div>
            <ul class="nav-links">
                <li><a href="home.jsp"><i class="fas fa-home"></i> Home</a></li>
                <li><a href="MyOrder.jsp"><i class="fas fa-shopping-bag"></i> My Orders</a></li>
                <li><a href="#"><i class="fas fa-user"></i> Profile</a></li>
                <li><a href="login.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="hero">
        <h1>Welcome, <% out.println(session.getAttribute("loggedInUser") != null ? ((User) session.getAttribute("loggedInUser")).getFirst_name() : "Guest"); %></h1>
        <p>Discover a world of style and quality at your fingertips. Explore our exclusive clothing categories today!</p>
        <a href="#categories" class="btn">Browse Categories</a>
    </div>

    <main>
        <h2 id="categories">Our Categories</h2>
        <div class="card-container">
            <% 
                List<ClothTypes> clothTypesList = (List<ClothTypes>) session.getAttribute("clothTypesList");
                if (clothTypesList != null && !clothTypesList.isEmpty()) { 
                    for (ClothTypes clothType : clothTypesList) { 
            %>
                <a href="ProductList?clothTypeId=<%= clothType.getId() %>&clothTypeName=<%= clothType.getName() %>" class="card">
                    <img src="<%= request.getContextPath() + "/" + clothType.getImgUrl() %>" alt="<%= clothType.getName() %>">
                    <div class="card-content">
                        <h3><%= clothType.getName() %></h3>
                        <p><%= clothType.getDescription() %></p>
                    </div>
                </a>
            <% 
                    } 
                } else { 
            %>
                <p>No categories available at the moment.</p>
            <% 
                } 
            %>
        </div>
    </main>

    <footer>
        <p>&copy; 2025 TrendHive. All rights reserved.</p>
        <div class="social-icons">
            <a href="#"><i class="fab fa-facebook"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
        </div>
        <form>
            <input type="email" placeholder="Subscribe to our newsletter" required>
            <button>Subscribe</button>
        </form>
    </footer>
</body>
</html>
