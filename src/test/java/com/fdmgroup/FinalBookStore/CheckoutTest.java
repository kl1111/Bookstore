package com.fdmgroup.FinalBookStore;

import static org.junit.Assert.*;

import org.junit.*;

public class CheckoutTest {

	private static final double BASIC_BOOK_PRICE = 9.99; 
	private static final double DOUBLE_DELTA = 0.000001; 

	private Checkout checkout;
	private Basket basket;

	private void addBooksToBasket(int numberOfBooksToAdd) {
		for (int index = 0; index < numberOfBooksToAdd; index++) {
			basket.addBook(new Book(BASIC_BOOK_PRICE));
		}
	}
	
	@Before
	public void before() {
		checkout = new Checkout();
		basket = new Basket();
	}
	
	@Test
	public void test_CalculatePrice_ReturnsDoubleZeroPointZero_WhenPassedAnEmptyBasket() {
		// ARRANGE
		// ACT
		double actual = checkout.calculatePrice(new Basket());
		// ASSERT
		assertEquals(0.0, actual, DOUBLE_DELTA);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook(){
		// ARRANGE
		addBooksToBasket(1);
		// ACT
		double actual = checkout.calculatePrice(basket);
		// ASSERT
		assertEquals(BASIC_BOOK_PRICE, actual, DOUBLE_DELTA);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsSumOfPriceOfBooksInBasket_WhenPassedBasketWithTwoBooks(){
		// ARRANGE
		addBooksToBasket(2);
		// ACT
		double actual = checkout.calculatePrice(basket);
		// ASSERT
		assertEquals(BASIC_BOOK_PRICE * 2, actual, DOUBLE_DELTA);
	}

	@Test
	public void test_CalculatePrice_ReturnsOnePercentDiscount_WhenPassedBasketWithThreeBooks(){
		// ARRANGE
		addBooksToBasket(3);
		// ACT
		double actual = checkout.calculatePrice(basket);
		// ASSERT
		assertEquals((BASIC_BOOK_PRICE * 3) * 0.99, actual, DOUBLE_DELTA);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsTwoPercentDiscount_WhenPassedBasketWithSevenBooks(){
		// ARRANGE
		addBooksToBasket(7);
		// ACT
		double actual = checkout.calculatePrice(basket);
		// ASSERT
		assertEquals((BASIC_BOOK_PRICE * 7) * 0.98, actual, DOUBLE_DELTA);
	}
	
//	Test 6
//	If the calculate price method of checkout is called with 10 books, it should return the sum of the price of those books, minus a 13% discount. 
//  10% for having ten books, 3% for having three multiples of 3 books
	@Test
	public void test_CalculatePrice_Returns13PercentDiscount_WhenPassedBasketTenBooks(){
		// ARRANGE
		addBooksToBasket(10);
		// ACT
		double actual = checkout.calculatePrice(basket);
		// ASSERT
		assertEquals((BASIC_BOOK_PRICE * 10) * 0.87, actual, DOUBLE_DELTA);
	}
	
	


}
