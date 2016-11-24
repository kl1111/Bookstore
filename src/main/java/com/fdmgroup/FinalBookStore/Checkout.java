package com.fdmgroup.FinalBookStore;

public class Checkout {

	public double calculatePrice(Basket basket) {
		double result = 0.0;
		Book[] books = basket.getBooksInBasket();
		for (Book book : books) {
			result += book.getPrice();
		}

		if (books.length == 10) {
			result *= 0.87;
		} else if (books.length == 7) {
			result *= 0.98;
		} else if (books.length == 3) {
			result *= 0.99;
		}
		return result;
	}

}
