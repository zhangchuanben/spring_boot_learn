package com.spbl.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spbl.domain.Author;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>{

}
