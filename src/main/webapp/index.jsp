<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
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
    }

    .login-container {
        background: linear-gradient(135deg, #2d2d2d 0%, #1a1a1a 100%);
        padding: 50px 40px;
        border-radius: 20px;
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.5),
                    0 0 0 1px rgba(255, 255, 255, 0.1);
        text-align: center;
        width: 400px;
        color: white;
        border: 1px solid #333;
    }

    h1 {
        color: #ffffff;
        margin-bottom: 30px;
        font-size: 28px;
        letter-spacing: 1.5px;
        font-weight: 300;
        text-transform: uppercase;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin: 25px 0;
    }

    input[type="submit"] {
        width: 100%;
        padding: 15px;
        margin-top: 10px;
        border: none;
        border-radius: 8px;
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

    /* Button styles */
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
	
	<div class="login-container">
		<h1>Bike Rental App</h1>
		<form action="UserLogin.jsp">
			<input type="submit" value="User Login">
		</form>
		<form action="AdminLogin.jsp">
			<input type="submit" value="Admin Login">
		</form>
	</div>
</body>
</html>