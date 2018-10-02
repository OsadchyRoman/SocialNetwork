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
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class AuthorizationServlet extends HttpServlet {

    @Autowired
    private IUserService IUserService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = IUserService.findByLogin(login);

        boolean hasError = false;
        String errorString = null;


        if (user == null || !password.equals(user.getPassword())) {
            hasError = true;
            errorString = "Wrong login or password";
        }
        if (hasError) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("login", login);
            RequestDispatcher dispatcher
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");

            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
            MyUtils.storeUserCookie(response, user);
            response.sendRedirect(request.getContextPath() + "/userInfo?userId=" + user.getId());
        }
    }
}
