package com.example.Virtual_AuctionSystem.controller;

import com.example.Virtual_AuctionSystem.entity.Auction;
import com.example.Virtual_AuctionSystem.entity.AuctionItem;
import com.example.Virtual_AuctionSystem.service.AuctionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auction")
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;

    @GetMapping()
    public List<Auction> getAuctions(){
        return auctionService.getAuctions();
    }

    @GetMapping("/{auctionId}/items")
    public List<AuctionItem> getAuctionItems(@PathVariable Long auctionId){
        return auctionService.getAuctionItems(auctionId);
    }

    @PostMapping("/create")
    public void createAuction(){
        auctionService.createAuction();
    }

    @PostMapping("/{auctionId}/addItems")
    public void addAuctionItems(
            @PathVariable Long auctionId,
            @RequestBody List<AuctionItem> items){
        auctionService.addAuctionItems(auctionId, items);
    }

    @PutMapping("{auctionId}/configure/{status}")
    public void configureAuctionStatus(
            @PathVariable Long auctionId,
            @PathVariable Auction.AuctionStatus status){
        auctionService.configureAuctionStatus(auctionId, status);
    }
}
