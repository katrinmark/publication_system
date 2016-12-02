package ru.innopolis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.constants.Constants;
import ru.innopolis.controller.UserController;
import ru.innopolis.exception.CustomException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * This util is used to encode
 */
public class Md5Util {
    private static final Logger LOGGER = LoggerFactory.getLogger(Md5Util.class.getName());

    private static String md5Encode(String line) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        byte[] digest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(line.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Encoding algorithm was not found", e);
            throw e;
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    public static String md5EncodePassword(String password) throws CustomException {
        try {
            password = md5Encode(password);
            password += "W5~#TIlhp4trgCLPtFMAoqL#P$xB35";
            password = md5Encode(password);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Failed encoding password", e);
            throw new CustomException(Constants.ERROR_USER_MSG);
        }
        return  password;
    }
}
