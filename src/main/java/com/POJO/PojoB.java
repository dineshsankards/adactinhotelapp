package com.POJO;

public class PojoB {

	public static void main(String[] args) {
		PojoA abc = new PojoA();        //Object allocation (Because method is non-static)
		int number = abc.getNumber();   //
		System.out.println(number);
		
		abc.setNumber(4857);
		System.out.println(abc.getNumber());
	}
}
