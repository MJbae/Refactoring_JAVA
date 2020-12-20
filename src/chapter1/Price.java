package chapter1;

abstract class Price {
	abstract int getPriceCode();
}

class NewReleasePrice extends Price {
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
}

class ChildrensPrice extends Price {
	int getPriceCode() {
		return Movie.CHILDRENS;
	}
}

class RegularPrice extends Price {
	int getPriceCode() {
		return Movie.REGULAR;
	}
}
