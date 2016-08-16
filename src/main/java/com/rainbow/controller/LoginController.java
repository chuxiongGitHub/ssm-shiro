package com.rainbow.controller;

import com.rainbow.entity.ActiveUser;
import com.rainbow.entity.SysUser;
import com.rainbow.exception.BusinessException;
import com.rainbow.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by rainbow on 2016/8/15.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/form")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysService sysService;


    @RequestMapping(value = "/login")
    public String login(String usercode, String password, HttpSession session) throws BusinessException {

        //        //校验验证码
//        //从session中获取正确的验证码
//        String validateCode = (String) session.getAttribute("validateCode");
//
//        //输入的验证和session中进行校验
//        if (!randomCode.equals(validateCode)) {
//            throw new BusinessException("验证码输入错误");
//        }
        ActiveUser activeUser = sysService.authenticat(usercode, password);
        session.setAttribute("activeUser", activeUser);

        return "redirect:user/first.action";


    }
}
