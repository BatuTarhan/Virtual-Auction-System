package com.example.Virtual_AuctionSystem.repository;

import com.example.Virtual_AuctionSystem.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Optional<Auction> findAuctionById(Long id);
}
