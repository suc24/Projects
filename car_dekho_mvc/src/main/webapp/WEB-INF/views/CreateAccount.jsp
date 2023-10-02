<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Car Admin</title>
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
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f2f2f2;
        font-size: 16px;
    }
    
   .inp:hover{
    	box-shadow: 0px 0px 10px black;
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
    body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
 </style> 
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Create Admin Account</legend>
			<form action="./createAdmin" method="post">
				<table>
					<tr>
						<td>UserName</td>
						<td><input type="text" name="username" class="inp" autofocus="autofocus"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password" class="inp"></td>
					</tr>
				</table>
				<input type="submit" value="CREATE ACCOUNT" id="button"> 
			</form>
		</fieldset>
	</div>
</body>
</html>