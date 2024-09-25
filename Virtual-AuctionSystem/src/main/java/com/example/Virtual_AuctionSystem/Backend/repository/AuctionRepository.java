package com.example.Virtual_AuctionSystem.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Virtual_AuctionSystem.Backend.entity.Auction;

import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    Optional<Auction> findAuctionById(Long id);
}
