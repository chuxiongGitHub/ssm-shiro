package com.rainbow.service.impl;

import com.rainbow.entity.User;
import com.rainbow.exception.BusinessException;
import com.rainbow.mapper.UserMapper;
import com.rainbow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    //注入mapper
    @Autowired
    private UserMapper userMapper;

    public boolean updatePwd(String id, String pwd, String newPwd) {
        User user;


        return false;
    }


    public List<User> getUserList() {
        List<User> list = userMapper.getUserList();
        return list;
    }

    public void save(User user) throws BusinessException {
        logger.info("调用插入数据的方法");
        try {
            User getUser = userMapper.queryUserByName(user.getUsername());
            if (getUser != null) {
                logger.error("用户名已经存在:{}", user.getUsername());
                throw new BusinessException("插入用户失败，用户名已经存在");
            } else {
                userMapper.save(user);
                logger.info("插入的数据是：{}", user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
