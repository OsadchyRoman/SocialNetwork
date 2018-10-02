<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
</head>
<body>
<div id="menu">
    <p style="color: red;">${errorString}</p>
    <form method="post" action="${contextPath}/login">
        <p>
            <label>Логин</label>
            <input type="text" name="login" value="${login}">
        </p>
        <p>
            <label>Пароль</label>
            <input type="text" name="password">
        </p>
        <input type="submit" value="Submit"/>
    </form>
    <h4>
        <a href="#modalRegistration">Ещё не зарегистрировались?</a>
    </h4>
    <jsp:include page="modalsPages/registration.jsp"/>
</div>
