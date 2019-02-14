package com.cg.lambdastream.client;

import java.util.Scanner;

import com.cg.lambdastream.eis.PowerFunction;


public class MainClass1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		PowerFunction func =(x,y)->{
			double z=0;
			z = Math.pow(x, y);
			return z;
		};
		System.out.println("'Enter the value of x:");
		double x = sc.nextDouble();
		System.out.println("Enter the value of y:");
		double y =sc.nextDouble();
		System.out.println("The Result:  "+func.power(x, y));

	}

}
