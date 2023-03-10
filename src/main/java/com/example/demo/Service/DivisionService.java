package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class DivisionService {
	public String dvsParam(String str1, String str2) {
		int result;

		try {

			// 割り算の割る数が0だとエラーになるため、0で割ったときの処理を書いておく
			if (Integer.valueOf(str2) == 0) {
				return String.valueOf(0);
			}

			result = Integer.valueOf(str1) / Integer.valueOf(str2);
		} catch (Exception e) {
			throw e;
		}

		return String.valueOf(result);
	}
}