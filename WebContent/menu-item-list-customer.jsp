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
<img src = "images/img.png" alt = "image_logo" />
<nav>
<a class="a2" href="/Servlet-TruYum/ShowMenuItemListCustomer"><u>Menu</u></a>
<a class="a1" href="/Servlet-TruYum/ShowCart"><u>Cart</a></u>
</nav>
</header>
<div> 
<c:if test="${carts==true}">
<h4 style="color:green"><center>Item Added To Cart Successfully</center></h1></c:if>

<h2>Menu Items</h2>

<table cellpadding="4" >
<tr>
<td width=40%><b>Name</b></td>
<td><center><b>Free Delivery</b></center></td>
<td><b>Price</b></td>
<td><b>Category</b></td>
<td><b>Action</b></td>
</tr>
<c:forEach items="${x}" var="list">
<tr>
<td>${list.name}</td>
<c:if test="${list.freeDelivery==true}">
  <td>Yes</td>
  </c:if>
   <c:if test="${list.freeDelivery==false}">
  <td>No</td>
  </c:if>
  <td>Rs. ${list.price}</td>
  <td>${list.category}</td>
  <td><a href="AddToCart?id=${list.id}">Add to Cart</a></td>
  </tr>
</c:forEach>






</table></div>
<footer>
Copyright &copy; 2019 
</footer>
</body>




</html>