package com.epam.training.inner.servlets;

import com.epam.training.inner.model.Dialog;
import com.epam.training.inner.model.User;
import com.epam.training.inner.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Autowired
    private IUserService iUserService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = iUserService.findById(1L);
        List<Dialog> dialog = user.getUserDialogs();
        dialog.get(dialog.size()-1);

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");

        dispatcher.forward(req, resp);
    }

}
