package com.example.Virtual_AuctionSystem.service;

import com.example.Virtual_AuctionSystem.controller.request.UserRequest;
import com.example.Virtual_AuctionSystem.entity.User;
import com.example.Virtual_AuctionSystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final AccountService accountService;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findUserByMail(userRequest.getMail());
        if (user.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        User newUser = new User(userRequest.getName(), userRequest.getMail(), userRequest.getPhone());
        userRepository.save(newUser);

        // Create new accounts for the user
        accountService.addAccount(userRequest);
    }

    @Transactional
    public void removeUser(Long id) {
        Optional<User> user = userRepository.findUserById(id);
        if (user.isEmpty()) {
            throw new IllegalStateException("User doesn't exist");
        }
        userRepository.delete(user.get());
    }

    @Transactional
    public void updateUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findUserByMail(userRequest.getMail());
        if (!user.isPresent()) {
            throw new IllegalStateException("User doesn't exist");
        }

        if(userRequest.getName() != null && !user.get().getName().equals(userRequest.getName())){
            user.get().setName(userRequest.getName());
        }

        if(userRequest.getMail() != null){
            if(!user.get().getMail().equals(userRequest.getMail())) {
                throw new IllegalStateException("mail taken");
            }
            user.get().setMail(userRequest.getMail());
        }
        userRepository.save(user.get());
    }
}
