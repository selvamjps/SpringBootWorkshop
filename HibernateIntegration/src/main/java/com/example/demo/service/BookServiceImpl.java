package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

interface BookService {
	public List<Book> getBooks();
	public Long addBook(Book book);
}

@Repository
public class BookServiceImpl implements BookService {

	@Autowired
	private EntityManagerFactory factory;
	
	@Override
	public List<Book> getBooks() {
		
		Session session = factory.unwrap(SessionFactory.class).openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		
		Root<Book> root = query.from(Book.class);
		
		return session.createQuery(query).getResultList();
	}

	@Override
	public Long addBook(Book book) {
		
		Session session = factory.unwrap(SessionFactory.class).openSession();
		
		Long returnKey = (Long)session.save(book);
		
		session.beginTransaction().commit();
		
		return returnKey;
	}

}
