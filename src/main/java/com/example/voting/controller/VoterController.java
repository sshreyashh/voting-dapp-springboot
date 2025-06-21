package com.example.voting.controller;

import com.example.voting.entity.Voter;
import com.example.voting.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voters")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping("/register")
    public ResponseEntity<Voter> registerVoter (@RequestBody Voter voter){
        return new ResponseEntity<Voter>(voterService.registerVoter(voter.getName(), voter.getVoterId()), HttpStatus.CREATED);
    }

}
