package com.hoffrogge.tetris.zukunftstag;

import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

import java.awt.*;
import java.util.List;

public abstract class ZukunftstagBasisTetromino implements TetrominoSpielstein {

    private int x = TetrisKonstanten.SPIELFELD_BREITE / 2, y = 0;

    private Color fuellfarbe = Color.BLUE;
    private Color linienFarbe = Color.BLACK;

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
    public void bewegeNachUnten() {
        y = y + TetrisKonstanten.BLOCK_BREITE;
    }

    @Override
    public boolean faelltAuf(TetrominoSpielstein tetrominoSpielstein) {
        // Spielsteine fallen erstmal durch andere Spielsteine durch
        return false;
    }

    @Override
    public List<TetrominoSpielstein> getTeilBloecke() {
        // fuer den Zukunftstag wird noch ohne Teilbloecke gearbeitet
        return List.of();
    }

    @Override
    public Color getFuellFarbe() {
        return fuellfarbe;
    }

    @Override
    public void setFuellFarbe(Color farbe) {
        this.fuellfarbe = farbe;
    }

    public Color getLinienFarbe() {
        return linienFarbe;
    }

    @Override
    public void setLinienFarbe(Color farbe) {
        this.linienFarbe = farbe;
    }

    @Override
    public int compareTo(TetrominoSpielstein o) {
        return getX() - o.getX();
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;

        ZukunftstagBasisTetromino that = (ZukunftstagBasisTetromino) o;

        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {

        int result = x;
        result = 31 * result + y;

        return result;
    }
}