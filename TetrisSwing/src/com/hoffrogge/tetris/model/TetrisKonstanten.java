package com.hoffrogge.tetris.model;

import java.awt.Color;

public class TetrisKonstanten {

    private TetrisKonstanten() {
    }

    public static final boolean MUSIK_AN                  = false;

    public static final int     BLOCK_BREITE              = 40;

    public static final int     ABSTAND                   = BLOCK_BREITE / 8;

    public static final int     SPIELFELD_X0              = 0;
    public static final int     SPIELFELD_Y0              = 0;
    public static final int     SPIELFELD_BREITE          = BLOCK_BREITE * 10;
    public static final int     SPIELFELD_HOEHE           = BLOCK_BREITE * 20;
    public static final int     SPIELFELD_POS_X           = ABSTAND;
    public static final int     SPIELFELD_POS_Y           = ABSTAND;

    public static final int     VORSCHAU_BREITE           = BLOCK_BREITE * 5;
    public static final int     VORSCHAU_HOEHE            = BLOCK_BREITE * 6;
    public static final int     VORSCHAU_POS_X            = SPIELFELD_BREITE + ABSTAND * 2;
    public static final int     VORSCHAU_POS_Y            = ABSTAND;

    public static final int     LABEL_LINKS_POS_X         = SPIELFELD_BREITE + ABSTAND * 2;
    public static final int     LABEL_LINKS_POS_Y         = VORSCHAU_HOEHE + BLOCK_BREITE;

    public static final int     LABEL_RECHTS_POS_X        = SPIELFELD_BREITE + VORSCHAU_BREITE / 2;
    public static final int     LABEL_RECHTS_POS_Y        = VORSCHAU_HOEHE + BLOCK_BREITE * 2;

    public static final int     FENSTER_BREITE            = SPIELFELD_BREITE + VORSCHAU_BREITE + BLOCK_BREITE;
    public static final int     FENSTER_HOEHE             = SPIELFELD_HOEHE + BLOCK_BREITE;

    public static final int     SPIEL_GESCHWINDIGKEIT     = 500;
    public static final int     SPIEL_GESCHWINDIGKEIT_MIN = 50;
    public static final int     TETROMINO_FALL_HOEHE      = BLOCK_BREITE;

    public static final Color   HINTERGRUND               = new Color(251, 246, 242);
    public static final Color   VORDERGRUND               = new Color(250, 250, 250);
    public static final Color   TEXT                      = new Color(55, 63, 81);
    public static final Color   RAHMEN                    = new Color(141, 167, 190);
    public static final Color   AKZENT                    = new Color(200, 70, 48);

    public static final Color   TETROMINO_FARBE_BLOCK     = new Color(200, 70, 48);

}