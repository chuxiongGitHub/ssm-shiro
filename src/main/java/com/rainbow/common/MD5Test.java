package com.rainbow.common;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by rainbow on 2016/8/25.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class MD5Test {
    public static void main(String[] args) {
        String resource = "111111";
        String salt = "jljoo%%";
        int hashIterations = 1;
        //构造方法中，第一个参数是原始信息，第二个参数是盐，第三个参数是散列次数
        Md5Hash md5Hash = new Md5Hash(resource, salt, hashIterations);

        String password_md5 = md5Hash.toString();
        System.out.println(password_md5);

        //第一个参数是散列的算法

        SimpleHash simpleHash = new SimpleHash("md5", resource, salt, hashIterations);

        System.out.println(simpleHash.toString());
    }
}
