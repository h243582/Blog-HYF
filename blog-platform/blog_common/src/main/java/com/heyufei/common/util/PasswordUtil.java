package com.heyufei.common.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 密码工具
 *
 * @author HeYuFei
 * @since 2023-03-30  10:03
 */
public class PasswordUtil {
    private static final int MASK = Character.codePointAt("n", 0);

    /**
     * 加密
     */
    public static String encrypt(String password) {
        var ret = new StringBuilder();
        for (var i = 0; i < password.length(); i++) {
            ret.append((char) (Character.codePointAt(password, i) ^ MASK));
        }
        return java.util.Base64.getEncoder().encodeToString(ret.toString().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 解密
     */
    public static String decrypt(String ret) {
        byte[] decodeByte = Base64.getDecoder().decode(ret.getBytes(StandardCharsets.UTF_8));
        var password = new String(decodeByte);
        var builder = new StringBuilder();
        for (var i = 0; i < password.length(); i++) {
            builder.append((char) (Character.codePointAt(password, i) ^ MASK));
        }
        return builder.toString();
    }
}
