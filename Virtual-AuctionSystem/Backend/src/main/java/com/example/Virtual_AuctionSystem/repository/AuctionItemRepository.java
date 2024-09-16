package com.example.Virtual_AuctionSystem.repository;

import com.example.Virtual_AuctionSystem.entity.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    Optional<AuctionItem> findAuctionItemById(Long id);
}
