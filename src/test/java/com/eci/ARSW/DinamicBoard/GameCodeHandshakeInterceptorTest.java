package com.eci.ARSW.DinamicBoard;

import org.junit.jupiter.api.Test;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class GameCodeHandshakeInterceptorTest {

    @Test
    public void testBeforeHandshakeReturnsTrue() {
        GameCodeHandshakeInterceptor interceptor = new GameCodeHandshakeInterceptor();
        ServerHttpRequest request = mock(ServerHttpRequest.class);
        ServerHttpResponse response = mock(ServerHttpResponse.class);
        WebSocketHandler handler = mock(WebSocketHandler.class);

        boolean result = interceptor.beforeHandshake(request, response, handler, new HashMap<>());
        assertTrue(result, "Handshake should be allowed");
    }

    @Test
    public void testAfterHandshakeDoesNotThrow() {
        GameCodeHandshakeInterceptor interceptor = new GameCodeHandshakeInterceptor();
        ServerHttpRequest request = mock(ServerHttpRequest.class);
        ServerHttpResponse response = mock(ServerHttpResponse.class);
        WebSocketHandler handler = mock(WebSocketHandler.class);

        // Just verify no exceptions are thrown
        interceptor.afterHandshake(request, response, handler, null);
    }
}
