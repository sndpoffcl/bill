package com.cg.lambdastream.finterfaces;
@FunctionalInterface
public interface FIAuthintication {
	boolean authenticateUser(String user, String pwd);
}