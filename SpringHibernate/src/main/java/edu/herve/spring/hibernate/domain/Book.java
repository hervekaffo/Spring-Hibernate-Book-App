package edu.herve.spring.hibernate.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "book")
@NamedQueries({
@NamedQuery(name="Book.findById", 
query="select distinct b from Book b left join fetch b.category c left join fetch b.authors a where b.id = :id"),
@NamedQuery(name="Book.findAllWithDetail", 
query="select distinct b from Book b left join fetch b.category c left join fetch b.authors a"),
@NamedQuery(name="Book.findByAuthorId",
query="select distinct b from Book b left join fetch b.category c left join fetch b.authors a where a.id = :id") 
})
public class Book implements Serializable{
	
	private int id;
    private String isbn;
    private String title;
    private double price;
    private Category category;
    private Set<Author> authors = new HashSet<Author>();
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
    @Column(name = "ISBN")
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
    @Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "PRICE")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ManyToMany
    @JoinTable(name = "author_book", 
        joinColumns = @JoinColumn(name = "BOOK_ID"), 
        inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}
    
	
    

}
