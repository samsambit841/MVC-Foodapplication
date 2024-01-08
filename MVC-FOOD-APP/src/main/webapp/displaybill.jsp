<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Bill</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
        }

        h2 {
            color: #4285f4;
        }

        table {
            width: 50%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .total-cost {
            margin-top: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h2>Food Order Details</h2>

    <table>
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Cost</th>
        </tr>
        <c:forEach var="item" items="${foodorder.items}">
            <tr>
                <td>${item.name}</td>
                <td>${item.quantity}</td>
                <td>${item.cost}</td>
            </tr>
        </c:forEach>
    </table>

    <div class="total-cost">
        <p>Total Cost: ${foodorder.totalcost}</p>
    </div>
    
    <a href="adminoption">Back to Admin option</a>
</body>
</html>
