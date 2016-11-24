package me.yoryor.spfactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestFactory {
    private String algorithmName = "MD5";

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public MessageDigest newInstance() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithmName);
    }
}
