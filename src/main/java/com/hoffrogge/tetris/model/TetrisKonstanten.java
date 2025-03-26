package com.hoffrogge.tetris.model;

import java.awt.Color;

public final class TetrisKonstanten {

    private TetrisKonstanten() {
    }

    public static final boolean MUSIK_AN = false;
    public static final boolean KOORDINATEN_AUS = true;

    public static final int BLOCK_BREITE = 32;

    public static final int ABSTAND = BLOCK_BREITE / 2;

    public static final int SPIELFELD_X0 = 0;
    public static final int SPIELFELD_Y0 = 0;
    public static final int SPIELFELD_BREITE = BLOCK_BREITE * 10;
    public static final int SPIELFELD_HOEHE = BLOCK_BREITE * 20;
    public static final int SPIELFELD_POS_X = ABSTAND;
    public static final int SPIELFELD_POS_Y = ABSTAND;

    public static final int VORSCHAU_BREITE = BLOCK_BREITE * 5;
    public static final int VORSCHAU_HOEHE = BLOCK_BREITE * 6;
    public static final int VORSCHAU_POS_X = SPIELFELD_BREITE + ABSTAND * 2;
    public static final int VORSCHAU_POS_Y = ABSTAND;

    public static final int LABEL_LINKS_POS_X = SPIELFELD_BREITE + ABSTAND * 2;
    public static final int LABEL_LINKS_POS_Y = VORSCHAU_HOEHE + BLOCK_BREITE;

    public static final int LABEL_RECHTS_POS_X = SPIELFELD_BREITE + ABSTAND * 2 + VORSCHAU_BREITE / 2;
    public static final int LABEL_RECHTS_POS_Y = LABEL_LINKS_POS_Y;

    // Das Spielfenster soll in eine Aufloesung von 1366 x 768 hineinpassen
    // Die Win 11 Taskleiste ist bis 48px hoch, daher darf das Spielfenster maximal 720px hoch sein
    public static final int FENSTER_BREITE = (int) (SPIELFELD_BREITE + VORSCHAU_BREITE + BLOCK_BREITE * 3.5);
    public static final int FENSTER_HOEHE = (int) (SPIELFELD_HOEHE + BLOCK_BREITE * 2); // 704px

    public static final int SPIEL_GESCHWINDIGKEIT = 500;
    public static final int SPIEL_GESCHWINDIGKEIT_MIN = 50;
    public static final int TETROMINO_FALL_HOEHE = BLOCK_BREITE;

    public static final Color HINTERGRUND = Color.decode("#E5E5E5");
    public static final Color VORDERGRUND = Color.decode("#F8F8F8");
    public static final Color TEXT = Color.decode("#494949");
    public static final Color AKZENT = Color.decode("#B2B2B2");
    public static final Color RAHMEN = Color.decode("#BEBEBE");

}