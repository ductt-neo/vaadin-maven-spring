package com.bpc.util;

import com.bpc.model.ScoringUser;
import com.bpc.services.ScoringUserAuthorityServices;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class UtilityTest extends TestCase {

    @Test
    public void testEncodePassword() throws NoSuchAlgorithmException {
        String pass = "333";

        PasswordEncoder encoder = new Md5PasswordEncoder();
        String encodedPass = encoder.encodePassword(pass, null);

        System.out.println("ENCODED PASS>>>"+encodedPass);
        Assert.assertNotNull(encodedPass);
    }


}
