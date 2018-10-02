<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="modalFriends" class="modalDialog">
    <div id="listFriends">
        <a href="#close" title="Закрыть" class="close">X</a>
        <c:forEach items="${loginUser.friends}" var="friend">
            <form method="post" class="formForDeleteFriend${friend.id}">
                <a href="/userInfo?userId=${friend.id}">${friend.name}</a>
                <input type="hidden" name="friendId" value="${friend.id}"/>
                <input type="button" value="delete" id="delete${friend.id}"
                       onclick="deleteFriendFromList(event)"/>
            </form>
        </c:forEach>
    </div>
</div>
