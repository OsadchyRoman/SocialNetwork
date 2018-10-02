<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<body onload="cutLongMessage()">
<div id="modalDialog" class="modalDialog">
    <div id="formDialog">
        <a href="#close" title="Закрыть" class="close">X</a>
        <c:forEach items="${loginUser.userDialogs}" var="dialog">
            <c:set var="lastMessage" value="${dialog.getLastMessage()}"/>
            <a href="#modalMessage"></a>
            <div class="dialog">
                <div class="photo-interlocutor">

                </div>
                <div class="dialog-last-message">
                    <div class="lable">
                            ${dialog.toUser.name} ${dialog.toUser.surname}
                    </div>
                    <div class="photo-whom-last-message">

                    </div>
                    <div class="last-message-dialog">
                        <div class="whom-last-message">
                                ${lastMessage.addByUserId.name} ${lastMessage.addByUserId.surname}
                        </div>

                        <div class="time-and-message">
                            <div class="time">${lastMessage.time}</div>
                            <div class="message">${lastMessage.textComment}</div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>