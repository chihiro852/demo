package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MathController {
		
	public static void main(String[] args) {
		String l = "1";
		String r = "2";
		System.out.println(isNumber (l, r));
		
		// 数字判定
		if (isNumber(l, r) == true) {
			// 全角か半角か
			if ( charWidth(l) == true && charWidth(r) == true ) {
				// 小数混入かどうか
				System.out.println(Integer.parseInt(l) + Integer.parseInt(r));
			} else {
				err(null);
			}
		} else {
			err(null);
		}
	}
	
	// 数字判定
	public static boolean isNumber(String num1, String num2) {
		try {
			Double.parseDouble(num1);
			Double.parseDouble(num2);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	// 全角半角判定
	public static boolean charWidth(String num) {
		byte[] bytes = num.getBytes();
		if (num.length() == bytes.length) {
			// 半角
		    return true;
		} else {
		    // 全角混入
		    return false;
		}		
	}

	// エラー文
	public static String err( Model model ) {
		System.out.println("err");
		
		model.addAttribute( "err" , "エラーです。");
		
		return "math.html";
	}
//	@GetMapping("/math")
//    public String math(Model model) {
//		
//		model.addAttribute( "math", "math" );
//
//    	return "math.html";
//    }
	// 値が数字かどうか確認
		// 数字だったら計算して
		// htmlに返す
		// 数字じゃなかったら
		// エラー文を吐き出す
	
	
//    @GetMapping("/math")
//    public String math(Model model) {
//
//    	return "login.html";
//    }
//    
//    @GetMapping("/param")
//    public String param( Model model ) {
//    	
//    	model.addAttribute( "math", "math" );
//    	
//    	return "math.html";
//    }
}