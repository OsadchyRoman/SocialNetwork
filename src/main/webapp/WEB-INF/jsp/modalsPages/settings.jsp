<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="modalSettings" class="modalDialog">
    <div>
        <a href="#close" title="Закрыть" class="close">X</a>
        <form action="${contextPath}/setting" method="post">

            <!--Setting-->
            <input type="hidden" name="settingId" value="${user.settingId.id}">
            <p>
                <input type="checkbox" id="visionForAnonymous" name="visionForAnonymous"
                       <c:if test="${loginUser.settingId.visionForAnonymous == 'on'}">checked="checked"</c:if>>
                <label for="visionForAnonymous">Отображать ли страницу для неавторизированных пользователей ?</label>
            </p>
            <p>
                <input type="checkbox" id="visionForNonFriend" name="visionForNonFriend"
                       <c:if test="${loginUser.settingId.visionForNonFriend == 'on'}">checked="checked"</c:if>>
                <label for="visionForNonFriend">Отображать ли страницу для не друзей ?</label>
            </p>
            <p>
                <input type="checkbox" id="visionFriends" name="visionFriends"
                       <c:if test="${loginUser.settingId.visionFriends == 'on'}">checked="checked"</c:if>>
                <label for="visionFriends">Отображать ли друзей</label>
            </p>
            <p>
                <input type="checkbox" id="visionPresents" name="visionPresents"
                       <c:if test="${loginUser.settingId.visionPresents == 'on'}">checked="checked"</c:if>>
                <label for="visionPresents">Отображать ли подарки?</label>
            </p>
            <p>
                <input type="checkbox" id="visionGroups" name="visionGroups"
                       <c:if test="${loginUser.settingId.visionGroups == 'on'}">checked="checked"</c:if>>
                <label for="visionGroups">Отображать ли подарки?</label>
            </p>
            <p>
                <input type="checkbox" id="visionSex" name="visionSex"
                       <c:if test="${loginUser.settingId.visionSex == 'on'}">checked="checked"</c:if>>
                <label for="visionSex">Отображать пол?</label>
            </p>
            <p>
                <input type="checkbox" id="visionAge" name="visionAge"
                       <c:if test="${loginUser.settingId.visionAge == 'on'}">checked="checked"</c:if>>
                <label for="visionAge">Отображать возраст ?</label>
            </p>
            <p>
                <input type="checkbox" id="visionCountryCity" name="visionCountryCity"
                       <c:if test="${loginUser.settingId.visionCountryCity == 'on'}">checked="checked"</c:if>>
                <label for="visionCountryCity">Отображать ли Страна/Город ?</label>
            </p>
            <p>
                <label for="visionAge">В каком виде отображать возраст?</label>
            </p>
            <p>
                <input type="checkbox" id="ageDate" name="ageDate">
                <label for="ageDate">dd/mm/yyyy</label>
                <input type="checkbox" id="howManyYear" name="howManyYear">
                <label for="howManyYear">Количество полных лет</label>
            </p>

            <!--User-->
            <input type="hidden" name="userId" value="${loginUser.id}">
            <p>
                <label>Имя</label>
                <input type="text" id="name" name="name" value="${loginUser.name}">
            </p>
            <p>
                <label>Фамилия</label>
                <input type="text" name="surname" value="${loginUser.surname}">
            </p>
            <p>
                <label>Отчество</label>
                <input type="text" name="middleName" value="${loginUser.middleName}">
            </p>
            <p>
                <label>День/Месяц/Год рождения</label>
                <input type="text" name="birthday" id="date" value="${loginUser.birthday}">
            </p>
            <p>
                <label>Пол</label>
                <input type="text" name="sex" value="${loginUser.sex}">
            </p>
            <p>
                <label>Страна/Город рождения</label>
                <input type="text" name="countryCityBirth" value="${loginUser.countryCityBirth}">
            </p>
            <p>
                <label>Старый пароль</label>
                <input type="text" name="password" value="${loginUser.password}">
            </p>
            <p>
                <label>Новый пароль</label>
                <input type="password" name="newPassword">
            </p>
            <input type="submit" value="Сохранить"/>
        </form>
    </div>
</div>