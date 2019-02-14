package com.cg.lambdastream.client;

import java.util.Scanner;

import com.cg.lambdastream.eis.UsernameCheck;

public class MainClass3 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Set the Username: ");
		String username = sc.next();
		System.out.println("Set the Password: ");
		String password = sc.next();
		UsernameCheck check = (username1,password1)->{
			System.out.println("Enter the Username to check:");
			String str1 = sc.next();
			System.out.println("Enter the Password to check: ");
			String str2 = sc.next();
			if(str1.equals(username1) && str2.equals(password1))
				return true;
			else
				return false;
						
		};
		System.out.println(check.check(username, password));

	}

}
