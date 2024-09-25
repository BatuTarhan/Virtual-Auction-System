package com.example.Virtual_AuctionSystem.Backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    private String name;
    private String mail;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL) // Link back to Account
    @JoinColumn(name = "accountId", referencedColumnName = "accountId")
    @JsonBackReference // Prevents infinite recursion in JSON serialization
    private Account account;

    public User(String name, String mail, String phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }
}
