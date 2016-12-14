package ee.library.db;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookJDBCTemplate implements BookDAO {
   @SuppressWarnings("unused")
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(String title, String author, String year, String ISBN) {
      String SQL = "insert into Book (title, author, year, ISBN) values (?, ?, ?, ?)";
      
      jdbcTemplateObject.update( SQL, title, author, year, ISBN);
      System.out.println("Created Record Title = " + title + " Author = " + author); // TBD: kõik väljad?
      return;
   }

   public Book getBook(Integer id) {
      String SQL = "select * from Book where id = ?";
      Book book = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new BookMapper());
      return book;
   }

   public List<Book> listBooks() {
      String SQL = "select * from Book";
      List <Book> books = jdbcTemplateObject.query(SQL, 
                                new BookMapper());
      return books;
   }

   public void delete(Integer id){
      String SQL = "delete from Book where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, Integer age){
      String SQL = "update Book set age = ? where id = ?";
      jdbcTemplateObject.update(SQL, age, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

}