package com.spbl.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spbl.domain.Reviewer;

@Repository
public interface ReviewerRepository extends PagingAndSortingRepository<Reviewer, Long>{

}
