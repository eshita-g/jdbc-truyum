<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.truyum.dao.*"
    		 import="java.util.*"		
    		 import="com.cognizant.truyum.model.*" %>
    		 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" href="style/style.css"> </head>
<body>
<header> truYum 
<img src = "images/img.png" alt = "image_logo" />
<nav>
<a class = "a2" href="/Servlet-TruYum/ShowMenuItemListCustomer"><u>Menu</u></a>
<a class = "a1" href="/Servlet-TruYum/ShowCart" ><u>Cart</a></u>
</nav>
</header>
<div>
<c:if test="${removeCart==true}">
<h4 style="color:green"><center>Items removed from cart Succesfully</center></h4></c:if>

<h2> Cart </h2>
<table cellpadding="4">
<tr>
<td width=40%> <b> Name </b> </td>
<td> <b> Free Delivery </b> </td> 
<td> <b> Price </b> </td>
</tr>
<c:forEach items = "${x}" var ="list">
<tr>
<td>${list.name}</td>
  <c:if test="${list.freeDelivery==true}">
  <td>Yes</td>
  </c:if>
   <c:if test="${list.freeDelivery==false}">
  <td>No</td>
  </c:if>
  <td>${list.price}</td>
  <td><a href="RemoveCart?id=${list.id}">Delete</a></td>
  </tr>
 </c:forEach> 
  <tr>
  <td> </td>
  <td> <center> <b>  Total </b> </center> </td>
  
  <td> <b> ${total}</b> </td>

  
  </tr>  
</table>

</div>
<footer>
Copyright &copy; 2019 
</footer>
</body>
</html>
