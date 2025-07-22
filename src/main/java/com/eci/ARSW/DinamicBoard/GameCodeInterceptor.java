package com.eci.ARSW.DinamicBoard;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class GameCodeInterceptor implements ChannelInterceptor {

    private final GameSessionManager gameSessionManager;

    public GameCodeInterceptor(GameSessionManager gameSessionManager) {
        this.gameSessionManager = gameSessionManager;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String gameCode = accessor.getFirstNativeHeader("game-code");
            if (gameCode == null || !gameSessionManager.exists(gameCode)) {
                throw new IllegalArgumentException("Invalid game code");
            }
            // Guardar código en sesión para validar después si quieres
            accessor.getSessionAttributes().put("gameCode", gameCode);
        }

        return message;
    }
}

