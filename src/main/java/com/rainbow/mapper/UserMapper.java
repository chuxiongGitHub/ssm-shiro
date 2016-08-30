package com.rainbow.mapper;


import com.rainbow.dto.UserResult;
import com.rainbow.entity.User;

import java.util.List;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface UserMapper {

    //更改密码
    boolean updatePwd(String id, String pwd, String newPwd);

    //用户注册
    int save(User user);

    //根据用户名查询用户
    User queryUserByName(String username);

    //查询用户
    List<User> getUserList();

    //根据id查询用户
    UserResult getUserById(Long userId);

    //删除用户
    void delById(Long id);

    int updateUser(User user);

}
