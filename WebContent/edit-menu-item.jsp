<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<link rel="stylesheet" href="style/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>

<header> truYum 
<img src = "images/img.png" alt = "image_logo" />
<nav >
<a class="a2" href="/Servlet-TruYum/ShowMenuItemListAdmin"><u>Menu</u></a>
<a class="a1" ></a></nav>
</header>
<form name="menuItemForm" action="EditMenuItem?id=${x.id}" onsubmit="valid()"method="post">
<div>
<h2>Edit Menu Item</h2>
<table class="Table">
<tr><td><label for="name">Name</label></td></tr>
<tr><td><input type="text" name="title" size="95" id="name" value="<c:out value="${x.name}"/>"/></td></tr>
</table>
<table class="Table" width="600">
<br>
<tr><td><label for="price">Price (Rs.)</td><td>Active</td><td><label for="DOL">Date of Launch</label></td><td>Category</td></tr>
<tr><td><input type="text" name="price" id="price"style="text-align:right"
value="<c:out value="${x.price}"/>"/></td> 
<td class="radio"><input type="radio" name="act" <c:if test="${yes.isSelected()}"> <c:out value="Yes+${x.setActive(true)}"/> </c:if> id="yes" checked/><label for="yes">Yes</label><input type="radio" name="act" value= id="no" <c:if test="${no.isSelected()}"> <c:out value="No+${x.setActive(false)}"/> </c:if>/><label for="no">No</label></td>
<fmt:formatDate pattern="dd/MM/yyyy" value="${x.dateOflaunch}" var ="dl"/>
<td><input type="text" name="dateOfLaunch" id="DOL"
 value="<c:out value="${dl}"/>"/></td>
<td><select name="category">
<option  value="Starters" ${x.category.equals("Starters")?'selected':" "}>Starters</option>
<option value="Main Course" ${x.category.equals("Main Course")?'selected':" "}>Main Course</option>
<option value="Desserts" ${x.category.equals("Desserts")?'selected':" "}>Desserts</option>
<option value="Drinks" ${x.category.equals("Drinks")?'selected':" "}>Drinks</option>
</select></td></tr>
<tr><td><br><input type="checkbox" value="FD" style="width:15; height:15" name="fd" id="FD"/><label for="FD">Free Delivery</label></td></tr>
<td>
<br>
<input type="submit" value="Save" class="button" name="save" onClick="valid()"></input></td>
</table>

</div>
<footer>
Copyright &copy; 2019 
</footer>
</form>
</body>
</html>

