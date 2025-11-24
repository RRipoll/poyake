package com.etantolling.testrunner.test.core.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.etantolling.testrunner.test.core.config.AppInfo;

/**
 * Created by mario on 31/08/2016.
 */
public class Encryption {
    private static final Integer ITERATIONS = 100;                  // DO NOT CHANGE THIS VALUE!!!!
    private static final Integer KEYLENGTH = 256;                   // DO NOT CHANGE THIS VALUE!!!!
    private static final String ALGORITHM = "PBKDF2WithHmacSHA512"; // DO NOT CHANGE THIS VALUE!!!!
//    public static final Boolean ON = Boolean.FALSE;             // CHANGE THIS LINE TO TURN THE ENCRYPTION ON OR OFF
	//private static final Logger log = LoggerFactory.getLogger(Encryption.class);

    public static SecurePassDTO encrypt(String password){
        SecurePassDTO spass = new SecurePassDTO();
        Base64.Encoder b64encoder = Base64.getEncoder();
        SecureRandom r = new SecureRandom();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] salt = new byte[32];
            r.nextBytes(salt);
            PBEKeySpec spec = new PBEKeySpec( password.toCharArray(), salt, ITERATIONS, KEYLENGTH );
            SecretKey key = skf.generateSecret( spec );
            spass.setSalt(b64encoder.encodeToString(salt));
            spass.setPassword(b64encoder.encodeToString(key.getEncoded()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {}

        return spass;
    }

    public static Boolean authenticate(SecurePassDTO storedPass, String newPass){
       return authenticate(storedPass.getPassword(), storedPass.getSalt(), newPass);
    }

    public static Boolean authenticate(String oldPass, String curentSalt, String newPass){
        Base64.Decoder b64decoder = Base64.getDecoder();
        Base64.Encoder b64encoder = Base64.getEncoder();

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            PBEKeySpec spec = new PBEKeySpec( newPass.toCharArray(), b64decoder.decode(curentSalt), ITERATIONS, KEYLENGTH );
            SecretKey key = skf.generateSecret( spec );
            return b64encoder.encodeToString(key.getEncoded()).equals(oldPass);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {}

        return false;
    }

    public String generateSalt(){
        Base64.Encoder b64encoder = Base64.getEncoder();
        SecureRandom r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        return b64encoder.encodeToString(salt);
    }
    
    public static boolean isCustomerEncryptionEnabled() throws SQLException {
		return AppInfo.get(AppInfo.CUSTOMER_CREDENTIALS_ENCRYPTED) != null && AppInfo.getInt(AppInfo.CUSTOMER_CREDENTIALS_ENCRYPTED) == 1;
    }
    
    public static boolean isInputUserEncryptionEnabled() throws SQLException {
		return AppInfo.get(AppInfo.INPUT_USER_CREDENTIALS_ENCRYPTED) != null && AppInfo.getInt(AppInfo.INPUT_USER_CREDENTIALS_ENCRYPTED) == 1;
    }
}
