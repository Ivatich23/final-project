
package com.epam.valevach.final_project.security;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class PasswordHashing {
    private static PasswordHashing instance;
    private PasswordHashing(){}
    public static PasswordHashing getInstance(){
        synchronized (PasswordHashing.class) {
            if (instance == null) {
                instance = new PasswordHashing();
            }
        }
        return instance;
    }
    public String passwordHashing(String password) {
        byte[] hashPassword = null;
        String myHash=null;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            hashPassword=md5.digest(password.getBytes(StandardCharsets.UTF_8));
             myHash = DatatypeConverter
                    .printHexBinary(hashPassword).toLowerCase(Locale.ROOT);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return myHash;
    }
}

