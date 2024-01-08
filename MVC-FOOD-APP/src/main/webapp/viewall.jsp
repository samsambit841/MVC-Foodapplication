<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Food Orders</title>
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
            background-color: rgba(255, 255, 255, 0.7);
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

   
    </style>
</head>
<body>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Mobile No</th>
            <th>Total Cost</th>
            <th>User</th>
            <th>Items</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="foodOrder" items="${foodorders}">
            <tr>
                <td>${foodOrder.id}</td>
                <td>${foodOrder.name}</td>
                <td>${foodOrder.mobileno}</td>
                <td>${foodOrder.totalcost}</td>
                <td>${foodOrder.user.name}</td>
                <td>
                    <ul>
                        <c:forEach var="item" items="${foodOrder.items}">
                            <li>${item.name} - ${item.quantity}</li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
