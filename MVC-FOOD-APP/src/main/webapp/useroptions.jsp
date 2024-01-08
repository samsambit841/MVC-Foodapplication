<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Option</title>
    <style>
        body {
            background-image: url('https://images6.alphacoders.com/132/1324371.png');
            background-size: cover;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #efefef;
        }

        a {
            display: inline-block;
            margin: 10px;
            padding: 15px 25px;
            background: rgba(255, 255, 255, 0.5);
            color: #000;
            text-decoration: none;
            font-weight: bold;
            border-radius: 3px;
            font-size: 16px;
            border: 2px solid transparent;
            transition: 0.3s ease;
        }

        a:hover {
            color: #fff;
            
            border-color: #efefef;
            background: rgba(255, 255, 255, 0.15);
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
    <a href="addfoodorder">Order Food</a>
    <a href="viewfoodorderuser?uid=${user.id}">Previous Orders</a>
    <a href="viewprofile?uid=${user.id}">View Profile</a>
    </div>
</body>
</html>
