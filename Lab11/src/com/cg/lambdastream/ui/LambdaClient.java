package com.cg.lambdastream.ui;

import javax.print.attribute.standard.RequestingUserName;

import com.cg.lambdastream.finterfaces.FIAuthintication;
import com.cg.lambdastream.finterfaces.FIPower;
import com.cg.lambdastream.finterfaces.FISpacing;

public class LambdaClient {
	public static void main(String[] args) {
		
		FIPower powerObj = (a,b)->(int)Math.pow(a,b);
		
		FISpacing spacingObj=(str)->{
			String ans="";
			for(int i=0; i<str.length(); i++)
				ans=ans+str.charAt(i)+" ";
			return ans;
		};
		
		FIAuthintication authinticationObj=(usr,pwd)->{
			if((usr.equals("Virat") && pwd.equals("Password@123")))
					return true; 
			else 
				return false;
			};
		
		System.out.println(powerObj.power(10, 2));
		System.out.println(spacingObj.spacing("CAP"));
		System.out.println(authinticationObj.authenticateUser("Virat", "Password@123"));
	}
}