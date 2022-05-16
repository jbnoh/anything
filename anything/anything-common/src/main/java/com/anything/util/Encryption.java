package com.anything.util;

import java.security.MessageDigest;

public class Encryption {

	private final static String SHA256 = "SHA-256";

	private final static String CHARSET = "UTF-8";

	public static String sha256(String input) throws Exception {

		MessageDigest md = MessageDigest.getInstance(SHA256);
		md.update(input.getBytes(CHARSET));

		return bytesToHex(md.digest());
	}

	private static String bytesToHex(byte[] bytes) {

		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}
}
