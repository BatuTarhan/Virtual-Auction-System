package com.example.Virtual_AuctionSystem.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Virtual_AuctionSystem.Backend.entity.Account;
import com.example.Virtual_AuctionSystem.Backend.entity.User;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountById(Long id);
    Optional<Account> findAcccountByUser(User user);
}
