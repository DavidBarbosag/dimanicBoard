package com.eci.ARSW.DinamicBoard.controller;

import com.eci.ARSW.DinamicBoard.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void receiveMessage(ChatMessage msg) {
        messagingTemplate.convertAndSend("/topic/chat", msg);
    }
}

