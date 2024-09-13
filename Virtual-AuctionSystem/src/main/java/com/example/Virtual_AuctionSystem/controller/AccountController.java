package com.example.Virtual_AuctionSystem.controller;

import com.example.Virtual_AuctionSystem.controller.request.UserRequest;
import com.example.Virtual_AuctionSystem.entity.Account;
import com.example.Virtual_AuctionSystem.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping
    public void addAccount(@RequestBody UserRequest user) {
        accountService.addAccount(user);
    }

    @DeleteMapping(path = "{id}")
    public void removeAccount(@PathVariable("id") Long id){
        accountService.removeAccount(id);
    }
}

