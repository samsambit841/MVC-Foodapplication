<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body {
            background-image: url('https://images5.alphacoders.com/134/1341443.png');
            background-size: cover;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin: 10px;
        }
        h1 {
            color: #efefef;
            text-align: center;
        }
        

        .card a {
            color: black;
            text-decoration: none;
            font-weight: bold;
        }

        .wrapper a {
            color: #efefef;
            text-decoration: none;
        }

        .wrapper a:hover {
            text-decoration: underline;
        }

        .wrapper {
            width: 400px;
            border-radius: 8px;
            padding: 30px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.5);
            backdrop-filter: blur(9px);
            -webkit-backdrop-filter: blur(9px);
        }
        
    </style>
</head>
<body>


    <div class="wrapper">
        ${msg}
    <h1>Welcome to the Food Order App</h1>
        

    <div class="card">
        <a href="adduser">Add user</a>
    </div>

    <div class="card">
        <a href="loginuserform.jsp">Login user</a>
    </div>

    <div class="card">
        <a href="addproduct">Add product</a>
    </div>

    <div class="card">
        <a href="viewallproducts">View all Products</a>
    </div>


    <div class="card">
        <a href="viewallfoodorders">View all Food Orders</a>
    </div>
    </div>
</body>
</html>
