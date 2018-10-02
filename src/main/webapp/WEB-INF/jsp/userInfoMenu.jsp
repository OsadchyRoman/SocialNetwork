<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section id="menu">
    <nav>
        <ul>
            <li><a href="${contextPath}/userInfo?userId=${loginUser.id}">Моя страница</a></li>
            <li><c:if test="${loginUser.settingId.visionFriends == 'on'}"><a href="#modalFriends">Друзья</a></c:if></li>
            <li><a href="#modalDialog" onload="cutLongMessage()">Мои сообщения</a></li>
            <hr>
            <li><a href="4.html">Популярные разделы</a></li>
            <li><a href="#modalSettings">Настройки</a></li>
            <li></li>
        </ul>
        <button id="exit">Выход</button>
    </nav>
</section>
<jsp:include page="modalsPages/settings.jsp"/>
<jsp:include page="modalsPages/friends.jsp"/>
<jsp:include page="modalsPages/dialog.jsp"/>