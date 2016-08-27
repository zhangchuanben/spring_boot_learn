package com.spbl.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spbl.domain.Publisher;

@Repository
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long>{

}
