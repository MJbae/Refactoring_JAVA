package chapter1;

public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double getAmountOf() {
		double resultOfAmount = 0;

		// determine amounts for each line
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			resultOfAmount += 2;
			if (getDaysRented() > 2)
				resultOfAmount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			resultOfAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			resultOfAmount += 1.5;
			if (getDaysRented() > 3)
				resultOfAmount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return resultOfAmount;
	}
}
