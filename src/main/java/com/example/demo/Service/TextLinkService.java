package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class TextLinkService {
	public String doLink(String str1, String str2) {
		String result = str1 + str2;

		return result;
	}
}