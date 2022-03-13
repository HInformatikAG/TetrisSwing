package com.hoffrogge.tetris.java_ag;

import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;

/**
 * Diese Factory ist dafür zuständig, Spielsteine zu generieren.
 */
public class JavaAGTetrominoFactory implements TetrominoFactory {

    /*
     * =============================================================================
     * HINWEIS: Die Methoden in dieser Klasse musst du korrekt implementieren, aber
     * du musst sie nicht selbst aufrufen. Die Klasse "Spiel" ruft diese Methoden
     * auf.
     * =============================================================================
     */

    @Override
    public TetrominoTyp erstelleZufaelligenTetrominoTyp() {

	/*
	 * =============================================================================
	 * AUFGABE: Diese Methode soll einen der sieben moeglichen Spielsteintypen
	 * auswaehlen und zurueckgeben. Noch nicht den fertigen Spielstein (siehe Klasse
	 * "TetrominoSpielstein"), sondern nur den Typen, siehe Klasse "TetrominoTyp".
	 * =============================================================================
	 */

	return null;
    }

    @Override
    public TetrominoSpielstein erstelleTetromino(TetrominoTyp tetrominoTyp) {

	/*
	 * =============================================================================
	 * AUFGABE: Diese Methode soll einen der sieben moeglichen Spielsteine erstellen
	 * und zwar einen Spielstein, der zum Typ der Variablen "tetrominoTyp" passt,
	 * die als Parameter vorgegeben ist.
	 * =============================================================================
	 */

	return null;
    }
}