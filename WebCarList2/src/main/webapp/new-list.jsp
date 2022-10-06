<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Driver Name: <input type = "text" name = "driverName"><br />

Available Cars:<br />
<select name="allCarsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCars}" var="currentCar">
 <option value = "${currentCar.id}">${currentCar.make} |${currentCar.model}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>