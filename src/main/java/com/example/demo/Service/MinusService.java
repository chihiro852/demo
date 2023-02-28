package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {
	public String minusParam(String param1, String param2) {
		int result;

		try {
			result = Integer.parseInt(param1) - Integer.parseInt(param2);
		} catch (Exception e) {
			throw e;
		}

		return String.valueOf(result);
	}
}