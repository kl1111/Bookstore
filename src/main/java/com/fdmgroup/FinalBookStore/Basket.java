package com.fdmgroup.FinalBookStore;

import java.util.ArrayList;

public class Basket {
	
	//make a new ArrayList called books
	private ArrayList<Book> books = new ArrayList<Book>();
	
	public Book[] getBooksInBasket() {
		Book[] arr = new Book[books.size()];
		return books.toArray(arr);
	}

	public void addBook(Book book) {
		books.add(book);
	}



}
