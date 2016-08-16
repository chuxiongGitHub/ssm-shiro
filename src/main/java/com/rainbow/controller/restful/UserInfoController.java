package com.rainbow.controller.restful;

import com.rainbow.controller.UserController;
import com.rainbow.dto.BaseResult;
import com.rainbow.entity.User;
import com.rainbow.exception.BusinessException;
import com.rainbow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by rainbow on 2016/8/16.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/rest")
public class UserInfoController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<User> userInfo() {

        BaseResult<User> result;
        try {
            List<User> list = userService.getUserList();

            result = new BaseResult<User>(true, list.toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
            result = new BaseResult<User>(false, e.getMessage());
        }
        return result;
    }

}
