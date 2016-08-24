package com.rainbow.controller;

import com.rainbow.common.Encrypt;
import com.rainbow.dto.BaseResult;
import com.rainbow.entity.ActiveUser;
import com.rainbow.entity.User;
import com.rainbow.exception.BusinessException;
import com.rainbow.service.SysService;
import com.rainbow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ParseState;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public String register(Model model, HttpServletRequest request) throws BusinessException {
        try {
            User user=new User();
            //user.setPassword(Encrypt.encode(user.getPassword(),Encrypt.ENCODE_TYPE_PASSWORD));
            userService.save(user);
            request.setAttribute("username", user.getUsername());
        } catch (Exception e) {
           e.printStackTrace();

        }
        return "redirect:/user/getUserList";
    }

    @RequestMapping(value = "/first")
    public String first() {
        return "shiro/first";
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

    //用户退出
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) throws BusinessException {

        //session失效
        session.invalidate();

        return "redirect:/user/loginForm";
    }

    public ModelAndView test(){

        List<User> user=userService.getUserList();

        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("user",user);
        modelAndView.setViewName("test");

        return modelAndView;


    }

}
