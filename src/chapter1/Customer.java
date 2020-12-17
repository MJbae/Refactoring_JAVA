package chapter1;

import java.util.Vector;

public class Customer {
	private String _name;
	// TODO: Vector 클래스란?
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	};

}
