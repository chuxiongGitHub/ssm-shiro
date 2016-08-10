package com.rainbow.service;

import com.rainbow.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSave() throws Exception {
        User user=new User();
        user.setUsername("ddd");
        user.setPassword("dsfasd");
        user.setRemark("dfafd");

        userService.save(user);



    }
}