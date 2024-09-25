package com.example.Virtual_AuctionSystem.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Virtual_AuctionSystem.Backend.entity.AuctionItem;

import java.util.Optional;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    Optional<AuctionItem> findAuctionItemById(Long id);
}
