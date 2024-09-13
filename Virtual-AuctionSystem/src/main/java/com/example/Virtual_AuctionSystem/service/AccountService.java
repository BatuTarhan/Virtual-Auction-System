package com.example.Virtual_AuctionSystem.service;

import com.example.Virtual_AuctionSystem.controller.request.UserRequest;
import com.example.Virtual_AuctionSystem.entity.Account;
import com.example.Virtual_AuctionSystem.entity.User;
import com.example.Virtual_AuctionSystem.repository.AccountRepository;
import com.example.Virtual_AuctionSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public void addAccount(UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findUserByMail(userRequest.getMail());
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("Invalid User Credentials");
        }
        User user = userOptional.get();
        if(user.getAccount() != null){
            throw new IllegalArgumentException("Account Already Exists for User");
        }
        Account account = new Account(user);
        user.setAccount(account);
        userRepository.save(user);
        accountRepository.save(account);
    }

    @Transactional
    public void removeAccount(Long id) {
        Optional<Account> accountOptional = accountRepository.findAccountById(id);
        if(accountOptional.isEmpty()){
            throw new IllegalArgumentException("Invalid Account Id");
        }
        Account account = accountOptional.get();
        User user = account.getUser();
        user.setAccount(null);
        userRepository.save(user);
        accountRepository.deleteById(id);
    }
}
