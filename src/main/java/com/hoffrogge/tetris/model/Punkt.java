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

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[x = " + x + "] [y = " + y + "]";
    }
}
