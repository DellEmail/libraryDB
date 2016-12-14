package ee.library.db;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ee.library.db.BookJDBCTemplate;

public class MainApp {
   public static void main(String[] args) {
      @SuppressWarnings("resource")
	  ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");

      BookJDBCTemplate bookJDBCTemplate = 
      (BookJDBCTemplate)context.getBean("bookJDBCTemplate");
      
      //System.out.println("------Records Creation--------" );
      //bookJDBCTemplate.create("Title1", "Author1", "Year1", "ISBN1");

      System.out.println("------Listing Multiple Records--------" );
      List<Book> books = bookJDBCTemplate.listBooks();
      for (Book record : books) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Title : " + record.getTitle() );
         System.out.println(", ISBN : " + record.getISBN());
      }

      //System.out.println("----Updating Record with ID = 2 -----" );
      //bookJDBCTemplate.update(2, 20);

      //System.out.println("----Listing Record with ID = 2 -----" );
      //Book book = bookJDBCTemplate.getBook(2);
      //System.out.print("ID : " + book.getId() );
      //System.out.print(", Title : " + book.getTitle() );
      //System.out.println(", ISBN : " + book.getISBN());
	  
   }
}