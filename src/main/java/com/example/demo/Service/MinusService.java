package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {
	public String minusParam(String param1, String param2) {
		int rslt;

		try {
			rslt = Integer.parseInt(param1) - Integer.parseInt(param2);
		} catch (Exception e) {
			throw e;
		}

		return String.valueOf(rslt);
	}
}