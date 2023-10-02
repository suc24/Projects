<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
    fieldset table {
        margin: auto;
        text-align: left;
        
       }
       
    fieldset {
    	width : 300px;
        margin: 15px auto;
        text-align: center;
        padding: 20px;
        border: 1px solid #333;
        border-radius: 10px;
        background-color: #f7f7f7;
    }

    legend {
        color: black;
        background-color: yellow;
        padding: 5px 10px;
        border-radius: 5px;
        font-weight: bold;
    }

    ul {
        list-style-type: none;
        background-color: #333;
        overflow: hidden;
        
    }
    #parent{
    	height: 50px;
    	width: 100%;
    	display: flex;
    	background-color: black;
    	justify-content: space-around;
    	box-shadow: 0px 0px 20px fuchsia; 
    }

    #parent a {
        display: block;
        padding: 15px;
        text-decoration: none;
        color: white;
        transition: background-color 0.3s;
        font-weight: bold;
        
        
    }

     #parent a:hover {
     	color: black;
        background-color: yellow;
    }

    body {
        font-family: Arial, sans-serif;
        background-image: url("https://files.oyebesmartest.com/uploads/large/tata-avinya-electric-carwgpl0.png"); 
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        margin: 0;
        padding: 0;
    
    }

    h1 {
        text-align: center;
        color: #333;
    }
</style>
</head>
<body>
	<div id="parent">
		<div><a href="./home">Home</a></div>
		<div><a href="./add">Add Car</a></div>
		<div><a href="./search">Search Car</a></div>
		<div><a href="./update">Update Car</a></div>
		<div><a href="./remove">Remove Car</a></div>
		<div><a href="./logout">Logout</a></div>
	</div>
</body>
</html>