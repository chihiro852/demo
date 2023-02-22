package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MathController {		
	String l = "1１";
	String r = "2";
	
	@GetMapping("/math")
	public String param( Model model ) {		
		char bufA[] = l.toCharArray();
		char bufB[] = r.toCharArray();
		
		// 数字判定
		if ( checkNumber( bufA ) == true && checkNumber( bufB ) == true ) {
			System.out.println( "true" );

			System.out.println( l = toHalfWidth( l ) );

			result( model );
//			// 全角か半角か
//			if ( checkWidth( l ) == true && checkWidth( r ) == true ) {
//				System.out.println( "true" );
//				
//				System.out.println(l);
//				// 小数混入かどうか
//			
//				result( model );
//			} else {
//				toHalfWidth( l );
//			}
		} else {
			errNumber( model );
		}
		return null;
	}

	// 数字判定
	public static boolean checkNumber(char char1[]) {
		for (char ch : char1 ) {
            //数字かどうかを判定
            if ( Character.isDigit( ch )) {
            	// 整数か小数に変更する
                return true;
            } else {
                return false;
            }
		}
		return false;

	}

	// 全角→半角変換
	public String toHalfWidth(String s) {
	  StringBuilder sb = new StringBuilder(s);
	  for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (0xFF10 <= c && c <= 0xFF19) {
	      sb.setCharAt(i, (char) (c - 0xFEE0));
	    }
	  }
	  return sb.toString();
	}
	
	// 成功文
	public String result( Model model ) {
		model.addAttribute( "result", l + r );

		return "math.html";
	}

	// 数字エラー
	public String errNumber( Model model1 ) {
		model1.addAttribute( "result", "数字を入力して下さい。" );

		return "math.html";
	}
}