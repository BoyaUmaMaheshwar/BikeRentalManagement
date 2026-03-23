<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bookings</title>
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
        max-width: 1400px;
        margin: 0 auto;
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

    table {
        width: 100%;
        border-collapse: collapse;
        background: linear-gradient(135deg, #2d2d2d 0%, #1a1a1a 100%);
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.5);
        border: 1px solid #333;
        margin-bottom: 30px;
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

    form {
        text-align: center;
    }

    input[type="submit"] {
        padding: 12px 30px;
        border: none;
        border-radius: 8px;
        background: linear-gradient(135deg, #555 0%, #333 100%);
        color: #ffffff;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        transition: all 0.3s ease;
        text-transform: uppercase;
        letter-spacing: 1px;
    }

    input[type="submit"]:hover {
        transform: translateY(-2px);
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
        background: linear-gradient(135deg, #666 0%, #444 100%);
    }
</style>
</head>
<body>
    <div class="container">
        <h1>My Bookings</h1>

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

        <table border="1">
            <tr>
                <th>Bike Model</th>
                <th>Rent Type</th>
                <th>Price Per Day</th>
                <th>Booking Status</th>
                <th>Booking Time</th>
                <th>Bike Booking Date</th>
                <th>Booking Ends On</th>
                <th>TotalAmount</th>
                <th>Days</th>
                <th>Ride Status</th>
            </tr>
            <c:forEach var="b" items="${userBookings }">
                <tr>
                    <td>${b.bike.model }</td>
                    <td>${b.bike.rentType }</td>
                    <td>${b.bike.price }</td>
                    <td>${b.status }</td>
                    <td>${b.createdAt }</td>
                    <td>${b.startDate }</td>
                    <td>${b.endDate }</td>
                    <td>${b.totalAmount }</td>
                    <td>${b.days }</td>
                    <td>${b.rideStatus }</td>
                </tr>
            </c:forEach>
        </table>

        <form action="UserHome.jsp">
            <input type="submit" value="Go Back">
        </form>
    </div>
</body>
</html>