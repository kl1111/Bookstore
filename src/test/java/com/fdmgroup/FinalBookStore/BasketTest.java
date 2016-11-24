package com.fdmgroup.FinalBookStore;

import static org.junit.Assert.*;

import org.junit.*;

public class BasketTest {

	private Basket basket;
	private Book zeroPriceBook;
	
	@Before
	public void before() {
		basket = new Basket();
		zeroPriceBook = new Book(0.0);
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded() {
		// ARRANGE
		// ACT
		Book[] books = basket.getBooksInBasket();
		// ASSERT
		assertEquals(0, books.length);
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
		// ARRANGE
		basket.addBook(zeroPriceBook);
		// ACT
		Book[] books = basket.getBooksInBasket();
		// ASSERT
		assertEquals(1, books.length);
	}
	
	@Test
	@Ignore
	public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledTwice() {
		// ARRANGE
		basket.addBook(zeroPriceBook);
		basket.addBook(zeroPriceBook);
			// ACT
		Book[] books = basket.getBooksInBasket();
		// ASSERT
		assertEquals(2, books.length);
	}	

}
