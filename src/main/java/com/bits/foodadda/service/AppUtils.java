package com.bits.foodadda.service;

import org.apache.commons.codec.digest.DigestUtils;

public class AppUtils {

	public String encryptPassword(String password) {
		String newPassword = DigestUtils.sha256Hex(password);
		return newPassword;
	}
	
}
