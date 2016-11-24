package com.fdmgroup.FinalBookStore;

public class Catalogue {

	private ReadItemCommand readItemCommand;
	private WriteItemCommand writeItemCommand;

	private Book book;

	public Catalogue(ReadItemCommand readItemCommand, WriteItemCommand writeItemCommand) {
		this.readItemCommand = readItemCommand;
		this.writeItemCommand = writeItemCommand;
	}

	public Book[] getAllBooks() {
		return readItemCommand.readAll();
		
	}

	public void addBook(Book book) {
		this.book = book;
		writeItemCommand.insertItem(book);
	}

}
