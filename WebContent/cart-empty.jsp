<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.truyum.dao.*"
    		 import="java.util.*"		
    		 import="com.cognizant.truyum.model.*" %>
    		 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link rel="stylesheet" href="style/style.css">

</head>

<body>

<header> truYum 
<img src = "images/img.png" alt = "images/image_logo" />
<nav>
<a class="a2" href="/Servlet-TruYum/ShowMenuItemListCustomer"><u>Menu</u></a>
<a class="a1" href="/Servlet-TruYum/ShowCart" ><u>Cart</a></u></nav>
</header>

<div> 


<h2>Menu Items</h2>
<center>No items in cart.Use'Add to Cart'option in <a href="/Servlet-TruYum/ShowMenuItemListCustomer">Menu Item List</a></center>

</div><br></br>
<br></br>
<br></br><br></br><br></br><br>
<footer>
Copyright &copy; 2019 
</footer>
</body>

</html>