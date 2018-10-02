<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="${contextPath}/js/jquery.maskedinput.min.js"></script>
    <script src="${contextPath}/js/script.js"></script>
</head>
<body>
<div id="modalRegistration" class="modalDialog">
    <div>
        <a href="#close" title="Закрыть" class="close">X</a>
        <p style="color: red;">${error}</p>
        <form method="post" action="${contextPath}/registration">
            <p>
                <label>Имя</label>
                <input type="text" id="name" name="name" value="${userForCreate.name}">
            </p>
            <p>
                <label>Фамилия</label>
                <input type="text" name="surname" value="${userForCreate.surname}">
            </p>
            <p>
                <label>Отчество</label>
                <input type="text" name="middleName" value="${userForCreate.middleName}">
            </p>
            <p>
                <label>День/Месяц/Год рождения</label>
                <input type="text" name="birthday" id="date" value="${userForCreate.birthday}">
            </p>
            <p>
                <label>Пол</label>
                <input type="text" name="sex" value="${userForCreate.sex}">
            </p>
            <p>
                <label>Страна/Город рождения</label>
                <input type="text" name="countryCityBirth" id="countryCity" value="${userForCreate.countryCityBirth}">
            </p>
            <p>
                <label>Логин для входа в аккаунт</label>
                <input type="text" name="login" value="${userForCreate.login}">
            </p>
            <p>
                <label>Пароль для входа в аккаунт</label>
                <input type="text" name="password" value="${userForCreate.password}">
            </p>
            <input type="submit" value="Зарегистрироваться"/>
        </form>
    </div>
</div>
</body>