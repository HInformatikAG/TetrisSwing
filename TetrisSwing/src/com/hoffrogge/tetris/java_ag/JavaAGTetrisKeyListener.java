package com.hoffrogge.tetris.java_ag;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Dieser Listener wird fuer die Steuerung des Spiels benoetigt (links, rechts,
 * runter, drehen, Pause). Er erkennt Tastatureingaben und reicht diese an das
 * Spiel weiter. Ohne den KeyListener läuft das Spiel, aber der Spieler kann
 * nichts machen.
 */
public class JavaAGTetrisKeyListener implements KeyListener {

    /*
     * =============================================================================
     * HINWEIS: Die Methoden in dieser Klasse musst du korrekt implementieren, aber
     * du musst sie nicht selbst aufrufen. Die Klasse "Spielfenster" ruft diese Methoden
     * auf.
     * =============================================================================
     */

    @Override
    public void keyTyped(KeyEvent e) {
	/*
	 * =============================================================================
	 * AUFGABE: Ueberlege, was passieren soll, wenn eine Taste gedrueckt und
	 * losgelassen wird. Wenn etwas passieren soll, implementiere diese Methode.
	 * Wenn nichts passieren soll, dann schreibe hier einen Kommentar, warum nicht.
	 * =============================================================================
	 */
    }

    @Override
    public void keyPressed(KeyEvent e) {
	/*
	 * =============================================================================
	 * AUFGABE: Ueberlege, was passieren soll, wenn eine Taste gedrueckt wird. Wenn
	 * etwas passieren soll, implementiere diese Methode. Wenn nichts passieren
	 * soll, dann schreibe hier einen Kommentar, warum nicht.
	 * =============================================================================
	 */
    }

    @Override
    public void keyReleased(KeyEvent e) {
	/*
	 * =============================================================================
	 * AUFGABE: Ueberlege, was passieren soll, wenn eine Taste losgelassen wird.
	 * Wenn etwas passieren soll, implementiere diese Methode. Wenn nichts passieren
	 * soll, dann schreibe hier einen Kommentar, warum nicht.
	 * =============================================================================
	 */
    }
}