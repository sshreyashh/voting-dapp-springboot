package com.example.voting.service;

import com.example.voting.entity.Candidate;
import com.example.voting.repository.CandidateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    private CandidateDAO candidateDAO;

    public Candidate registerCandidate(String name, String party) {
        Optional<Candidate> existing = candidateDAO.findByName(name);
        if (existing.isPresent()) {
            throw new RuntimeException("Candidate already registered");
        }
        return candidateDAO.save(Candidate.builder().name(name).party(party).voteCount(0).build());
    }

    public Optional<Candidate> findByName(String name) {
        return candidateDAO.findByName(name);
    }

    public void update(Candidate candidate) {
        candidateDAO.save(candidate);
    }

    public Iterable<Candidate> getAllCandidates() {
        return candidateDAO.findAll();
    }

}
