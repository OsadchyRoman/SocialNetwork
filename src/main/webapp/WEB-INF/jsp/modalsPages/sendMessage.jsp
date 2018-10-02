<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="modalPageSendMessage" class="modalDialog">
    <div id="sendMessageForm">
        <a href="#close" title="Закрыть" class="close">X</a>
        <form method="post" class="sendMessage">
            <input type="hidden" name="toUserId" value="${user.id}">
            <p>
                <textarea cols="52" rows="15" id="messageTextarea" name="message"></textarea>
            </p>
            <p>
                <input type="button" value="Отправить сообщение" id="send${user.id}"
                       onclick="sendMessageForFriend(event)"/>
            </p>
        </form>
    </div>
</div>