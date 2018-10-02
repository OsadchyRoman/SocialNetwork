package com.epam.training.inner.servlets;

import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.Message;
import com.epam.training.inner.model.User;
import com.epam.training.inner.service.IDialogService;
import com.epam.training.inner.service.IMessageService;
import com.epam.training.inner.service.IUserService;
import com.epam.training.inner.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/sendMessage"})
public class SendMessageServlet extends HttpServlet {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDialogService dialogService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String userToId = req.getParameter("toUserId");
        HttpSession session = req.getSession();
        User userFromId = MyUtils.getLoginedUser(session);

        User userToIdObject = userService.findById(Long.valueOf(userToId));

        Dialog dialog = dialogService.findByFromUserAndToUser(userFromId, userToIdObject);
        Dialog dialogFrom = dialogService.findByFromUserAndToUser(userToIdObject, userFromId);
        Message userMessage = new Message(userFromId, message);


        messageService.save(userMessage);

        dialogService.addMessage(dialog, userMessage);
        dialogService.addMessage(dialogFrom, userMessage);

        List<Dialog> list = userFromId.getUserDialogs().stream().filter(item -> item.getToUser().equals(userToIdObject))
                .collect(Collectors.toList());
        list.get(0).getMessages().add(userMessage);
    }
}
