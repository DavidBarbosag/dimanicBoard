package com.eci.ARSW.DinamicBoard.model;

public class Stroke {
    private float x;
    private float y;
    private String color;
    private float thickness;

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
}
