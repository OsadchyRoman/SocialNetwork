package com.epam.training.inner.servlets;

import com.epam.training.inner.model.User;
import com.epam.training.inner.service.IUserService;
import com.epam.training.inner.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/addFriend"})
public class AddFriendServlet extends HttpServlet {

    @Autowired
    private IUserService iUserService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String friendId = req.getParameter("friendIdAdd");
        HttpSession session = req.getSession();
        User user = MyUtils.getLoginedUser(session);

        if (friendId != null) {
            User friend = iUserService.findById(Long.valueOf(friendId));
            iUserService.addFriend(user, friend);
            iUserService.addFriend(friend, user);
        }
    }
}
