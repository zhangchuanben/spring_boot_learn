package com.spbl.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spbl.domain.Book;
import com.spbl.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
	public Book getByIsbn(@PathVariable String isbn) {
		return bookRepository.findByIsbn(isbn);
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String getSessionId(HttpServletRequest request) {
		return request.getSession().getId();
	}
}
