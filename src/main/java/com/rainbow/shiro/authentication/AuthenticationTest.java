package com.rainbow.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rainbow on 2016/8/24.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class AuthenticationTest {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationTest.class);

    //用户的登录和退出

    @Test
    public void testLoginAndLogout() {

        //创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //创建securityManager
        SecurityManager securityManager = factory.getInstance();

        //将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        //从SecurityUtils里创建一个subject
        Subject subject = SecurityUtils.getSubject();

        //在认证提交前准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("rainbow", "111");

        //执行认证的提交
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //是否认证通过
        boolean flag = subject.isAuthenticated();

        logger.info("是否认证通过：" + flag);


        //退出操作
        subject.logout();
        flag = subject.isAuthenticated();

        logger.info("是否认证通过：" + flag);


    }
    @Test
    //自定义realm
    public void testRealm(){
        //创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //创建securityManager
        SecurityManager securityManager = factory.getInstance();

        //将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        //从SecurityUtils里创建一个subject
        Subject subject = SecurityUtils.getSubject();

        //在认证提交前准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("rainbow", "111");

        //执行认证的提交
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //是否认证通过
        boolean flag = subject.isAuthenticated();

        logger.info("是否认证通过：" + flag);


    }

    //自定义realm实现散列

    @Test
    public void testRealmMd5(){

        //创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-crypt.ini");

        //创建securityManager
        SecurityManager securityManager = factory.getInstance();

        //将securityManager设置当前的运行环境中
        SecurityUtils.setSecurityManager(securityManager);

        //从SecurityUtils里创建一个subject
        Subject subject = SecurityUtils.getSubject();

        //在认证提交前准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("rainbow", "111");

        //执行认证的提交
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //是否认证通过
        boolean flag = subject.isAuthenticated();

        logger.info("是否认证通过：" + flag);


        //退出操作
        subject.logout();
        flag = subject.isAuthenticated();

        logger.info("是否认证通过：" + flag);
    }

}
