package com.eci.ARSW.DinamicBoard;

import com.eci.ARSW.DinamicBoard.model.Stroke;
import com.eci.ARSW.DinamicBoard.service.StrokeStorageService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StrokeStorageServiceTest {

    @Test
    public void testAddAndRetrieveStroke() {
        StrokeStorageService service = new StrokeStorageService();
        Stroke s = new Stroke(1.0f, 2.0f, "red", 3.0f);
        service.addStroke(s);
        List<Stroke> strokes = service.getAllStrokes();

        assertEquals(1, strokes.size());
        assertEquals(s.getX(), strokes.get(0).getX());
    }

    @Test
    public void testClearStrokes() {
        StrokeStorageService service = new StrokeStorageService();
        service.addStroke(new Stroke(1, 2, "blue", 2));
        service.clear();
        assertTrue(service.getAllStrokes().isEmpty());
    }
}
