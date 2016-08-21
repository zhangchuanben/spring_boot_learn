package com.spbl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spbl.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	Book findByIsbn(String isbn);
}
