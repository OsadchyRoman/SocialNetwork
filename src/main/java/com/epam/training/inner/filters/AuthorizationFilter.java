package com.epam.training.inner.filters;

import com.epam.training.inner.model.Setting;
import com.epam.training.inner.model.User;
import com.epam.training.inner.service.IUserService;
import com.epam.training.inner.utils.DefaultSetting;
import com.epam.training.inner.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/userInfo"})
public class AuthorizationFilter implements Filter {

    @Autowired
    private IUserService iUserService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String anonymous = null;
        String userId = request.getParameter("userId");
        Setting setting = DefaultSetting.getDefaultSetting();
        User findUser;
        User user = MyUtils.getLoginedUser(request.getSession());
        boolean error = false;
        if (userId != null && !"".equals(userId)) {
            findUser = iUserService.findById(Long.valueOf(userId));
            if (findUser != null) {
                setting = findUser.getSettingId();
            } else {
                error = true;
            }
            if (user == null && findUser != null) {
                if (!"on".equals(setting.getVisionForAnonymous())) {
                    error = true;
                }
                anonymous = "isAnonim";
            } else {
                anonymous = "isUser";
            }

        } else {
            error = true;
        }
        if (error) {
            response.sendRedirect("/error");
            return;
        }
        servletRequest.setAttribute("anonymous", anonymous);
        servletResponse.setContentType("text/html; charset=UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
