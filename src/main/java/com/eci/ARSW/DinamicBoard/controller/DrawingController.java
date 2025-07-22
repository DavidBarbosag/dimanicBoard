package com.eci.ARSW.DinamicBoard.controller;

import com.eci.ARSW.DinamicBoard.model.Stroke;
import com.eci.ARSW.DinamicBoard.service.StrokeStorageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class DrawingController {

    private final SimpMessagingTemplate messagingTemplate;
    private final StrokeStorageService strokeStorageService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DrawingController(SimpMessagingTemplate messagingTemplate, StrokeStorageService strokeStorageService) {
        this.messagingTemplate = messagingTemplate;
        this.strokeStorageService = strokeStorageService;
    }

    @MessageMapping("/draw/{gameCode}")
    public void draw(@Payload String pointJson, @DestinationVariable String gameCode) {
        try {
            // Parsear JSON a objeto Stroke
            Stroke stroke = objectMapper.readValue(pointJson, Stroke.class);

            // Guardar trazo
            strokeStorageService.addStroke(stroke);

            // Reenviar a los suscriptores
            messagingTemplate.convertAndSend("/topic/strokes/" + gameCode, pointJson);
        } catch (Exception e) {
            e.printStackTrace(); // Puedes manejar con un logger más apropiado
        }
    }

    @MessageMapping("/chat/{gameCode}")
    public void chat(@Payload String chatMessage, @DestinationVariable String gameCode) {
        messagingTemplate.convertAndSend("/topic/chat/" + gameCode, chatMessage);
    }
}

