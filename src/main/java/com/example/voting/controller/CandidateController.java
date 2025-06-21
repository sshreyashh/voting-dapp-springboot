package com.example.voting.controller;

import com.example.voting.entity.Candidate;
import com.example.voting.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(value = "/register")
    public ResponseEntity<Candidate> registerCandidate(@RequestBody Candidate candidate){
        return new ResponseEntity<>(candidateService.registerCandidate(candidate.getName(),candidate.getParty()), HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Candidate>> getAllCandidates(){
        return new ResponseEntity<>(candidateService.getAllCandidates(),HttpStatus.OK);
    }

}
