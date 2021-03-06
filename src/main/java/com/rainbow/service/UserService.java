package com.rainbow.service;

import com.rainbow.dto.UserResult;
import com.rainbow.entity.User;
import com.rainbow.exception.BusinessException;

import java.util.List;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface UserService {
    //修改密码
    boolean updatePwd(String id, String pwd, String newPwd);

    //新增用户
    void save(User user) throws BusinessException;

    List<User> getUserList();


    public User getUserByName(String username);

    public UserResult getUserById(Long userId);

    public void delById(Long id);
}
