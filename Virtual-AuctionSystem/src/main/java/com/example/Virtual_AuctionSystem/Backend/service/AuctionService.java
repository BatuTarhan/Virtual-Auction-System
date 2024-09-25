package com.example.Virtual_AuctionSystem.Backend.service;

import com.example.Virtual_AuctionSystem.Backend.entity.Auction;
import com.example.Virtual_AuctionSystem.Backend.entity.AuctionItem;
import com.example.Virtual_AuctionSystem.Backend.repository.AuctionItemRepository;
import com.example.Virtual_AuctionSystem.Backend.repository.AuctionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    public List<Auction> getAuctions() {
        return auctionRepository.findAll();
    }

    public List<AuctionItem> getAuctionItems(Long auctionId) {
        Optional<Auction> auctionOptional = auctionRepository.findAuctionById(auctionId);
        if(auctionOptional.isEmpty()){
            throw new IllegalArgumentException("Invalid Auction Id");
        }
        Auction auction = auctionOptional.get();
        return auction.getItems();
    }

    public void createAuction() {
        Auction auction = new Auction();
        auctionRepository.save(auction);
    }

    @Transactional
    public void addAuctionItems(Long auctionId, List<AuctionItem> items) {
        Optional<Auction> auctionOptional = auctionRepository.findAuctionById(auctionId);
        if(auctionOptional.isEmpty()){
            throw new IllegalArgumentException("Invalid Auction Id");
        }
        Auction auction = auctionOptional.get();
        auction.getItems().addAll(items);
        auctionRepository.save(auction);

        for(AuctionItem item: items){
            auctionItemRepository.save(item);
        }
    }

    @Transactional
    public void configureAuctionStatus(Long auctionId, Auction.AuctionStatus status) {
        Optional<Auction> auctionOptional = auctionRepository.findAuctionById(auctionId);
        if(auctionOptional.isEmpty()){
            throw new IllegalArgumentException("Invalid Auction Id");
        }
        Auction auction = auctionOptional.get();
        String statusString = status.toString();
        if(!statusString.equals("OPEN") || !statusString.equals("CLOSED")){
            throw new IllegalArgumentException("Invalid Status Code");
        }
        auction.setStatus(status);
        auctionRepository.save(auction);    }
}
