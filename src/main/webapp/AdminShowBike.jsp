<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bikes</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #0c0c0c 0%, #1a1a1a 100%);
        margin: 0;
        padding: 40px;
        color: white;
        min-height: 100vh;
        box-sizing: border-box;
    }

    .container {
        max-width: 1200px;
        margin: 0 auto;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background: linear-gradient(135deg, #2d2d2d 0%, #1a1a1a 100%);
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.5);
        border: 1px solid #333;
    }

    th {
        background: linear-gradient(135deg, #444 0%, #333 100%);
        color: white;
        padding: 15px;
        text-align: left;
        font-weight: 600;
        text-transform: uppercase;
        letter-spacing: 1px;
        border-bottom: 2px solid #555;
    }

    td {
        padding: 12px 15px;
        border-bottom: 1px solid #444;
        color: #ccc;
    }

    tr:hover {
        background: rgba(255, 255, 255, 0.05);
    }

    tr:last-child td {
        border-bottom: none;
    }

    form {
        display: inline-block;
        margin: 2px;
    }

    input[type="submit"] {
        padding: 8px 16px;
        border: none;
        border-radius: 6px;
        color: #ffffff;
        font-size: 12px;
        font-weight: 600;
        cursor: pointer;
        transition: all 0.3s ease;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    input[type="submit"]:hover {
        transform: translateY(-1px);
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
    }

    form:first-of-type input[type="submit"] {
        background: linear-gradient(135deg, #555 0%, #333 100%);
    }

    form:first-of-type input[type="submit"]:hover {
        background: linear-gradient(135deg, #666 0%, #444 100%);
    }

    form:last-of-type input[type="submit"] {
        background: linear-gradient(135deg, #444 0%, #222 100%);
    }

    form:last-of-type input[type="submit"]:hover {
        background: linear-gradient(135deg, #555 0%, #333 100%);
    }

    p {
        background: linear-gradient(135deg, #333 0%, #444 100%);
        color: #ffffff;
        padding: 20px 30px;
        border-radius: 10px;
        margin: 20px 0;
        font-size: 16px;
        font-weight: 500;
        border-left: 4px solid #666;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        text-align: center;
        border: 1px solid #444;
    }

    h1 {
        color: #ffffff;
        text-align: center;
        margin-bottom: 30px;
        font-size: 28px;
        letter-spacing: 1.5px;
        font-weight: 300;
        text-transform: uppercase;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>All Bikes</h1>
        
        <%
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
        %>
        <p>
            <b><%=msg%></b>
        </p>
        <%
        }
        %>

        <table>
            <tr>
                <th>Bike Id</th>
                <th>Model</th>
                <th>Brand</th>
                <th>Engine CC</th>
                <th>Bike Mileage</th>
                <th>Fuel Type</th>
                <th>Price</th>
                <th>Rent Type</th>
                <th>Available</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="b" items="${showBikes }">
                <tr>
                    <td>${b.id }</td>
                    <td>${b.model }</td>
                    <td>${b.brand }</td>
                    <td>${b.engineCc }</td>
                    <td>${b.mileage }</td>
                    <td>${b.fuelType }</td>
                    <td>${b.price }</td>
                    <td>${b.rentType }</td>
                    <td>${b.available }</td>
                    <td>
                        <form action="updateBike" method="post">
                            <input type="hidden" name="id" value="${b.id }"> 
                            <input type="submit" value="Update">
                        </form>
                        <form action="deleteBike" method="post">
                            <input type="hidden" name="id" value="${b.id }"> 
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>