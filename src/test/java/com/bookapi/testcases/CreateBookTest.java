package com.bookapi.testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.bookapi.logs.WrappedAssert;
import com.bookapi.logs.WrappedReportLogger;
import com.bookapi.pojo.request.CreateBook;
import com.bookapi.pojo.response.GetBook;
import com.bookapi.specBuilder.ApiClient;
import com.bookapi.specBuilder.RequestBuilder;
import com.bookapi.test.constants.EndPoints;
import com.bookapi.test.utils.DataGenerator;

public class CreateBookTest {
	public static int newBookId;
	public static int newPublishedYear;
	
	@Test(priority = 9, description = "Validating if user able to create a book")
	public void validatingUserAbleToCreateNewBook() {
		WrappedReportLogger.trace("Validating if user able to create a book...");
		newBookId=DataGenerator.randomID();
		newPublishedYear= DataGenerator.randomYear();
		
		CreateBook createBook = new CreateBook();
		createBook.setId(newBookId);
		createBook.setName("a song of ice and fire "+newBookId);
		createBook.setAuthor("R R Martin");
		createBook.setBook_summary("Medieval Fiction about a continent of Westeros.");
		createBook.setPublished_year(newPublishedYear);
		
		GetBook getBook=ApiClient.post(RequestBuilder.withBodyAndAuthToken(createBook, LoginForAccessTokenTest.access_token, null, null), EndPoints.CREATE_BOOK, 200,
				"GetBook.json").as(GetBook.class);
		
		WrappedReportLogger.trace("new book has been creation!!!");
		
		WrappedReportLogger.debug("Request:"+createBook);
		WrappedReportLogger.debug("Response:"+getBook);

	}
	
	@Test(priority = 10, description = "Validating if newly created book is displayed in the list of all the books", dependsOnMethods = "validatingUserAbleToCreateNewBook")
	public void validatingNewBookIsDisplayedInList() {
		WrappedReportLogger.trace("Validating if newly created book with "+newBookId+"is displayed in the list of all the books...");

		Boolean bolNewBook = false;
		GetBook[] books = ApiClient.get(RequestBuilder.withAuthToken(LoginForAccessTokenTest.access_token,null, null),
				EndPoints.GET_ALL_BOOKS, 200, "GetAllBooks.json").as(GetBook[].class);

		List<GetBook> bookList = Arrays.asList(books);

		for (GetBook book : bookList) {

			if (book.getId() == newBookId && book.getName().equals("a song of ice and fire " + newBookId)) {
				bolNewBook = true;
			}
		}

		WrappedAssert.assertTrue(bolNewBook, "Checking for presence of the newly added book");
		WrappedReportLogger.trace("Validated newly created book is displayed in the list of all the books!!!");


	}
	
	

}
