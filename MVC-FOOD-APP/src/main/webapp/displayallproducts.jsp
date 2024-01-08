<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@200;300;400;500;600;700&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Open Sans", sans-serif;
        }

        body {
            display: flex;
            align-items: flex-start;
            justify-content: center;
            min-height: 100vh;
            width: 100%;
            padding: 20px 10px; 
            background: url("https://images4.alphacoders.com/132/1324680.png"), #000;
            background-position: center;
            background-size: cover;
        }

        .card {
            border: 1px solid #fff;
            border-radius: 8px;
            margin: 10px;
            background: rgba(255, 255, 255, 0.5);
            overflow: hidden;
            color: red;
            width: 300px;
        }

        .card-header {
            background-color: #2A55E5; 
            padding: 15px;
            text-align: center;
            color: white; 
            font-size: 21px; 
        }

        .card-body {
            padding: 15px;
            font-size: 18px; 
            color: #333; 
        }

        a {
            display: inline-block;
            margin: 10px 0;
            padding: 10px 20px;
            background: #2A55E5;
            color: white;
            text-decoration: none;
            font-weight: 600;
            border-radius: 3px;
            font-size: 16px;
            border: 2px solid transparent;
            transition: 0.3s ease;
        }

        a:hover {
            color: black;
            border-color: #fff;
            background: rgba(255, 255, 255, 0.15);
        }
    </style>
</head>
<body>

    <c:forEach var="product" items="${products}">
        <div class="card">
            <div class="card-header">
                <h3>Product Details</h3>
            </div>
            <div class="card-body">
                <p><strong>ID:</strong> ${product.id}</p>
                <p><strong>Name:</strong> ${product.name}</p>
                <p><strong>Cost:</strong> ${product.cost}</p>
                <a href="additem?id=${product.id}">Add</a>
            </div>
        </div>
    </c:forEach>

    <a href="#" style="font-size: 18px; color: #2A55E5; text-decoration: none; font-weight: 600; margin-right: 10px;">Back</a>
    <a href="savefoodorders" style="font-size: 18px; background: #2A55E5; color: white; text-decoration: none; padding: 10px 20px; border-radius: 3px; font-weight: 600; border: 2px solid transparent; transition: 0.3s ease;">Submit</a>

</body>
</html>
