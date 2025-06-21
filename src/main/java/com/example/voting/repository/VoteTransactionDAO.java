package com.example.voting.repository;

import com.example.voting.entity.VoteTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteTransactionDAO extends JpaRepository<VoteTransaction,Long> {

}
