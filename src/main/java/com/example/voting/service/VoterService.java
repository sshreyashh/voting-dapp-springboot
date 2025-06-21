package com.example.voting.service;

import com.example.voting.entity.Voter;
import com.example.voting.repository.VoterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterService {

    @Autowired
    private VoterDAO voterDAO;

    public Voter registerVoter(String name, String voterId) {
        Optional<Voter> existing = voterDAO.findByVoterId(voterId);
        if (existing.isPresent()) {
            throw new RuntimeException("Voter already registered");
        }
        return voterDAO.save(Voter.builder().name(name).voterId(voterId).hasVoted(false).build());
    }

    public Optional<Voter> findByVoterId(String voterId){
        return  voterDAO.findByVoterId(voterId);
    }

    public Voter update(Voter voter){
        return voterDAO.save(voter);
    }
}
