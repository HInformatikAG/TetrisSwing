package com.hoffrogge.tetris.java_ag;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.view.Spielfeld;
import com.hoffrogge.tetris.view.Spielfenster;
import com.hoffrogge.tetris.view.Vorschau;

import java.awt.event.KeyListener;

/**
 * Dies ist die Klasse, die eine "main Methode" enthaelt. Hier wird das Programm
 * gestartet.
 */
public class Main {

    public static void main(String[] args) {

        /*
         * =========================================================================
         * Diese Factory ist dafür zustaendig, Spielsteine zu generieren.
         *
         * AUFGABE: Vervollstaendige die JavaAGTetrominoFactory.
         * =========================================================================
         */
        TetrominoFactory tetrominoFactory = new JavaAGTetrominoFactory();

        /*
         * =========================================================================
         * Dieser Listener wird fuer die Steuerung des Spiels benoetigt (links, rechts,
         * runter, drehen, Pause). Er erkennt Tastatureingaben und reicht diese an das
         * Spiel weiter. Ohne den KeyListener laeuft das Spiel, aber der Spieler kann
         * nichts machen.
         *
         * AUFGABE: Vervollstaendige den JavaAGTetrisKeyListener.
         * =========================================================================
         */
        KeyListener tetrisKeyListener = new JavaAGTetrisKeyListener();

        /*
         * Dies ist das Spielfeld. Es zeichnet das Spielfeld und die Spielsteine. Das
         * Spielfeld kann Tetrisspielsteine nicht beeinflussen.
         */
        Spielfeld spielfeld = new Spielfeld();

        /*
         * Die Vorschau zeigt den jeweils naechsten Spielstein an. Mehr kann sie nicht
         * tun.
         */
        Vorschau vorschau = new Vorschau();

        /*
         * Das Spielfenster zeichnet das Spielfeld, die Vorschau, Highscore, Level,
         * Punkte und Reihen. Das Spielfenster kann Spielsteine nicht beeinflussen.
         */
        Spielfenster spielfenster = new Spielfenster(spielfeld, vorschau);

        /*
         * Das Spiel enthaelt alles an Logik, die es braucht, z. B. das Drehen von
         * Spielsteinen oder die Berechnung von Punkten. Das Spiel kann nichts
         * darstellen, das ist Aufgabe des Spielfelds. Das Spiel kann nur dem Spielfeld
         * Informationen geben, die das Spielfeld dann darstellt.
         */
        Spiel spiel = new Spiel(tetrominoFactory, spielfeld, spielfenster);

        /*
         * Die Vorschau beobachtet das Spiel, damit sie den jeweils naechsten
         * Spielstein sehen und darstellen kann.
         */
        spiel.addObserver(vorschau);

        /*
         * Der KeyListener muss an einer Komponente haengen, die angezeigt wird, in
         * diesem Fall eignet sich das Spielfeld dafür.
         */
        spielfeld.addKeyListener(tetrisKeyListener);
        spielfeld.requestFocusInWindow();

        /* Das Spiel wird gestartet. */
        spiel.starteSpiel();
    }
}