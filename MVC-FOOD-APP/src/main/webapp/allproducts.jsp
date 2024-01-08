<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
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
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            width: 100%;
            padding: 0 10px;
            background: url("https://images3.alphacoders.com/132/1324463.png"), #000;
            background-position: center;
            background-size: cover;
            color: #fff; 
        }

        table {
            width: 80%;
            margin-top: 20px;
            border-collapse: collapse;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        th, td {
            padding: 20px; 
            background-color: rgba(255, 255, 255, 0.5);
            color: #000; 
            text-align: left;
            font-size: 18px;
        }

        th {
            background-color: #4285f4;
            color: #fff;
        }

        tr:hover {
            background-color: rgba(255, 255, 255, 0.3);
        }

        a {
            color: #000;
            text-decoration: none;
            font-size: 16px; 
        }

        a:hover {
            text-decoration: underline;
        }

        .update-link, .delete-link {
            padding: 12px 18px; 
            border-radius: 5px;
            margin-right: 5px;
            background-color:#4285f4 ;
            color: #fff;
            text-decoration: none;
            font-size: 16px; 
        }

        .delete-link {
            background-color: #ea4335;
        }
    </style>
</head>
<body>
    <table cellpadding="20px" border="1px">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>type</th>
            <th>cost</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.type}</td>
                <td>${product.cost}</td>
                <td><a href="updateproduct?id=${product.id}" class="update-link">update</a></td>
                <td><a href="deleteproduct?id=${product.id}" class="delete-link">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
