package com.epam.training.inner.servlets;

import com.epam.training.inner.model.User;
import com.epam.training.inner.service.IUserService;
import com.epam.training.inner.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = {"/userInfo"})
public class UserInfoServlet extends HttpServlet {

    @Autowired
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long userId = Long.valueOf(request.getParameter("userId"));
        HttpSession session = request.getSession();
        User user = MyUtils.getLoginedUser(session);
        response.getWriter().write(request.getRequestURL().toString());
        User userGuest = userService.findById(userId);

        if (user == null && userGuest == null) {
            response.sendRedirect(request.getContextPath() + "/error");
            return;
        }
        if (user != null && Objects.equals(user.getId(), userId)) {
            request.setAttribute("user", user);
            request.setAttribute("loginUser", user);
        } else if (userGuest != null) {
            if (user != null) {
                request.setAttribute("loginUser", user);
                request.setAttribute("isGuest", true);
                if (user.getFriends().contains(userGuest)) {
                    request.setAttribute("deleteFriend", true);
                } else {
                    request.setAttribute("deleteFriend", false);
                }
            }
            request.setAttribute("user", userGuest);
        }

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/userInfoView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
