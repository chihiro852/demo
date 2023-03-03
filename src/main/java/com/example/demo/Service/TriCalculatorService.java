package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class TriCalculatorService {
	public String calculator(String symbol1, String symbol2, String str1, String str2, String str3) {
		int result = 0;
		try {
			int num1 = Integer.parseInt(str1);
			int num2 = Integer.parseInt(str2);
			int num3 = Integer.parseInt(str3);

			if (symbol1.equals("add")) {
				if (symbol2.equals("add")) {
					result = num1 + num2 + num3;
				} else if (symbol2.equals("sbt")) {
					result = num1 + num2 - num3;
				} else if (symbol2.equals("mlt")) {
					result = num1 + num2 * num3;
				} else if (symbol2.equals("dvs")) {
					result = num1 + num2 / num3;
				}
			} else if (symbol1.equals("sbt")) {
				if (symbol2.equals("add")) {
					result = num1 - num2 + num3;
				} else if (symbol2.equals("sbt")) {
					result = num1 - num2 - num3;
				} else if (symbol2.equals("mlt")) {
					result = num1 - num2 * num3;
				} else if (symbol2.equals("dvs")) {
					result = num1 - num2 / num3;
				}
			} else if (symbol1.equals("mlt")) {
				if (symbol2.equals("add")) {
					result = num1 * num2 + num3;
				} else if (symbol2.equals("sbt")) {
					result = num1 * num2 - num3;
				} else if (symbol2.equals("mlt")) {
					result = num1 * num2 * num3;
				} else if (symbol2.equals("dvs")) {
					result = num1 * num2 / num3;
				}
			} else if (symbol1.equals("dvs")) {
				if (symbol2.equals("add")) {
					result = num1 / num2 + num3;
				} else if (symbol2.equals("sbt")) {
					result = num1 / num2 - num3;
				} else if (symbol2.equals("mlt")) {
					result = num1 / num2 * num3;
				} else if (symbol1.equals("dvs")) {
					result = num1 / num2 / num3;
				}
			}
			return String.valueOf(result);
		} catch (NumberFormatException e) {
			return "正しく入力して下さい";
		}
	}
}