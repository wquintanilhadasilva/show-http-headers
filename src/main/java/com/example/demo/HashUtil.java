package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Slf4j
public class HashUtil {
	
	public static String calcularHash(byte[] dados) {
		return Optional.ofNullable(dados)
				.map(DigestUtils::md5Hex).orElse(null);
	}
	
	public static Optional<String> calcularHashCustomizado(byte[] dados) {
		
		if (dados == null) {
			return Optional.empty();
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] hashBytes = md.digest(dados);
			
			StringBuilder hexString = new StringBuilder();
			for (byte hashByte : hashBytes) {
				String hex = Integer.toHexString(0xff & hashByte);
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return Optional.of(hexString.toString());
			
		} catch (Exception e) {
			log.error("Falha ao obter o hash", e);
			return Optional.empty();
		}
		
	}

}
