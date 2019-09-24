package com.hoffrogge.tetris.model.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.hoffrogge.tetris.model.Punkt;
import com.hoffrogge.tetris.model.TetrisKonstanten;

public abstract class Tetromino implements TetrominoSpielstein {

    private Color                       linienFarbe;

    protected int                       durchmesser;

    protected List<TetrominoSpielstein> viertelBloecke = new ArrayList<>(4);

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Tetromino unterstuetzt diese Methode nicht! Nutze Teilblock!");
    }

    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException("Tetromino unterstuetzt diese Methode nicht! Nutze Teilblock!");
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Tetromino unterstuetzt diese Methode nicht! Nutze Teilblock!");
    }

    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException("Tetromino unterstuetzt diese Methode nicht! Nutze Teilblock!");
    }

    @Override
    public void setLinienFarbe(Color farbe) {
        linienFarbe = farbe;
    }

    @Override
    public Color getFuellFarbe() {

        if (viertelBloecke.isEmpty())
            throw new IllegalStateException("Der Tetromino wurde aufgeteilt, es kann keine Fuellfarbe mehr bestimmt werden!");

        return viertelBloecke.get(0).getFuellFarbe();
    }

    @Override
    public void setFuellFarbe(Color farbe) {

        for (TetrominoSpielstein block : viertelBloecke)
            block.setFuellFarbe(farbe);
    }

    @Override
    public void zeichnen(Graphics graphics) {

        if (graphics == null)
            return;

        zeichneViertelBloecke(graphics);
    }

    private void zeichneViertelBloecke(Graphics graphics) {

        if (viertelBloecke.isEmpty())
            return;

        if (linienFarbe == null)
            linienFarbe = new Color(0, 0, 0);

        Color fuellFarbe = viertelBloecke.get(0).getFuellFarbe();

        for (TetrominoSpielstein block : viertelBloecke) {

            block.setLinienFarbe(linienFarbe);
            block.setFuellFarbe(fuellFarbe);
            block.zeichnen(graphics);
        }
    }

    /* Methoden aus TetrominoGeometrie */

    @Override
    public int getHoechstesY() {

        int hoechstesY = TetrisKonstanten.SPIELFELD_HOEHE;

        for (TetrominoSpielstein block : viertelBloecke)
            if (block.getHoechstesY() < hoechstesY)
                hoechstesY = block.getHoechstesY();

        return hoechstesY;
    }

    @Override
    public int getTiefstesY() {

        int tiefstesY = 0;

        for (TetrominoSpielstein block : viertelBloecke)
            if (block.getTiefstesY() > tiefstesY)
                tiefstesY = block.getTiefstesY();

        return tiefstesY;
    }

    @Override
    public int getKanteLinksX() {

        int kanteLinksX = TetrisKonstanten.SPIELFELD_BREITE;

        for (TetrominoSpielstein block : viertelBloecke)
            if (block.getKanteLinksX() < kanteLinksX)
                kanteLinksX = block.getKanteLinksX();

        return kanteLinksX;
    }

    @Override
    public int getKanteRechtsX() {

        int kanteRechtsX = 0;

        for (TetrominoSpielstein block : viertelBloecke)
            if (block.getKanteRechtsX() > kanteRechtsX)
                kanteRechtsX = block.getKanteRechtsX();

        return kanteRechtsX;
    }

    @Override
    public void bewegeNachUnten() {

        if (viertelBloecke.isEmpty())
            return;

        for (TetrominoSpielstein block : viertelBloecke)
            block.setY(block.getY() + TetrisKonstanten.TETROMINO_FALL_HOEHE);
    }

    @Override
    public void bewegeNachRechts() {

        if (viertelBloecke.isEmpty())
            return;

        if (getKanteRechtsX() == TetrisKonstanten.SPIELFELD_BREITE)
            return;

        for (TetrominoSpielstein block : viertelBloecke) {

            int neuesBlockX = block.getX() + TetrisKonstanten.BLOCK_BREITE;

            if (neuesBlockX <= TetrisKonstanten.SPIELFELD_BREITE)
                block.setX(neuesBlockX);
        }
    }

    @Override
    public void bewegeNachLinks() {

        if (viertelBloecke.isEmpty())
            return;

        if (getKanteLinksX() == 0)
            return;

        for (TetrominoSpielstein block : viertelBloecke) {

            int neuesBlockX = block.getX() - TetrisKonstanten.BLOCK_BREITE;

            if (neuesBlockX >= 0)
                block.setX(neuesBlockX);
        }
    }

    @Override
    public boolean faelltAuf(TetrominoSpielstein block) {

        if (viertelBloecke.isEmpty())
            return false;

        for (TetrominoSpielstein fallenderBlock : viertelBloecke)
            if (fallenderBlock.getX() == block.getX() && fallenderBlock.getTiefstesY() == block.getHoechstesY())
                return true;

        return false;
    }

    /* gegen den Uhrzeigersinn */
    @Override
    public void rotiereNachLinks() {

        if (viertelBloecke.size() != 4)
            throw new IllegalStateException("Der Tetromino hat keine vier Bloecke!");

        TetrominoSpielstein zweiterBlock = viertelBloecke.get(1);

        int xMitte = zweiterBlock.getX();
        int yMitte = zweiterBlock.getY();
        int breite = TetrisKonstanten.BLOCK_BREITE;

        /* 4x4 Matrix */
        Punkt[][] tetrominoMatrix = new Punkt[4][4];

        tetrominoMatrix[0][0] = new Punkt(xMitte - breite, yMitte - breite);
        tetrominoMatrix[0][1] = new Punkt(xMitte, yMitte - breite);
        tetrominoMatrix[0][2] = new Punkt(xMitte + breite, yMitte - breite);
        tetrominoMatrix[0][3] = new Punkt(xMitte + breite * 2, yMitte - breite);

        tetrominoMatrix[1][0] = new Punkt(xMitte - breite, yMitte);
        tetrominoMatrix[1][1] = new Punkt(xMitte, yMitte);
        tetrominoMatrix[1][2] = new Punkt(xMitte + breite, yMitte);
        tetrominoMatrix[1][3] = new Punkt(xMitte + breite * 2, yMitte);

        tetrominoMatrix[2][0] = new Punkt(xMitte - breite, yMitte + breite);
        tetrominoMatrix[2][1] = new Punkt(xMitte, yMitte + breite);
        tetrominoMatrix[2][2] = new Punkt(xMitte + breite, yMitte + breite);
        tetrominoMatrix[2][3] = new Punkt(xMitte + breite * 2, yMitte + breite);

        tetrominoMatrix[3][0] = new Punkt(xMitte - breite, yMitte + breite * 2);
        tetrominoMatrix[3][1] = new Punkt(xMitte, yMitte + breite * 2);
        tetrominoMatrix[3][2] = new Punkt(xMitte + breite, yMitte + breite * 2);
        tetrominoMatrix[3][3] = new Punkt(xMitte + breite * 2, yMitte + breite * 2);

        for (TetrominoSpielstein block : viertelBloecke) {

            boolean blockRotiert = false;

            for (int i = 0; i <= 3; i++) {

                if (blockRotiert)
                    break;

                for (int j = 0; j <= 3; j++) {

                    if (blockRotiert)
                        break;

                    int xBlock = block.getX();
                    int yBlock = block.getY();

                    Punkt punkt = tetrominoMatrix[i][j];

                    if (punkt.getX() == xBlock && punkt.getY() == yBlock) {

                        Punkt neuerPunkt = findePunkt(tetrominoMatrix, i, j);

                        if (neuerPunkt == null)
                            throw new IllegalStateException("Punkt nicht gefunden!");

                        block.setX(neuerPunkt.getX());
                        block.setY(neuerPunkt.getY());

                        blockRotiert = true;
                    }
                }
            }
        }
    }

    /* im Uhrzeigersinn */
    @Override
    public void rotiereNachRechts() {
        rotiereNachLinks();
        rotiereNachLinks();
        rotiereNachLinks();
    }

    Punkt findePunkt(Punkt[][] tetrominoMatrix, int i, int j) {

        Punkt neuerPunkt = null;

        if (i == 0 && j == 0)
            neuerPunkt = tetrominoMatrix[0][2];
        else if (i == 0 && j == 1)
            neuerPunkt = tetrominoMatrix[1][2];
        else if (i == 0 && j == 2)
            neuerPunkt = tetrominoMatrix[2][2];

        else if (i == 1 && j == 0)
            neuerPunkt = tetrominoMatrix[0][1];
        else if (i == 1 && j == 1)
            neuerPunkt = tetrominoMatrix[1][1];
        else if (i == 1 && j == 2)
            neuerPunkt = tetrominoMatrix[2][1];

        else if (i == 2 && j == 0)
            neuerPunkt = tetrominoMatrix[0][0];
        else if (i == 2 && j == 1)
            neuerPunkt = tetrominoMatrix[1][0];
        else if (i == 2 && j == 2)
            neuerPunkt = tetrominoMatrix[2][0];

        return neuerPunkt;
    }

    @Override
    public List<TetrominoSpielstein> getViertelBloecke() {
        return viertelBloecke;
    }

    @Override
    public int compareTo(TetrominoSpielstein andererSpielstein) {

        /*
         * Jeder Spielstein besteht aus genau vier ViertelBloecken, daher sind
         * zwei Spielsteine gleich, wenn jeder der vier ViertelBloecke seinem
         * Pendant im anderen Tetromino gleicht.
         */
        List<TetrominoSpielstein> andereViertelBloecke = andererSpielstein.getViertelBloecke();

        /* Es muss jeweils genau vier geben! */
        if (viertelBloecke.size() != 4 || andereViertelBloecke.size() != 4)
            throw new IllegalStateException("Die Spielsteine sind kaputt! Der Spielstein hat " + viertelBloecke.size()
                    + " ViertelBloecke, aber der Vergleichsstein hat " + andereViertelBloecke.size());

        int compareResult = 0;

        for (int i = 0; i < 4; i++)
            compareResult = viertelBloecke.get(i).compareTo(andereViertelBloecke.get(i));

        return compareResult;
    }
}