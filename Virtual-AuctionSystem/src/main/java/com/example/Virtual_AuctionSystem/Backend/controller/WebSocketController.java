package com.example.Virtual_AuctionSystem.Backend.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public String handleMessage(String message) {
        return message;
    }
}