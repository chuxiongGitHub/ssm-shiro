package com.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "shiro/first";
    }
}
