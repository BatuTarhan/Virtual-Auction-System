package com.example.Virtual_AuctionSystem.Backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String mail;
    private String phone;
}
