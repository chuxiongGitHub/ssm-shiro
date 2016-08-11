package com.rainbow.service;

/**
 * Created by rainbow on 2016/8/11.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */

import com.rainbow.entity.ActiveUser;
import com.rainbow.entity.SysUser;
import com.rainbow.exception.BusinessException;
import org.springframework.stereotype.Service;

/**
 * 认证授权服务接口
 */
public interface SysService {

    //根据用户的身份和密码进行身份认证，如果认证通过，则返回用户信息
    public ActiveUser authenticat(String userCode, String password) throws BusinessException;

    //根据用户账号查找用户信息
    public SysUser findSysUserByUserCode(String userCode) throws BusinessException;

}
