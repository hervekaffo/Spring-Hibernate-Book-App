package edu.herve.spring.hibernate.app;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


import edu.herve.spring.hibernate.dao.PublishingDao;
import edu.herve.spring.hibernate.domain.Author;
import edu.herve.spring.hibernate.domain.Book;
import edu.herve.spring.hibernate.domain.Category;

public class AppDeleteExistingBook {
	
	public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingDao PublishingDao = ctx.getBean("publishingDao", PublishingDao.class);
        Book book = PublishingDao.findById(7);
        PublishingDao.delete(book);
        List<Book> books = PublishingDao.findAllWithDetail();
        listBooksWithDetail(books);
        
        
	}
	
	private static void listBooksWithDetail(List<Book> books) {
		System.out.println("*********************************************");
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
	             System.out.println("--------------------------------------");
	        }
	 }

}
