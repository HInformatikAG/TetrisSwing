package com.hoffrogge.tetris.java_ag.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class DummySpielstein implements TetrominoSpielstein {

    private int x;
    private int y;

    public DummySpielstein() {
        this.x = TetrisKonstanten.SPIELFELD_BREITE / 2;
        this.y = TetrisKonstanten.FENSTER_HOEHE / TetrisKonstanten.BLOCK_BREITE;
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

        graphics.drawString("Ich bin nur ein Platzhalter ;)", x, y + 10);
    }

    @Override
    public int compareTo(TetrominoSpielstein o) {
        return 0;
    }
}