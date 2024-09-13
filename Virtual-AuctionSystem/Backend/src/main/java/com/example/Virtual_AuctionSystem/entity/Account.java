package com.example.Virtual_AuctionSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long id;

    @OneToOne(mappedBy = "account")
    private User user;

    private double balance;

    public Account(User user) {
        this.user = user;
        this.balance = 0.0;
    }
}
