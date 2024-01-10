package com.testNG;

import org.testng.annotations.Test;

public class ExpectedTest {

	@Test(expectedExceptions = Exception.class)
	private void demo() {
		int a = 15;
		System.out.println(a/0);
	}

}
