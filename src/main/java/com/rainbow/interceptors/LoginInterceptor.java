package com.rainbow.interceptors;

import com.rainbow.common.ResourcesUtil;
import com.rainbow.entity.ActiveUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by rainbow on 2016/8/12.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //得到请求的URL地址
        String url = httpServletRequest.getRequestURI();

        //从配置文件中获取公开的URL地址

        List<String> open_lists = ResourcesUtil.gekeyList("anonymousURL");
        //去遍历公开地址:是公开地址，则放行
        for (String open_list : open_lists) {
            if (url.indexOf(open_list) >= 0) {
                return true;
            }
        }
        //判断用户是否在session中
        HttpSession session = httpServletRequest.getSession();
        ActiveUser activeUser = (ActiveUser) session.getAttribute("activeUser");
        if (activeUser != null) {
            return true;
        }
        //否在就跳转到登录页面
        httpServletRequest.getRequestDispatcher("/WEB-INF/template/shiro/login.jsp").
                forward(httpServletRequest, httpServletResponse);

        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
