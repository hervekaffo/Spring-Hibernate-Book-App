package edu.herve.spring.hibernate.dao;

import java.util.List;

import edu.herve.spring.hibernate.domain.*;

public interface PublishingDao {
	
	List<Book> findAll();
    List<Book> findAllWithDetail();
    Book findById(int id);
    Book save(Book book);
    void delete(Book book);
    List<Book> findByAuthorId(int id);
}
