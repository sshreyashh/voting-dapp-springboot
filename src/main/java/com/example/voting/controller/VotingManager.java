package com.example.voting.controller;

import com.example.voting.model.Block;
import com.example.voting.service.VotingManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vote")
public class VotingManager {

    @Autowired
    private VotingManagementService votingManagementService;

    @PostMapping()
    public ResponseEntity<String> vote(@RequestBody Map<String,String> request){
        String voterId = request.get("voterId");
        String candidateName = request.get("candidateName");
        return new ResponseEntity<>(votingManagementService.vote(voterId,candidateName), HttpStatus.OK);

    }

    @GetMapping("/blockchain")
    public ResponseEntity<List<Block>> getBlockchain() {
        return new ResponseEntity<>(votingManagementService.getBlockchain(),HttpStatus.OK);
    }
}
