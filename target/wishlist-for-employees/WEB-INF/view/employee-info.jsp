<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kaya
  Date: 24/10/2022
  Time: 6:01 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>
<br>
<form:form action="saveNewEmployee" modelAttribute="employee">
    <form:hidden path="id"/>
    <form:hidden path="wishlist"/> <%--тогда у каждого работника также сразу создастся вишлист --%>
    Name <form:input path="name"/>
    <br>
    <br>
    Surname <form:input path="surname"/>
    <br>
    <br>
    Birthday <form:select path="birthDay" items="${employee.daysList}"/> <form:select path="birthMonth" items="${employee.monthsList}"/>
    <br>
    <br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>


