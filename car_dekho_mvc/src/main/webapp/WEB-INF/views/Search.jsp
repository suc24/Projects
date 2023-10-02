<%@page import="com.jspiders.car_dekho_mvc.pojo.CarPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");
CarPojo car = (CarPojo) request.getAttribute("car");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Car</title>
<style type="text/css">
<style type="text/css">
#tbl {
	color: white;
	border: 1px solid white;
	width: 30%;
	margin-top: 2%;
}

#head {
	color: yellow;
	background-color: black;
}

#button {
	background-color: #00DBDE; background-image : linear-gradient( 90deg,
	#00DBDE 0%, #FC00FF 100%);
	height: 30px;
	width: 110px;
	margin-top: 10px;
	font-weight: bold;
	background-image: linear-gradient(90deg, #00DBDE 0%, #FC00FF 100%);
	color: white;
	
}
#button:hover {
	box-shadow: 0px 0px 20px yellow;	
}
#box{
	background-color: transparent;
	color: white;
	box-shadow: 0px 0px 20px fuchsia;
	text-shadow: 0px 0px 10px black;
	font-size: 18px;
}
input{
	border-radius: 10px;
	height: 20px;
}
#msg{
	color: white;
}
#main {
	margin-top: 5%;
}
#src{
	color: white;
}
</style>
</head>
<body>
	<div align="center" id="main">
		<fieldset id="box">
			<legend>SEARCH CAR</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Enter Car ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SEARCH CAR" id="button">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h2 id="msg"><%=msg%></h2>
		<%
		}
		%>

		<%
		if (car != null) {
		%>
		<table border="1" id="tbl">
			<tr id="head">
				<th>ID</th>
				<th>NAME</th>
				<th>MODEL</th>
				<th>BRAND</th>
				<th>FULE TYPE</th>
				<th>PRICE</th>
			</tr>
			<tr id="src">
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getModel()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getFuelType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>