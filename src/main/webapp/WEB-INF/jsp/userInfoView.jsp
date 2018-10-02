<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${contextPath}/css/style.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="${contextPath}/js/jquery.maskedinput.min.js"></script>
    <script src="${contextPath}/js/script.js"></script>

</head>
<body>
<div id="container">
    <c:choose>
        <c:when test="${anonymous == 'isAnonim'}">
            <jsp:include page="authorization.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="userInfoMenu.jsp"/>
        </c:otherwise>
    </c:choose>
    <div id="content">
        <div id="user-data">
            <div id="photo-healpful-button">
                <div id="user-photo">

                </div>
                <div id="viewHealpfulButtons">
                    <c:if test="${isGuest == true}">
                        <jsp:include page="healpfulPages/buttonsForGuest.jsp"/>
                    </c:if>
                </div>
            </div>
            <div id="user-information">
                <div id="nick-name">${user.name} ${user.surname}</div>
                <div id="central-information">
                    <p>
                        Middle name: <b>${user.middleName}</b>
                    </p>

                    <c:if test="${user.settingId.visionAge == 'on'}">
                        <p> Age: <b>${user.birthday}</b></p>
                    </c:if>

                    <c:if test="${user.settingId.visionSex == 'on'}">
                        <p> Sex: <b>${user.sex}</b></p>
                    </c:if>

                    <c:if test="${user.settingId.visionCountryCity == 'on'}">
                        <p>Country/City birth: <b>${user.countryCityBirth}</b></p>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
