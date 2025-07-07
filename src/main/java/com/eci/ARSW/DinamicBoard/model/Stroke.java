package com.eci.ARSW.DinamicBoard.model;

public class Stroke {
    private float x;
    private float y;
    private String color;

    public Stroke() {}

    public Stroke(float x, float y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
