package com.rainbow.mapper;

import com.rainbow.entity.User;
import com.rainbow.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class UserMapperTest {
    private static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSave() throws Exception {

        User user = new User();

        user.setUsername("dd");
        user.setPassword("dd");
        user.setRemark("fsaf");
        userMapper.save(user);
    }

    @Test
    public void testSave1() throws Exception {

    }

    @Test
    public void testQueryUserByName() throws BusinessException {

        String username = "彩虹22";
        User user = userMapper.queryUserByName(username);
        if (user != null) {
            throw new BusinessException( "用户名已经存在:"+username);
        }
        logger.info("恭喜用户名可用");


    }
}