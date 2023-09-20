package com.example.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
	
	public static String calcularHash(byte[] dados) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] hashBytes = md.digest(dados);
		
		StringBuilder hexString = new StringBuilder();
		for (byte hashByte : hashBytes) {
			String hex = Integer.toHexString(0xff & hashByte);
			if (hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		
		return hexString.toString();
	}

}
