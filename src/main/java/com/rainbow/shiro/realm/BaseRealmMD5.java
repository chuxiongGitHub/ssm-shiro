package com.rainbow.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by rainbow on 2016/8/25.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class BaseRealmMD5 extends AuthorizingRealm {
    @Override
    public void setName(String name) {
        super.setName("baseRealmMD5");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //第一步，从token中取出用户信息
        String usercode = (String) authenticationToken.getPrincipal();

        //第二步：使用用户输入的usercode从数据库查询

        //取出数据库的密码,这里是散列后的值

        String password = "b84fd91a02ea3cfc4b242ed29848357c";
        //从数据库中获取盐
        String salt = "jljoo%%";
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usercode, password, ByteSource.Util.bytes(salt), this.getName());
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
