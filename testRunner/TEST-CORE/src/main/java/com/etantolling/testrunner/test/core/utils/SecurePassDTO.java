package com.etantolling.testrunner.test.core.utils;

/**
 * Created by mario on 31/08/2016.
 */
public class SecurePassDTO {
    private String password;
    private String salt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
