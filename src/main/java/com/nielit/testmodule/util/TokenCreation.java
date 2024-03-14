package com.nielit.testmodule.util;

import java.nio.charset.Charset;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TokenCreation {

	public String createCSRFToken() {

		int leftLimit = 97; 
		int rightLimit = 122;
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}
}
