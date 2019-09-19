<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.truyum.dao.*"
    		 import="java.util.*"		
    		 import="com.cognizant.truyum.model.*" %>
    		  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!doctype html>
<head>
	<link rel="stylesheet" href="style/style.css">
	
</head>
<body>

<header>truYum <img src="images/img.png"/>
<nav>
<a class="a2"  href="/Servlet-TruYum/ShowMenuItemListAdmin">Menu</a>
<a class="a1"></a>
</nav>
</header>
<div>
<p id="m1">Menu Items</p>
<table id="t1">
<tr>
  <th>Name</th>
  <th>Price</th>
  <th>Active</th>
  <th>Date of Launch</th>
  <th>Category</th>
  <th>Free Delivery</th>
  <th>Action</th>
</tr>

	  
<c:forEach items="${x}" var="list" >
<tr>
  <td id="t11">${list.name}</td>
  <td id="t12">Rs. ${list.price}</td>
  <c:if test="${list.active==true}">
  <td id="t13">Yes</td>
  </c:if>
   <c:if test="${list.active==false}">
  <td id="t13">No</td>
  </c:if>
  <td id="t14"><fmt:formatDate pattern="dd/MM/yyyy" value="${list.dateOflaunch}"/></td>
  <td id="t15">${list.category}</td>
  <c:if test="${list.freeDelivery==true}">
  <td id="t16">Yes</td>
  </c:if>
   <c:if test="${list.freeDelivery==false}">
  <td id="t16">No</td>
  </c:if>
  <td id="t17"><a href="ShowEditMenuItem?id=${list.id}">Edit</a></td>
</tr>
</c:forEach>
	
	</table>
</div>

<footer>
Copyright &copy; 2019 
</footer>

</body>
</html>