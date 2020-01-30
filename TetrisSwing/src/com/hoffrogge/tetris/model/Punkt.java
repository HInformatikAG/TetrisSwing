package com.hoffrogge.tetris.model;

/**
 * Diese Klasse kapselt einen Punkt in einem zweidimensionalen Koordinatensystem
 * mit X- und Y-Koordinaten.
 */
public class Punkt {

    private int x;
    private int y;

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
