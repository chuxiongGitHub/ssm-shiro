package com.rainbow.controller.restful;

import com.rainbow.dto.BaseResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by rainbow on 2016/8/17.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/rest")
public class TestController {

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    //获取系统当前时间
    public BaseResult<Long> getnow() {


        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();

        return new BaseResult<Long>(true, df.format(date.getTime()));

    }
}
