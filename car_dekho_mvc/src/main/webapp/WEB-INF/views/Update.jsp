<%@page import="java.util.List"%>
<%@page import="com.jspiders.car_dekho_mvc.pojo.CarPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");
CarPojo carPojo = (CarPojo) request.getAttribute("car");
List<CarPojo> cars = (List<CarPojo>)request.getAttribute("cars");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Car</title>
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
</style>
</head>
<body>
	<div align="center" id="main">
		<%
		if (carPojo == null) {
		%>
		<fieldset id="box">
			<legend>UPDATE CAR</legend>
			<form action="./update" method="post">
				<table>
					<tr>
						<th>Enter Car Id</th>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SELECT CAR" id="button">
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
		<%
		}else{
		%>
			<fieldset>
				<legend>UPDATE CAR DETAILS</legend>
				<form action="./updateCar" method="post">
					<table>
						<tr>
							<th>ID</th>
							<td><input type="text" value="<%= carPojo.getId()%>" readonly="readonly" name="id"></td>
						</tr>
						<tr>
							<th>Name</th>
							<td><input type="text" value="<%=carPojo.getName() %>" name="name"></td>
						</tr>
						<tr>
							<th>Model</th>
							<td><input type="text" value="<%=carPojo.getModel() %>" name="model"></td>
						</tr>
						<tr>
							<th>Brand</th>
							<td><input type="text" value="<%=carPojo.getBrand() %>" name="brand"></td>
						</tr>
						<tr>
							<th>Fuel Type</th>
							<td><input type="text" value="<%=carPojo.getFuelType() %>" name="fuelType"></td>
						</tr>
						<tr>
							<th>Price</th>
							<td><input type="text" value="<%=carPojo.getPrice() %>" name="price"></td>
						</tr>
					</table>
					<input type="submit" value="UPDATE CAR">
				</form>
			</fieldset>
		<%} %>
	</div>
</body>
</html>