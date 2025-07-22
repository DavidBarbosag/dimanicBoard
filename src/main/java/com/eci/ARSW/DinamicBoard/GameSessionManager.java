package com.eci.ARSW.DinamicBoard;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class GameSessionManager {
    private final ConcurrentMap<String, Object> activeGames = new ConcurrentHashMap<>();

    public String createGame() {
        String code;
        do {
            code = CodeGenerator.generateCode(6);
        } while (activeGames.containsKey(code));
        activeGames.put(code, new Object()); // Puedes guardar estado de la partida aquí
        return code;
    }

    public boolean exists(String code) {
        return activeGames.containsKey(code);
    }

    public void remove(String code) {
        activeGames.remove(code);
    }
}
