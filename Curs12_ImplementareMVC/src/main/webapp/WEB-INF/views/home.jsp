<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Bine ai venit in lumea Spring MVC!</h1>

<P>Timpul pe server este: ${serverTime}.</p>

<%--	acesta este un action form care inregistreaza un user name--%>
<form action="user" method="post">
    <input type="text" name="userName"><br>
    <input type="text" name="emailAddress"><br>
    <input type="text" mame="phoneNumber"><br>
    <input type="date" name="birthDate"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>