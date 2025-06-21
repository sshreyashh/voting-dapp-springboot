package com.example.voting.service;


import com.example.voting.entity.Candidate;
import com.example.voting.entity.VoteTransaction;
import com.example.voting.entity.Voter;
import com.example.voting.model.Block;
import com.example.voting.model.Blockchain;
import com.example.voting.repository.VoteTransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VotingManagementService {

    @Autowired
    private VoterService voterService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private VoteTransactionDAO voteTransactionDAO;

    private final Blockchain blockchain = new Blockchain();

    public String vote(String voterId, String candidateName) {
        Voter voter = voterService.findByVoterId(voterId).orElseThrow(() -> new RuntimeException("Voter not found"));
        if(voter.isHasVoted())
            throw new RuntimeException("Voter has already voted");

        Candidate candidate = candidateService.findByName(candidateName).orElseThrow(()-> new RuntimeException("Candidate does not exist"));
        String voteTransaction = "Vote:" +voterId+ " -> "+ candidateName;
        String previousHash = blockchain.getLatestBlock().getHash();
        Block newBlock = new Block(blockchain.getChain().size(), Collections.singletonList(voteTransaction),previousHash);
        blockchain.addBlock(newBlock);

        VoteTransaction vote = VoteTransaction.builder().voterId(voterId).candidateName(candidateName).hash(newBlock.getHash()).build();
        voteTransactionDAO.save(vote);

        voter.setHasVoted(true);
        candidate.setVoteCount(candidate.getVoteCount()+1);
        candidateService.update(candidate);
        voterService.update(voter);

        return "Vote has been recorded successfully";
    }

    public List<Block> getBlockchain() {
        return blockchain.getChain();
    }


}

