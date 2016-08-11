package com.rainbow.service;

import com.rainbow.entity.SysUser;
import com.rainbow.entity.SysUserExample;
import com.rainbow.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/11.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class SysServiceTest {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testFindSysUserByUserCode() throws Exception {
        String userCode = "zhangsan";
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsercodeEqualTo(userCode);

        List<SysUser> sysUsers =sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers!=null&&sysUsers.size()==1){
            System.out.println(sysUsers.get(0).getUsername());
        }
        else {
            System.out.println("用户名不存在");
        }


    }
}