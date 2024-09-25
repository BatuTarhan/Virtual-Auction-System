package com.example.Virtual_AuctionSystem.Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "auctionItems")
@Getter
@Setter
@RequiredArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "itemId")
    private Long id;

    private String itemName;
    private String description;
    private double startingPrice;
    private double currentBid;

    @ManyToOne
    @JoinColumn(name = "sellerId")
    private User seller;

    @OneToOne
    @JoinColumn(name = "highBidderId")
    private User highestBidder;
}
