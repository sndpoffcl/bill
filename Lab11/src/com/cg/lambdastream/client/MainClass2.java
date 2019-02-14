package com.cg.lambdastream.client;

import com.cg.lambdastream.eis.FormatString;

public class MainClass2 {

	public static void main(String[] args) {
		FormatString format = (str)->{
			String str1="";
			for(int i=0;i<str.length();i++) {
				str1 += str.charAt(i)+" ";
			}
				return str1;
		};
		System.out.println(format.formatString("Tirtharaj"));
	}

}
