package com.example.Virtual_AuctionSystem.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "auction")
@Data
@RequiredArgsConstructor
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "auctionId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User participants;

    @ManyToMany
    @JoinTable(
            name = "auctionItems",
            joinColumns = @JoinColumn(name = "auctionId"),
            inverseJoinColumns = @JoinColumn(name = "itemId")
    )
    private List<AuctionItem> items;

    private AuctionStatus status;

    public enum AuctionStatus {
        OPEN,
        CLOSED
    };

}