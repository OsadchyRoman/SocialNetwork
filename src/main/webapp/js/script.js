$(document).ready(function () {
    $('#exit').on('click', function () {
        $.get("exit", function () {
            top.location.href = "/index";
        });
    });
});

function addFriendToList(event) {
    var formId = serviceAjaxForm(event);
    sendAjaxForm(formId, 'addFriend');
    return false;
}

function deleteFriendFromList(event) {
    var formId = serviceAjaxForm(event);
    sendAjaxForm(formId, 'deleteFriend');
    return false;
}

function sendMessageForFriend(event) {
    var formId = serviceAjaxForm(event);
    alert(formId);
    sendAjaxFormId(formId, 'sendMessage');
    return false;
}

function serviceAjaxForm(event) {
    event.preventDefault();
    var idFlight = $(event.target).attr('id');
    return $('#' + idFlight).closest('form').attr('class');
}
function sendAjaxFormId(formId, url) {
    $.ajax({
        url: url, //url страницы (action_ajax_form.php)
        type: "POST",
        dataType: "html",
        data: $('.' + formId).serialize(),
        success: function () {
            $('#modalPageSendMessage').load(document.URL + ' #sendMessageForm');
            $('#modalDialog').load(document.URL + ' #formDialog');
        }
    });
}

function sendAjaxForm(formId, url) {
    $.ajax({
        url: url, //url страницы (action_ajax_form.php)
        type: "POST",
        dataType: "html",
        data: $('.' + formId).serialize(),
        success: function () {
            $('#viewHealpfulButtons').load(document.URL + ' #healpfulButton');
            $('#modalFriends').load(document.URL + ' #listFriends');
        }
    });
}

function cutLongMessage() {
    var elem, size, text;
    size = 30;
    elem = document.getElementsByClassName('message');
    for (var key in elem) {
        text = elem[key].innerHTML;
        if (text && text.length > size) {
            text = text.slice(0, size);
            elem[key].innerHTML = text + '...';
        }
    }
};

function deleteElementByClass(elementClass) {
    $('.' + elementClass).remove();
}

function deleteElementById(elementId) {
    $('#' + elementId).remove();
}

$(function () {
    $("#date").mask("99/99/9999", {placeholder: "__/__/____"});
});
$(function () {
    $("#countryCity").mask("****?*********/****?*******");
});