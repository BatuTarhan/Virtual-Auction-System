package com.example.Virtual_AuctionSystem.controller;

import com.example.Virtual_AuctionSystem.controller.request.UserRequest;
import com.example.Virtual_AuctionSystem.entity.User;
import com.example.Virtual_AuctionSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserRequest user){
        userService.addUser(user);
    }

    @DeleteMapping("{id}")
    public void removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
    }

    @PutMapping
    public void updateUser(@RequestBody UserRequest user) {
        userService.updateUser(user);
    }
}
