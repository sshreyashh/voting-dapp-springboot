package com.example.voting.repository;

import com.example.voting.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterDAO extends JpaRepository<Voter,Long> {
    Optional<Voter> findByVoterId(String voterId);
}
