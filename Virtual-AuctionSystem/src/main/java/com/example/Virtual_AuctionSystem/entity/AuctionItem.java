package com.example.Virtual_AuctionSystem.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "auctionItems")
@Data
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
