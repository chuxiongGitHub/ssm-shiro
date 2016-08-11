package com.rainbow.controller;

import com.rainbow.entity.ActiveUser;
import com.rainbow.entity.User;
import com.rainbow.exception.BusinessException;
import com.rainbow.service.SysService;
import com.rainbow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private SysService sysService;


    @RequestMapping(value = "/userForm")
    public String userForm() {
        return "userForm";
    }

    //用户注册
    @RequestMapping(value = "/register")
    public String register(User user, Model model, HttpServletRequest request) throws BusinessException {
        try {
            userService.save(user);
            request.setAttribute("username", user.getUsername());
        } catch (Exception e) {
            return "error";

        }
        return "index";
    }

    @RequestMapping(value = "/getUserList")
    public String getUserList(Model model) {
        List<User> list = userService.getUserList();
        model.addAttribute("user", list);
        return "userList";
    }

    //用户登录页面
    @RequestMapping(value = "/loginForm")
    public String loginForm() {
        return "shiro/login";
    }


    //用户登录
    public String login(String userCode, String password, HttpSession session) throws BusinessException {

//        //校验验证码
//        //从session中获取正确的验证码
//        String validateCode = (String) session.getAttribute("validateCode");
//
//        //输入的验证和session中进行校验
//        if (!randomCode.equals(validateCode)) {
//            throw new BusinessException("验证码输入错误");
//        }
        ActiveUser activeUser = sysService.authenticat(userCode, password);

        session.setAttribute("activeUser", activeUser);


        return null;

    }

    //用户退出
    public String logout(HttpSession session) throws BusinessException {

        //session失效
        session.invalidate();

        return "rediret:/loginForm";
    }
}
