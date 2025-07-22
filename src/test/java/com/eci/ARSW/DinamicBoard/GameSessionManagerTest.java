package com.eci.ARSW.DinamicBoard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameSessionManagerTest {

    private GameSessionManager manager;

    @BeforeEach
    public void setup() {
        manager = new GameSessionManager();
    }

    @Test
    public void testCreateGameReturnsCode() {
        String code = manager.createGame();
        assertNotNull(code);
        assertTrue(manager.exists(code));
    }

    @Test
    public void testRemoveGame() {
        String code = manager.createGame();
        manager.remove(code);
        assertFalse(manager.exists(code));
    }
}
