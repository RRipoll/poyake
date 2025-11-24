package com.etantolling.testrunner.test.core.utils;

import java.util.Base64;

public class EncryptUtils {
	private static String key = "This is the bloody key that we are going to use for UDOT";
	
	public static void main(String[] args){
		System.out.println(encode("The world is mine"));
		System.out.println(decode(encode("The world is mine")));
	}
	
    public static String encode(String s) {
        return base64Encode(xorWithKey(s.getBytes(), key.getBytes()));
    }

    public static String decode(String s) {
        return new String(xorWithKey(base64Decode(s), key.getBytes()));
    }

    private static byte[] xorWithKey(byte[] a, byte[] key) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ key[i%key.length]);
        }
        return out;
    }

    private static byte[] base64Decode(String s) {
    	Base64.Decoder decoder = Base64.getDecoder();
    	byte[] ciphertextArray = decoder.decode(s);
        return ciphertextArray;
    }

    private static String base64Encode(byte[] bytes) {
    	Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);

    }
}