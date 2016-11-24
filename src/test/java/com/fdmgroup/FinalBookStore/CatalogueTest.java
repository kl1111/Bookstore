package com.fdmgroup.FinalBookStore;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

public class CatalogueTest {

	private ReadItemCommand readItemCommand;
	private WriteItemCommand writeItemCommand;
	private Catalogue catalogue;
	
	@Before
	public void before() {
		readItemCommand = mock(ReadItemCommand.class);
		writeItemCommand = mock(WriteItemCommand.class);
		catalogue = new Catalogue(readItemCommand, writeItemCommand);
	}
	
	@Test
	public void test_GetAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue() {
		//Arrange
		when(readItemCommand.readAll()).thenReturn(new Book[0]);
		//Act
		Book[] actual = catalogue.getAllBooks();
		//Assert
		assertEquals(0, actual.length);
	}

	@Test
	public void test_GetAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() {
		//Arrange
		//Act
		catalogue.getAllBooks();
		//Assert (verify that readItemCommand.readAll was called exactly once)
		verify(readItemCommand, times(1)).readAll();
	}	

	@Test
	public void test_GetAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() {
		//Arrange
		Book book = new Book(0.0);
		Book[] books = new Book[] { book };
		when(readItemCommand.readAll()).thenReturn(books);
		//Act
		Book[] actual = catalogue.getAllBooks();
		//Assert
		assertSame(books, actual);
		assertSame(books[0], book); // <-- not everyone's cup of tea!
	}

	@Test
	public void test_AddBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
		//Arrange
		Book book = new Book(0.0);
		//Act
		catalogue.addBook(book);
		//Assert //Verify that the insertItem method was called only once from the writeItemCommand object.
		verify(writeItemCommand, times(1)).insertItem(book);
	}
	
}
