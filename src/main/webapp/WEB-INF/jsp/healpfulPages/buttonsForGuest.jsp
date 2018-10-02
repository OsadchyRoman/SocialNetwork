<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="healpfulButton">
    <c:choose>
        <c:when test="${deleteFriend == true}">
            <form method="post" class="formForDeleteFriend">
                <input type="hidden" name="friendId" value="${user.id}"/>
                <input type="button" value="Удалить из друзей" class="button  email" id="delete"
                       onclick="deleteFriendFromList(event)"/>
            </form>
            <a href="#modalPageSendMessage"><button class="button  email">Написать</button></a>
            <jsp:include page="../modalsPages/sendMessage.jsp"/>
        </c:when>
        <c:otherwise>
            <form method="post" class="formForAddFriend">
                <input type="hidden" name="friendIdAdd" value="${user.id}"/>
                <input type="button" value="Добавить в друзья" id="addFriend" class="button  email"
                       onclick="addFriendToList(event)"/>
            </form>
        </c:otherwise>
    </c:choose>
</div>