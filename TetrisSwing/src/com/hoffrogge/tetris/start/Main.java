package com.hoffrogge.tetris.start;

import java.awt.event.KeyListener;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.tetromino.StandardTetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.view.Spielfeld;
import com.hoffrogge.tetris.view.Spielfenster;
import com.hoffrogge.tetris.view.TetrisKeyListener;
import com.hoffrogge.tetris.view.Vorschau;

public class Main {

    public static void main(String[] args) {

	/*
	 * =========================================================================
	 * Diese Factory ist daf�r zust�ndig, Spielsteine zu generieren. Mit deiner
	 * eigenen Factory kannst du hier deine eigenen Spielsteine einbauen.
	 * =========================================================================
	 */
	TetrominoFactory tetrominoFactory = new StandardTetrominoFactory();

	/*
	 * Dies ist das Spielfeld. Es zeichnet das Spielfeld und die Spielsteine. Das
	 * Spielfeld kann Tetrisspielsteine nicht beeinflussen.
	 */
	Spielfeld spielfeld = new Spielfeld(tetrominoFactory);

	/*
	 * Die Vorschau zeigt den jeweils n�chsten Spielstein an. Mehr kann sie nicht
	 * tun.
	 */
	Vorschau vorschau = new Vorschau();

	/*
	 * Das Spielfenster zeichnet das Spielfeld, die Vorschau, Highscore, Level,
	 * Punkte und Reihen. Das Spielfenster kann Spielsteine nicht beeinflussen.
	 */
	Spielfenster spielfenster = new Spielfenster(spielfeld, vorschau);

	/*
	 * Das Spiel enth�lt alles an Logik, die es braucht, z. B. das Drehen von
	 * Spielsteinen oder die Berechnung von Punkten. Das Spiel kann nichts
	 * darstellen, das ist Aufgabe des Spielfelds. Das Spiel kann nur dem Spielfeld
	 * Informationen geben, die das Spielfeld dann darstellt.
	 */
	Spiel spiel = new Spiel(tetrominoFactory, spielfeld, spielfenster);

	/*
	 * Die Vorschau beobachtet das Spielfeld, damit sie den jeweils naechsten
	 * Spielstein sehen und darstellen kann.
	 */
	spiel.addObserver(vorschau);

	/*
	 * =========================================================================
	 * Dieser Listener wird fuer die Steuerung des Spiels benoetigt (links, rechts,
	 * runter, drehen, Pause). Er erkennt Tastatureingaben und reicht diese an das
	 * Spiel weiter. Ohne den KeyListener l�uft das Spiel, ohne das der Spieler
	 * etwas machen kann.
	 * =========================================================================
	 */
	KeyListener tetrisKeyListener = new TetrisKeyListener(spiel);

	/*
	 * Der KeyListener muss an einer Komponente h�ngen, die angezeigt wird, in
	 * diesem Fall eignet sich das Spielfenster daf�r.
	 */
	spielfenster.addKeyListener(tetrisKeyListener);

	spiel.starteSpiel();
    }
}