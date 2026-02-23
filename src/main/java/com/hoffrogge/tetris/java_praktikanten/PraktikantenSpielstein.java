package com.hoffrogge.tetris.java_praktikanten;

import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class PraktikantenSpielstein implements TetrominoSpielstein {

    private int x;
    private int y;

    public PraktikantenSpielstein() {
        this.x = 120;
        this.y = 100;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getHoechstesY() {
        return y;
    }

    @Override
    public int getTiefstesY() {
        return y;
    }

    @Override
    public int getKanteLinksX() {
        return x;
    }

    @Override
    public int getKanteRechtsX() {
        return x;
    }

    @Override
    public void bewegeNachUnten() {
        y = y + 10;
    }

    @Override
    public void bewegeNachRechts() {

    }

    @Override
    public void bewegeNachLinks() {

    }

    @Override
    public void rotiereNachLinks() {

    }

    @Override
    public void rotiereNachRechts() {

    }

    @Override
    public boolean faelltAuf(TetrominoSpielstein tetrominoSpielstein) {
        return false;
    }

    @Override
    public List<TetrominoSpielstein> getTeilBloecke() {
        return Collections.emptyList();
    }

    @Override
    public Color getFuellFarbe() {
        return Color.blue;
    }

    @Override
    public void setFuellFarbe(Color farbe) {

    }

    @Override
    public void setLinienFarbe(Color farbe) {

    }

    @Override
    public void zeichnen(Graphics graphics) {

        graphics.setColor(getFuellFarbe());

        graphics.drawString("Ich bin nur ein Platzhalter ;)", x, y);

        // Dieser Befehl (ohne die // vorweg) ändert die Farbe der Linie, die gezeichnet wird
        // graphics.setColor(Color.RED);
        // Dieser Befehl zeichnet eine Linie (draws a line) von den Koordinaten 0,0 zu 100,100, also einfach eine schräge Linie
        // graphics.drawLine(0,0, 100, 100);

        // nutze diese beiden Befehle, um einen Tetrisspielstein deiner Wahl zu zeichnen
        // der Spielstein wird sich am Anfang nicht bewegen, schaue dir den Rest dieser Klasse an und überlege, was geändert werden muss, damit sich der Spielstein bewegt.
    }

    @Override
    public int compareTo(TetrominoSpielstein o) {
        return 0;
    }
}