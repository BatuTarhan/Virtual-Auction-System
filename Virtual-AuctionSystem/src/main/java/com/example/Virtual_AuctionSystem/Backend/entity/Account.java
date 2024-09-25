package com.example.Virtual_AuctionSystem.Backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long id;

    @OneToOne(mappedBy = "account")
    @JoinColumn(name = "userId", referencedColumnName = "userId") // Foreign key linking to User
    @JsonManagedReference // Prevents infinite recursion in JSON serialization
    private User user;

    private double balance;

    public Account(User user) {
        this.user = user;
        this.balance = 0.0;
    }
}
