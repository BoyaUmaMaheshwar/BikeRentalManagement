<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Success</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #0c0c0c 0%, #1a1a1a 100%);
        margin: 0;
        padding: 40px;
        color: white;
        min-height: 100vh;
        box-sizing: border-box;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    .container {
        background: linear-gradient(135deg, #2d2d2d 0%, #1a1a1a 100%);
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.5),
                    0 0 0 1px rgba(255, 255, 255, 0.1);
        width: 500px;
        border: 1px solid #333;
    }

    h1 {
        color: #ffffff;
        margin-bottom: 30px;
        font-size: 28px;
        letter-spacing: 1.5px;
        font-weight: 300;
        text-transform: uppercase;
        text-align: center;
    }

    .success-details p {
        background: linear-gradient(135deg, #333 0%, #2a2a2a 100%);
        color: #ffffff;
        padding: 15px 20px;
        border-radius: 8px;
        margin: 10px 0;
        font-size: 16px;
        border-left: 4px solid #666;
        border: 1px solid #444;
    }

    .success-details b {
        color: #ccc;
    }

    .message {
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
        margin-top: 30px;
        text-align: center;
    }

    input[type="submit"] {
        padding: 15px 30px;
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
		<h1>Booking Successful</h1>
		
		<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
		%>
		<div class="message">
			<b><%=msg%></b>
		</div>
		<%
		}
		%>
		
		<div class="success-details">
			<p>
				<b>Bike Model: </b> ${bookBike.model}
			</p>
			<p>
				<b>Rent Type: </b> ${bookBike.rentType}
			</p>
			<p>
				<b>Price Per Day: </b> ${bookBike.price}
			</p>
			<p>
				<b>Booking Status: </b> ${booking.status}
			</p>
			<p>
				<b>Booking Time: </b> ${booking.createdAt}
			</p>
			<p>
				<b>Bike Booking Date: </b> ${booking.startDate}
			</p>
			<p>
				<b>Booking Ends On: </b> ${booking.endDate}
			</p>
			<p>
				<b>Total Amount: </b> ${booking.totalAmount}
			</p>
		</div>
		
		<form action="UserHome.jsp">
			<input type="submit" value="Home">
		</form>
	</div>

</body>
</html>