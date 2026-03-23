<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Booking</title>
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

    h2 {
        color: #ffffff;
        margin-bottom: 30px;
        font-size: 28px;
        letter-spacing: 1.5px;
        font-weight: 300;
        text-transform: uppercase;
        text-align: center;
    }

    .bike-details p {
        background: linear-gradient(135deg, #333 0%, #2a2a2a 100%);
        color: #ffffff;
        padding: 15px 20px;
        border-radius: 8px;
        margin: 10px 0;
        font-size: 16px;
        border-left: 4px solid #666;
        border: 1px solid #444;
    }

    .bike-details b {
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
    }

    input[type="date"] {
        width: 100%;
        padding: 12px;
        margin: 8px 0 20px 0;
        border: 1px solid #444;
        border-radius: 8px;
        background: #333;
        color: white;
        font-size: 14px;
        box-sizing: border-box;
    }

    input[type="date"]:focus {
        outline: none;
        border-color: #666;
        box-shadow: 0 0 5px rgba(255, 255, 255, 0.1);
    }

    input[type="submit"] {
        width: 100%;
        padding: 15px;
        margin-top: 10px;
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

    label {
        color: #ccc;
        font-weight: 500;
        margin-bottom: 5px;
        display: block;
    }
</style>
</head>
<body>
	
	<div class="container">
		<h2>Confirm Booking</h2>
		
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
		
		<div class="bike-details">
			<p>
				<b>Model: </b> ${bookBike.model }
			</p>
			<p>
				<b>Brand: </b> ${bookBike.brand }
			</p>
			<p>
				<b>Engine CC: </b> ${bookBike.engineCc }
			</p>
			<p>
				<b>Mileage: </b> ${bookBike.mileage }
			</p>
			<p>
				<b>Fuel Type: </b> ${bookBike.fuelType }
			</p>
			<p>
				<b>Price: </b> ${bookBike.price }
			</p>
			<p>
				<b>Rent Type: </b> ${bookBike.rentType }
			</p>
		</div>

		<%
		java.time.LocalDate today = java.time.LocalDate.now();
		%>

		<form action="conformBooking" method="post">
			<label>Start Date:</label>
			<input type="date" name="start" min="<%=today%>" required> 
			
			<label>End Date:</label>
			<input type="date" name="end" min="<%=today%>" required> 
			
			<input type="submit" value="Confirm Booking">
		</form>
	</div>

</body>
</html>