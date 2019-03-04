package edu.herve.spring.hibernate.dao;

import edu.herve.spring.hibernate.domain.*; 
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;
import java.util.List;


/**
 * Implementing all the methods in the PublishingDao class.
 */
@Transactional 
@Repository("publishingDao") //Declares this class as Spring bean. Used in main()
@SuppressWarnings("restriction")
public class PublishingDaoImpl implements PublishingDao{
	
	private static final Log LOG = LogFactory.getLog(PublishingDaoImpl.class);

    //Injected by using the @Resource annotation in setSessionFactory(...)
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<Book> findAll() {
    	return sessionFactory.getCurrentSession().createQuery("from Book b").list();
	}

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public List<Book> findAllWithDetail() {
        return sessionFactory.getCurrentSession().
            getNamedQuery("Book.findAllWithDetail").list();
    }
	
    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public Book findById(int id) {
    	return (Book) sessionFactory.getCurrentSession().
                getNamedQuery("Book.findById").
                setParameter("id", id).uniqueResult();
	}

	public Book save(Book book) {
        sessionFactory.getCurrentSession().saveOrUpdate(book);
        System.out.println("Book saved with id: " + book.getId());
        return book;
	}

	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		System.out.println("Book deleted with id: " + book.getId());
	}
	
	@SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
	public List<Book> findByAuthorId(int id) {
		return (List<Book>) sessionFactory.getCurrentSession().
                getNamedQuery("Book.findByAuthorId").
                setParameter("id", id).list();
	}
	
	 public SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	  @Resource(name="sessionFactory")
	  public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	  }

	

}
