package chapter1;

import java.util.Iterator;

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
	
	public int getFrequentPoints() {
		return ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) ? 2 : 1;
	}

	public double getAmountOf() {
		return _movie.getAmountOf(_daysRented);
	}
}
