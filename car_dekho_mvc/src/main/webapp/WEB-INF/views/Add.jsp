<%@page import="com.jspiders.car_dekho_mvc.pojo.CarPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");
List<CarPojo> cars = (List<CarPojo>) request.getAttribute("cars");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Car</title>
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
	width: 90px;
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
</style>
</head>
<body>
	<div align="center" id="main">
		<fieldset id="box">
			<legend>ADD CAR</legend>
			<form action="./add" method="post">
				<table id="img">
					<tr>
						<th>Name</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>Model</th>
						<td><input type="text" name="model"></td>
					</tr>
					<tr>
						<th>Brand</th>
						<td><input type="text" name="brand"></td>
					</tr>
					<tr>
						<th>Fuel Type</th>
						<td><input type="text" name="fuelType"></td>
					</tr>
					<tr>
						<th>Price</th>
						<td><input type="text" name="price"></td>
					</tr>
				</table>
				<input type="submit" value="ADD CAR" id="button">
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
		if (cars != null) {
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
			<%
			for (CarPojo car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getModel()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getFuelType()%></td>
				<td><%=car.getPrice()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>