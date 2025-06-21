package com.example.voting.util;

import com.example.voting.model.Block;
import com.example.voting.model.Blockchain;

import java.util.List;

public class TestBlockChain {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        blockchain.addBlock(new Block(1, List.of("Vote: Alice -> Bob"), blockchain.getLatestBlock().getHash()));
        blockchain.addBlock(new Block(2, List.of("Vote: Charlie -> Alice"), blockchain.getLatestBlock().getHash()));

        System.out.println("Blockchain is valid: " + blockchain.isChainValid());

        blockchain.getChain().forEach(block -> {
            System.out.println("\nBlock Hash: " + block.getHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Transactions: " + block.getTransactions());
        });
    }
}
