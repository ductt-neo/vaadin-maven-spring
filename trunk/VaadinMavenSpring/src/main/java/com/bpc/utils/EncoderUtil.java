package com.bpc.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * Created by IntelliJ IDEA.
 * User: Bui_qt
 * Date: 11/30/11
 * Time: 1:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class EncoderUtil {
    public static String encodeStringMd5(String input){
        String encodedPass = "";
        PasswordEncoder encoder = new Md5PasswordEncoder();
        encodedPass = encoder.encodePassword(input, null);
        return encodedPass;
    }
}
