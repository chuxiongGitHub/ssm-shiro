package com.rainbow.controller;

import com.rainbow.entity.User;
import com.rainbow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/userForm")
    public String userForm() {
        return "userForm";
    }

    //用户注册
    @RequestMapping(value = "/register")
    public String register(User user, Model model, HttpServletRequest request) {

        userService.save(user);
        request.setAttribute("username", user.getUsername());
        return "index";
    }
}
