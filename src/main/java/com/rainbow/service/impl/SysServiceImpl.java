package com.rainbow.service.impl;

import com.rainbow.common.MD5;
import com.rainbow.entity.ActiveUser;
import com.rainbow.entity.SysUser;
import com.rainbow.entity.SysUserExample;
import com.rainbow.exception.BusinessException;
import com.rainbow.mapper.SysUserMapper;
import com.rainbow.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rainbow on 2016/8/11.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Service
public class SysServiceImpl implements SysService {
    private static Logger logger = LoggerFactory.getLogger(SysServiceImpl.class);
    @Autowired
    private SysUserMapper sysUserMapper;

    public ActiveUser authenticat(String usercode, String password) throws BusinessException {
        //根据用户账号查找用户
        SysUser sysUser = this.findSysUserByUserCode(usercode);
        if (sysUser == null) {
            //账号不存在
            logger.error("不存在账号：{}", usercode);
            throw new BusinessException("用户账号不存在");
        }
        String db_password = sysUser.getPassword();
        //对比密码
        //对页面输入的密码进行加密
        //String password_input_md5 = new MD5().getMD5ofStr(password);
        if (!password.equals(db_password)) {
            throw new BusinessException("用户民或者密码错误");
        }
        //认证通过,返回用户身份信息
        ActiveUser activeUser = new ActiveUser();

        activeUser.setUserId(sysUser.getId());
        activeUser.setUserCode(usercode);
        activeUser.setUsername(sysUser.getUsername());

        return activeUser;
    }

    //根据用户账号查询用户信息
    public SysUser findSysUserByUserCode(String usercode) throws BusinessException {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsercodeEqualTo(usercode);

        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);

        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
