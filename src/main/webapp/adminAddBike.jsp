<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Bike</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #0c0c0c 0%, #1a1a1a 100%);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        color: white;
    }

    .form-container {
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

    form {
        display: flex;
        flex-direction: column;
    }

    input[type="text"],
    input[type="number"],
    select {
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

    input[type="text"]:focus,
    input[type="number"]:focus,
    select:focus {
        outline: none;
        border-color: #666;
        box-shadow: 0 0 5px rgba(255, 255, 255, 0.1);
    }

    input[type="submit"] {
        width: 100%;
        padding: 15px;
        margin-top: 20px;
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

    label {
        color: #ccc;
        font-weight: 500;
        margin-bottom: 5px;
        display: block;
    }
</style>
</head>
<body>

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

	<div class="form-container">
		<h2>Add Bike</h2>
		<form action="adminAddBike" method="post">
			<label>Model:</label>
			<input type="text" name="model" >
			
			<label>Brand:</label>
			<input type="text" name="brand">
			
			<label>Engine CC:</label>
			<input type="text" name="engineCc">
			
			<label>Mileage:</label>
			<input type="number" name="mileage">
			
			<label>Fuel Type:</label>
			<input type="text" name="fuelType">		
			
			<label>Price:</label>
			<input type="number" name="price">
			
			<label>Rent Type:</label>
			<input type="text" name="rentType">
			
			<label>Available:</label>
			<select name="available">
				<option value="Yes">Yes</option>
				<option value="No">No</option>
			</select>
			
			<label>In Store:</label>
			<select name="inStore">
				<option value="Available">Available</option>
				<option value="Bike Deleted">Bike Deleted</option>
			</select>
			
			<input type="submit" value="Add Bike">
		</form>
	</div>
	
</body>
</html>