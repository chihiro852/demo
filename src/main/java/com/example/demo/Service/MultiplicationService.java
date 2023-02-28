package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {
	public String mltParam(String str1, String str2) {
		int result;

		try {
			result = Integer.parseInt(str1) * Integer.parseInt(str2);
		} catch (Exception e) {
			throw e;
		}

		return String.valueOf(result);
	}
}