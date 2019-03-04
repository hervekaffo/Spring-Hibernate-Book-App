package edu.herve.spring.hibernate.app;

import java.util.List;
import java.util.Date;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import edu.herve.spring.hibernate.domain.*;
import edu.herve.spring.hibernate.dao.*;


public class AppFindAll {
	
	 public static void main(String[] args) {
	        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
	        ctx.refresh();

	        PublishingDao publishingDao = ctx.getBean("publishingDao", PublishingDao.class);
	        List<Book> books = publishingDao.findAll();
	        listBooks(books);
      
	    }
	 
	 private static void listBooks(List<Book> books) {
	    	System.out.println("**********************************************************************");
	    	System.out.println("Listing books without details:");
	    	for (Book book: books) {
	    		System.out.println(book);
	    		System.out.println("-------------------------------------------------------------------");
	    	}
	 }

}
