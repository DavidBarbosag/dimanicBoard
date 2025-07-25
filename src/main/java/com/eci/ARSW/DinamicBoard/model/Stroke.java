package com.eci.ARSW.DinamicBoard.model;

public class Stroke {
    private String strokeId;
    private float x;
    private float y;
    private String color;
    private float thickness;
    private String gameCode;

    public Stroke() {}

    public Stroke(float x, float y, String color, float thickness) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.thickness = thickness;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public String getStrokeId() {
        return strokeId;
    }

    public void setStrokeId(String strokeId) {
        this.strokeId = strokeId;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }
}
