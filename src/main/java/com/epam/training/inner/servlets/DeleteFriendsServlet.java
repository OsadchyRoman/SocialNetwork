package com.epam.training.inner.servlets;

import com.epam.training.inner.model.User;
import com.epam.training.inner.service.IUserService;
import com.epam.training.inner.utils.MyUtils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/deleteFriend"})
public class DeleteFriendsServlet extends HttpServlet {

    @Autowired
    private IUserService iUserService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session);
        String friendId = req.getParameter("friendId");

        if (friendId != null) {
            User friend = iUserService.findById(Long.valueOf(friendId));
            iUserService.remove(user, friend);
            iUserService.remove(friend, user);
        }

    }
}
