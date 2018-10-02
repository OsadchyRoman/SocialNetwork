package com.epam.training.inner.servlets;

import com.epam.training.inner.model.Setting;
import com.epam.training.inner.model.User;
import com.epam.training.inner.service.ISettingService;
import com.epam.training.inner.service.IUserService;

import com.epam.training.inner.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (urlPatterns = ("/setting"))
public class SettingServlet extends HttpServlet {

    @Autowired
    private IUserService IUserService;

    @Autowired
    private ISettingService ISettingService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Settings
        String settingId = request.getParameter("settingId");
        String visionForAnonymous = request.getParameter("visionForAnonymous");
        String visionForNonFriend = request.getParameter("visionForNonFriend");
        String visionFriends = request.getParameter("visionFriends");
        String visionPresents = request.getParameter("visionPresents");
        String visionGroups = request.getParameter("visionGroups");
        String visionSex = request.getParameter("visionSex");
        String visionAge = request.getParameter("visionAge");
        String visionCountryCity = request.getParameter("visionCountryCity");

        //User
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String middleName = request.getParameter("middleName");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String countryCityBirth = request.getParameter("countryCityBirth");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");

        if (!password.equals(newPassword)) {
            password = newPassword;
        }
        HttpSession session = request.getSession();
        User user = MyUtils.getLoginedUser(session);
        user.setName(name);
        user.setSurname(surname);
        user.setMiddleName(middleName);
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setCountryCityBirth(countryCityBirth);
        user.setPassword(password);
        user.setId(Long.valueOf(userId));
        IUserService.updateUser(user);


        Setting setting = new Setting(visionForAnonymous, visionForNonFriend, visionFriends,
                visionPresents, visionGroups, visionSex, visionAge, visionCountryCity);
        setting.setId(Long.valueOf(settingId));
        ISettingService.updateSetting(setting);
        user.setSettingId(setting);
        response.sendRedirect(request.getContextPath() + "/userInfo?userId=" + user.getId());
    }
}
