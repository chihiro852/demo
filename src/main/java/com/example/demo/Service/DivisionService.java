package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {
	public String dvsParam(String str1, String str2) {
		int num;

		try {
			num = Integer.valueOf(str1) / Integer.valueOf(str2);
		} catch (Exception e) {
			throw e;
		}

		return String.valueOf(num);
	}
}