    package com.example.voting.entity;
    
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Voter {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String voterId;
        private boolean hasVoted;
    }
