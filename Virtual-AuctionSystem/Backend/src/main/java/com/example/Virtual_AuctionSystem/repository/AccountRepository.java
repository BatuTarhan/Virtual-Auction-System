package com.example.Virtual_AuctionSystem.repository;

import com.example.Virtual_AuctionSystem.entity.Account;
import com.example.Virtual_AuctionSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountById(Long id);
    Optional<Account> findAcccountByUser(User user);
}
