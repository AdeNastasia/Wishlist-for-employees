<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kaya
  Date: 24/10/2022
  Time: 10:07 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h2>Employees</h2>
<br>
<table>
    <tr>
        <th>Operations</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Birthday</th>
        <th>Wishlist</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

    <c:url var="deleteButton" value="/deleteEmployee">
        <c:param name="empId" value="${emp.id}"/>
    </c:url>

    <c:url var="seeEmployeeWishesButton" value="/wishes">
        <c:param name="empId" value="${emp.id}"/>
    </c:url>



        <tr>
            <td>
                <input type="button" value="Update" onclick="window.location.href='${updateButton}'">

                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">
            </td>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.birthDay} ${emp.birthMonth}</td>
            <td>
                <input type="button" value="🌟" onclick="window.location.href='${seeEmployeeWishesButton}'">
            </td>
        <tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add" onclick="window.location.href = 'addNewEmployee'"/>
</body>
</html>
