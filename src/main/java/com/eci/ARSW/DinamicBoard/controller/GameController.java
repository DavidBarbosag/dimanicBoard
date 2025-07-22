package com.eci.ARSW.DinamicBoard.controller;

import com.eci.ARSW.DinamicBoard.GameSessionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameSessionManager gameSessionManager;

    public GameController(GameSessionManager gameSessionManager) {
        this.gameSessionManager = gameSessionManager;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createGame() {
        String code = gameSessionManager.createGame();
        return ResponseEntity.ok(code);
    }

    @GetMapping("/validate/{code}")
    public ResponseEntity<Void> validateCode(@PathVariable String code) {
        if (gameSessionManager.exists(code)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
