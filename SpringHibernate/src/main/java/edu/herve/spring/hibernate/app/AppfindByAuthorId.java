package edu.herve.spring.hibernate.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;



import edu.herve.spring.hibernate.dao.PublishingDao;
import edu.herve.spring.hibernate.domain.Author;
import edu.herve.spring.hibernate.domain.Book;

public class AppfindByAuthorId {
	public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingDao PublishingDao = ctx.getBean("publishingDao", PublishingDao.class);
        List<Book> book = PublishingDao.findByAuthorId(3);
        listBooksWithDetail(book);
        
              
	}
	
	private static void listBooksWithDetail(List<Book> books) {
		System.out.println("**********************************************");
		System.out.println("Book, cathegory and authors with Author id 3 :");
		for (Book book: books) {
		    System.out.println(book);
		    if (book.getCategory() != null) {
		       
			   System.out.println(book.getCategory());
		    }
		    if (book.getAuthors() != null) {
		        for (Author author: book.getAuthors()) {
		           System.out.println(author);
		        }
	             }
	             System.out.println("---------------------------------------");
	        }
	 }
	
	
}
