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

	@PostMapping( value="/form" )	
	public String math( @RequestParam( "str1" ) String str1, @RequestParam( "str2" ) String str2, Model model ) {		
		char bufA[] = str1.toCharArray();
		char bufB[] = str2.toCharArray();
		
		// 数字判定
		try {
			if ( checkNumber( bufA ) == true && checkNumber( bufB ) == true ) {
	
				String num1 = toHalfWidth( str1 );
				String num2 = toHalfWidth( str2 );

				if ( checkInt( num1 ) == true && checkInt( num2 ) == true ) {
					int math = Integer.parseInt( num1 ) + Integer.parseInt( num2 );
					model.addAttribute( "result", math );
					return "result.html";
				} else if ( checkInt( num1 ) == true && checkInt( num2 ) == false ) {
					double math = Integer.parseInt( num2 ) + Double.parseDouble( num2 );
					model.addAttribute( "result", math );
					return "result.html";
				} else if ( checkInt( num1 ) == false && checkInt( num2 ) == false ) {
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

	public static boolean checkInt( String s ) {
	    try {
	    	Integer.parseInt( s );
	    	return true;
	    } catch ( NumberFormatException e ) {
	    	return false;
	    }
	}
}