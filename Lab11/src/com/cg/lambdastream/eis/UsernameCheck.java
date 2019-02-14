package com.cg.lambdastream.eis;
@FunctionalInterface
public interface UsernameCheck {
	public boolean check(String username,String password);

}
