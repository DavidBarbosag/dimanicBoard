package com.eci.ARSW.DinamicBoard;
import com.eci.ARSW.DinamicBoard.model.Stroke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrokeTest {

    @Test
    public void testDefaultConstructorAndSetters() {
        Stroke stroke = new Stroke();
        stroke.setX(10.5f);
        stroke.setY(20.5f);
        stroke.setColor("red");
        stroke.setThickness(5.0f);
        stroke.setStrokeId("stroke123");
        stroke.setGameCode("gameABC");

        assertEquals(10.5f, stroke.getX());
        assertEquals(20.5f, stroke.getY());
        assertEquals("red", stroke.getColor());
        assertEquals(5.0f, stroke.getThickness());
        assertEquals("stroke123", stroke.getStrokeId());
        assertEquals("gameABC", stroke.getGameCode());
    }

    @Test
    public void testParameterizedConstructor() {
        Stroke stroke = new Stroke(100f, 200f, "blue", 3.5f);

        assertEquals(100f, stroke.getX());
        assertEquals(200f, stroke.getY());
        assertEquals("blue", stroke.getColor());
        assertEquals(3.5f, stroke.getThickness());

        // gameCode and strokeId should be null by default
        assertNull(stroke.getGameCode());
        assertNull(stroke.getStrokeId());
    }

    @Test
    public void testUpdateFields() {
        Stroke stroke = new Stroke(0f, 0f, "black", 1f);
        stroke.setX(1f);
        stroke.setY(2f);
        stroke.setColor("green");
        stroke.setThickness(2.5f);
        stroke.setGameCode("XYZ123");
        stroke.setStrokeId("S001");

        assertEquals(1f, stroke.getX());
        assertEquals(2f, stroke.getY());
        assertEquals("green", stroke.getColor());
        assertEquals(2.5f, stroke.getThickness());
        assertEquals("XYZ123", stroke.getGameCode());
        assertEquals("S001", stroke.getStrokeId());
    }
}

