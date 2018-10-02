package com.epam.training.inner.servlets;

import com.epam.training.inner.model.*;
import com.epam.training.inner.service.ISettingService;
import com.epam.training.inner.service.IUserService;
import com.epam.training.inner.utils.DefaultSetting;
import com.epam.training.inner.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/registration")
@MultipartConfig
public class CreateUserServlet extends HttpServlet {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ISettingService iSettingService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String middleName = request.getParameter("middleName");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String countryCityBirth = request.getParameter("countryCityBirth");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Setting setting = DefaultSetting.getDefaultSetting();
        List<Role> roles = iUserService.findAllRoles();
        User user = iUserService.findByLogin(login);

        boolean hasError = false;
        String errorString = null;

        if (name == null || password == null
                || name.length() == 0 || password.length() == 0 || user != null) {
            hasError = true;
            errorString = "Required email and password!";
        } else {
            user = new User(name, surname, middleName, birthday, sex, countryCityBirth, login,
                    password, roles.get(1), setting, new ArrayList<User>(), new ArrayList<>());
            iSettingService.saveSetting(setting);
            iUserService.saveUser(user);
        }
        if (hasError) {
            user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setMiddleName(middleName);
            user.setBirthday(birthday);
            user.setSex(sex);
            user.setCountryCityBirth(countryCityBirth);
            user.setLogin(login);
            user.setPassword(password);
            request.setAttribute("error", errorString);
            request.setAttribute("userForCreate", user);
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp");

            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, user);
            MyUtils.storeUserCookie(response, user);
            response.sendRedirect(request.getContextPath() + "/userInfo?userId=" + user.getId());
        }
    }
}



