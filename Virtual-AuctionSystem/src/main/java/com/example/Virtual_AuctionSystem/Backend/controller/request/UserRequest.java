package com.example.Virtual_AuctionSystem.Backend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String mail;
    private String phone;
}
