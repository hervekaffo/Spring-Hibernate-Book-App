package edu.herve.spring.hibernate.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "author")

public class Author implements Serializable{
	
	private int id;
	private String firstName;
	private String lastName;
	private String description;
	private Set<Book> books = new HashSet<Book>();
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	//joinColumns and inverseJoinColumns attributes are reversed with respect to
    //the mapping in Contact bean..
    @ManyToMany
    @JoinTable(name = "author_book", 
        joinColumns = @JoinColumn(name = "AUTHOR_ID"), 
        inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + "]";
	}
	
	
	
	

}
