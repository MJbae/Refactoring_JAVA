package chapter1;

abstract class Price {
	abstract int getPriceCode();
	abstract double getAmountOf(int daysRented);
	
	int getFrequentPoints(int daysRented) {
		return 1;
	}
}

class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	double getAmountOf(int daysRented) {
		return daysRented * 3;
	}
	
	int getFrequentPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}

class ChildrensPrice extends Price {
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	double getAmountOf(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
		return result;
	}
}

class RegularPrice extends Price {
	int getPriceCode() {
		return Movie.REGULAR;
	}

	double getAmountOf(int daysRented) {
		return (daysRented > 2) 
				? (2 + (daysRented - 2) * 1.5) 
				: 2;
	}
}
