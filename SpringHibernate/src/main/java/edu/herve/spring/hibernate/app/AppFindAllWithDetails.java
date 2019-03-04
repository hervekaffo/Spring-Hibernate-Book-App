package edu.herve.spring.hibernate.app;

import java.util.List;
import java.util.Date;
import java.util.Set;

import javax.persistence.NamedQuery;

import org.springframework.context.support.GenericXmlApplicationContext;


import edu.herve.spring.hibernate.dao.PublishingDao;
import edu.herve.spring.hibernate.domain.Author;
import edu.herve.spring.hibernate.domain.Book;

public class AppFindAllWithDetails {

	public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingDao PublishingDao = ctx.getBean("publishingDao", PublishingDao.class);
        List<Book> books = PublishingDao.findAllWithDetail();
        
        listBooksWithDetail(books);       
    }
	
	private static void listBooksWithDetail(List<Book> books) {
		System.out.println("**********************************************");
		System.out.println("Listing books with details:");
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
