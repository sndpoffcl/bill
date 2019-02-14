package com.cg.lambdastream.client;

import java.util.Scanner;

import com.cg.lambdastream.eis.Factorial;

public class MainClass5 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the Number:");
		int number = sc.nextInt();
		Factorial factorial =(num)->{
			long fact=1;
			for(int i=num;i>1;i--)
				fact = fact*i;
			return fact;
		};
		System.out.println("the factorial of "+number+" is "+factorial.fact(number));
	}
}
