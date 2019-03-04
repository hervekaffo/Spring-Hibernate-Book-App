package edu.herve.spring.hibernate.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity //means category is a mapped entity class
@Table(name = "category")
public class Category implements Serializable{
	
	private int id;
    private String name;
    private Set<Book> books = new HashSet<Book>();
    
   

	public Category() {
    	
    }
	public Category(int id) {
    	
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "category", cascade=CascadeType.ALL, 
	        orphanRemoval=true)
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	 public void addBook(Book book) {
	        book.setCategory(this);
	        getBooks().add(book);
	 }
	 
	 public void removeBook(Book book) {
	        getBooks().remove(book);
	 }
	
	@Override
    public String toString() {
        return "Category - Id: " + id + ", Name: " + name;
    }

}
