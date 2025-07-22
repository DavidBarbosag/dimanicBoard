package com.eci.ARSW.DinamicBoard.config;

import com.eci.ARSW.DinamicBoard.GameCodeInterceptor;
import com.eci.ARSW.DinamicBoard.JwtHandshakeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final GameCodeInterceptor gameCodeInterceptor;

    public WebSocketConfig(GameCodeInterceptor gameCodeInterceptor) {
        this.gameCodeInterceptor = gameCodeInterceptor;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket puro
        registry
                .addEndpoint("/ws")
                .setAllowedOriginPatterns("*"); // sin SockJS

        // SockJS (opcional, solo si aún lo usas en el frontend)
        registry
                .addEndpoint("/ws-sockjs")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(gameCodeInterceptor);
    }
}