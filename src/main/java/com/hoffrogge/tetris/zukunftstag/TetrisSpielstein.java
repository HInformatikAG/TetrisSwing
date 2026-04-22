package com.hoffrogge.tetris.zukunftstag;

import com.hoffrogge.tetris.model.TetrisKonstanten;

import java.awt.Graphics;

public class TetrisSpielstein extends ZukunftstagBasisTetromino {

    /*************************************************
     * Erste Aufgabe: Zeichne einen Tetrisspielstein *
     *************************************************/

    @Override
    public void zeichnen(Graphics graphics) {

        graphics.setColor(getFuellFarbe());
        // oder graphics.setColor(Color.BLACK);

        int xKoordinate = getX();
        int yKoordinate = getY();
        int kantenLaenge = 32;

        // Zeichnet eine Linie zwischen zwei Punkten (x1,y1) und (x2,y2), wie in einem Koordinatensystem aus dem Matheunterricht
        // graphics.drawLine(x1,y1, x2,y2);

        // Es gibt noch andere Möglichkeiten zum Zeichnen, welche könnte man noch benutzen? (Musst du nicht, es geht auch alles mit drawLine)
        // graphics.draw...?

    }

    /*************************************************
     * Zweite Aufgabe: Bewege den Tetrisspielstein   *
     *************************************************/

    @Override
    public void bewegeNachRechts() {
        // was muss hier gemacht werden?
    }

    @Override
    public void bewegeNachLinks() {
        // was muss hier gemacht werden?
    }

    /********************************************************
     * Dritte Aufgabe: Berechne die Positionen links/rechts *
     ********************************************************/

    @Override
    public int getHoechstesY() {
        return getY();
    }

    @Override
    public int getTiefstesY() {
        // das stimmt so nicht, was muss hier korrigiert werden?
        return getY();
    }

    @Override
    public int getKanteLinksX() {
        return getX();
    }

    @Override
    public int getKanteRechtsX() {
        // das stimmt so nicht, was muss hier korrigiert werden?
        return TetrisKonstanten.SPIELFELD_BREITE;
    }

    /********************************************************
     * Vierte Aufgabe: Sehr schwer! Drehe den Spielstein    *
     ********************************************************/

    @Override
    public void rotiereNachLinks() {
        // was muss hier gemacht werden? (schwere Aufgabe)
    }

    @Override
    public void rotiereNachRechts() {
        // was muss hier gemacht werden? (schwere Aufgabe)
    }
}