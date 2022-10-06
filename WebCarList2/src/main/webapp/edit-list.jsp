<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing List</title>
</head>
<body>
<form action = "editListDetailServlet" method="post">
<input type ="hidden" name = "id" value= "${carsToEdit.id}">
List Name: <input type ="text" name = "listName" value=
"${carsToEdit.driverName}"><br />
Driver Name: <input type = "text" name = "driverName" value=
"${listToEdit.shopper.driverName}"><br />
Available Cars:<br />
<select name="allCarsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCars}" var="currentCar">
 <option value = "${currentCar.id}">${currentCar.make} |
${currentCar.model}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Cars">
</form>
<a href = "index.html">Add new Cars.</a>
</body>
</html>