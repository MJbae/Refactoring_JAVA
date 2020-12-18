package chapter1;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	private String _name;

	// legacy 수정: Vector -> ArrayList
	private ArrayList<Rental> _rentals = new ArrayList<Rental>();

	public Customer(String name) {
		_name = name;
	};

	// legacy 수정: addElement -> add
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public double getAmountOf(Rental rental) {
		double thisAmount = 0;

		// determine amounts for each line
		switch (rental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (rental.getDaysRented() > 2)
				thisAmount += (rental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += rental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (rental.getDaysRented() > 3)
				thisAmount += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		// legacy 수정: Enumeration -> Iterator, elements() -> iterator()
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";

		// legacy 수정: hasMoreElements() -> hasNext(), nextElement() -> next()
		while (rentals.hasNext()) {
			Rental each = (Rental) rentals.next();

			double thisAmount = getAmountOf(each);

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

	public static void main(String[] args) {
		Customer customer1 = new Customer("MJ");

		Movie movie1 = new Movie("hello", Movie.CHILDRENS);
		Movie movie2 = new Movie("hi", Movie.NEW_RELEASE);
		Movie movie3 = new Movie("yo", Movie.REGULAR);

		ArrayList<Rental> rentalsByMJ = new ArrayList<Rental>();
		rentalsByMJ.add(new Rental(movie1, 7));
		rentalsByMJ.add(new Rental(movie2, 6));
		rentalsByMJ.add(new Rental(movie3, 14));
		rentalsByMJ.add(new Rental(movie3, 8));

		for (Rental rental : rentalsByMJ)
			customer1.addRental(rental);

		System.out.println(customer1.statement());
	}

}
