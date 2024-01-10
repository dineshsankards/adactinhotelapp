package com.POJO;

public class PojoA { 				// Plain Old Java Object.

	// encapsulation == capsule the code and data in one form.
	// Access the method even the method was in private.

	private int n = 100;            // security - going to access the private method using getters and setters.

	public int getNumber() {        // getters - get the above number.
		return n;
	}

	public void setNumber(int n) { 	// setters - set the number in the same ref.name('n').
		this.n = n;			 		// current class reference - this.n indicates(see the 'n' in the above method).
	}

	public static void main(String[] args) {
		PojoA m = new PojoA();
		int number = m.getNumber();
		System.out.println(number);
		m.setNumber(57454);
		System.out.println(m.getNumber());
	}

	// without main method. we can access this method by creating a new class.
}
