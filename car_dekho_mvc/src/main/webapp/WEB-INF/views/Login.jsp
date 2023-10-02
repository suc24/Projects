<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		String msg = (String)request.getAttribute("msg");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style type="text/css">
    fieldset {
        margin: 20px auto;
        text-align: center;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        background-color: #f7f7f7;
        width: 300px;
        box-shadow: 0px 0px 20px black;
        font-weight: bold;
    }

    legend {
        color: white;
        background-color: #333;
        padding: 5px 10px;
        border-radius: 5px;
    }

    table {
        margin: 15px auto;
        text-align: left;
    }

    td {
        padding: 10px;
        font-size: 18px;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid black;
        border-radius: 5px;
        background-color: #f2f2f2;
        font-size: 16px;
    }
    
   .inp:hover{
    	box-shadow: 0px 0px 10px yellow;
    }

    input[type="submit"] {
        background-color: #333;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #111;
        box-shadow: 0px 0px 20px yellow;
    }

   
    a {
        display: block;
        width: 20%;
        text-align: center;
        margin-top: 10px;
        text-decoration: none;
        background-color: #333;
        color: white;
        padding: 10px;
        border-radius: 5px;
        font-size: 16px;
        transition: background-color 0.3s;
      
        
    }

    a:hover {
        background-color: #111;
         box-shadow: 0px 0px 20px yellow;
    }
    #msg{
    	color: black;
    	font-weight: bold;
    }
    body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
div {
	margin-top: 4%;
}
h1 {
	font-size: 50px;
	font-family: sans-serif;
}
h1:hover {
	 text-shadow: 0px 0px 20px yellow;
}
</style>
</head>
<body>
	<h1 align="center">CAR DEKHO</h1>
	<div align="center">
		<fieldset>
			<legend>Login Page</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username" class="inp" autofocus="autofocus"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" class="inp"></td>
					</tr>
				</table>
				<input type="submit" value="Login">
			</form>
		</fieldset>
		<a href="http://localhost:8080/car_dekho_mvc/createAdmin">CREATE ACCOUNT</a>
		<%if(msg!=null){ %>
		<h3 id="msg"><%=msg %></h3>
	<%} %>
	</div>
</body>
</html>