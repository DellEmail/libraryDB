package ee.library.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBook() {
		Book book = new Book();
		book.setTitle("test");
		book.setAuthor("test");
		book.setISBN("ISBN");
		book.setYear("2016");

		assertEquals("test", book.getTitle());
		assertEquals(4, book.getTitle().length() );

		assertEquals("test", book.getAuthor());
		assertEquals(4, book.getAuthor().length() );

		assertEquals("ISBN", book.getISBN());
		assertEquals(4, book.getISBN().length() );

		assertEquals("2016", book.getYear());
		assertEquals(4, book.getYear().length() );
	}

}
