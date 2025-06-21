package com.example.voting.repository;

import com.example.voting.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateDAO extends JpaRepository<Candidate,Long> {
    Optional<Candidate> findByName(String name);
}
