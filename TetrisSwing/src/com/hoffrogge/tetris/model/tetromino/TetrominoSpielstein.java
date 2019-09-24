package com.hoffrogge.tetris.model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 * Definition eines Tetris-Spielsteins als TetrominoSpielstein. Dieses Interface
 * erbt von {@link Comparable}. D. h. ein TetrominoSpielstein kann mit einem
 * anderen verglichen werden, dies ist wichtig fuer Sortierung.
 */
public interface TetrominoSpielstein extends Comparable<TetrominoSpielstein> {

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    int getHoechstesY();

    int getTiefstesY();

    int getKanteLinksX();

    int getKanteRechtsX();

    void bewegeNachUnten();

    void bewegeNachRechts();

    void bewegeNachLinks();

    void rotiereNachLinks();

    void rotiereNachRechts();

    boolean faelltAuf(TetrominoSpielstein tetrominoSpielstein);

    /**
     * Jeder TetrominoSpielstein ist aus bis zu vier einzelnen, quadratischen
     * Blöcken aufgebaut.
     */
    List<TetrominoSpielstein> getViertelBloecke();

    Color getFuellFarbe();

    void setFuellFarbe(Color farbe);

    void setLinienFarbe(Color farbe);

    void zeichnen(Graphics graphics);

}