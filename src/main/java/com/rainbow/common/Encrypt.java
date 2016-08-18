package com.rainbow.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by rainbow on 2016/8/15.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class Encrypt {

    public static final String ENCODE_TYPE_PASSWORD = "password";
    public static final String ENCODE_TYPE_MANAGE_PASSWORD = "manage_password";

    public static String encode(String input, String encodeType) {
        if (ENCODE_TYPE_PASSWORD.equals(encodeType)) {
            return md5(input).toLowerCase();
        }
        if (ENCODE_TYPE_MANAGE_PASSWORD.equals(encodeType)) {
            return Base64.encodeBase64String(sha1(input).getBytes());
        }
        return input;
    }

    public static String md5(String input) {
        return DigestUtils.md5Hex(input);
    }

    public static String sha1(String input) {
        return DigestUtils.sha1Hex(input);
    }
}
