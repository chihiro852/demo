package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MathController {
	@GetMapping( "/math" )
	public String math() {
		return "math.html";
	}

	@PostMapping( value="/form", params="plus" )	
	public String plus( @RequestParam( "str1" ) String str1, @RequestParam( "str2" ) String str2, Model model ) {
		// 桁数指定
		if ( str1.length() > 9 || str2.length() > 9 ) {
			model.addAttribute( "result", "計算結果が10桁を超える計算はできません" );
			return "result.html";
		} else {
			char bufA[] = str1.toCharArray();
			char bufB[] = str2.toCharArray();

			try {
				// 数字判定
				if ( checkNumber( bufA ) == true && checkNumber( bufB ) == true ) {

					// 半角数字に変換
					String num1 = toHalfWidth( str1 );
					String num2 = toHalfWidth( str2 );

					// 整数か小数判定
					if ( checkInt( num1 ) == true && checkInt( num2 ) == true ) {
						int math = Integer.parseInt( num1 ) + Integer.parseInt( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					} else if ( checkInt( num1 ) == true && checkInt( num2 ) == false ) {
						double math = Integer.parseInt( num2 ) + Double.parseDouble( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					} else if ( checkInt( num1 ) == false && checkInt( num2 ) == true ) {
						double math = Double.parseDouble( num1 ) + Integer.parseInt( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					} else {
						double math = Double.parseDouble( num1 ) + Double.parseDouble( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					}
				} else {
					model.addAttribute( "result", "数字を入力して下さい。" );
					return "result.html";
				}
			} catch( NumberFormatException e ) {
				model.addAttribute( "result", "数字を入力して下さい。" );
				return "result.html";
			}
		}
	}
	
	@PostMapping( value="/form", params="minus" )	
	public String minus( @RequestParam( "str1" ) String str1, @RequestParam( "str2" ) String str2, Model model ) {
		// 桁数指定
		if ( str1.length() > 9 || str2.length() > 9 ) {
			model.addAttribute( "result", "計算結果が10桁を超える計算はできません" );
			return "result.html";
		} else {
			char bufA[] = str1.toCharArray();
			char bufB[] = str2.toCharArray();

			try {
				// 数字判定
				if ( checkNumber( bufA ) == true && checkNumber( bufB ) == true ) {

					// 半角数字に変換
					String num1 = toHalfWidth( str1 );
					String num2 = toHalfWidth( str2 );

					// 整数か小数判定
					if ( checkInt( num1 ) == true && checkInt( num2 ) == true ) {
						int math = Integer.parseInt( num1 ) - Integer.parseInt( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					} else if ( checkInt( num1 ) == true && checkInt( num2 ) == false ) {
						double math = Integer.parseInt( num2 ) - Double.parseDouble( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					} else if ( checkInt( num1 ) == false && checkInt( num2 ) == true ) {
						double math = Double.parseDouble( num1 ) - Integer.parseInt( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					} else {
						double math = Double.parseDouble( num1 ) - Double.parseDouble( num2 );
						model.addAttribute( "result", math );
						return "result.html";
					}
				} else {
					model.addAttribute( "result", "数字を入力して下さい。" );
					return "result.html";
				}
			} catch( NumberFormatException e ) {
				model.addAttribute( "result", "数字を入力して下さい。" );
				return "result.html";
			}
		}
	}

	// 数字判定
	public static boolean checkNumber(char char1[]) {
		for (char ch : char1 ) {
            if ( Character.isDigit( ch )) {
                return true;
            } else {
                return false;
            }
		}
		return false;
	}

	// 全角→半角変換
	public String toHalfWidth( String s ) {
		StringBuilder sb = new StringBuilder( s );

		for ( int i = 0; i < s.length(); i++ ) {
			char c = s.charAt( i );
			if ( 0xFF10 <= c && c <= 0xFF19 ) {
				sb.setCharAt( i, ( char ) ( c - 0xFEE0 ));
			}
		}
		return sb.toString();
	}

	// 整数小数判定
	public static boolean checkInt( String s ) {
	    try {
	    	Integer.parseInt( s );
	    	return true;
	    } catch ( NumberFormatException e ) {
	    	return false;
	    }
	}
}