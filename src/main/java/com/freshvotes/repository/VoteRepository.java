package com.freshvotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshvotes.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

}
