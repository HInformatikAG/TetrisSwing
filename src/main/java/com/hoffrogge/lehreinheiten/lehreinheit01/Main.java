package com.hoffrogge.lehreinheiten.lehreinheit01;

/*
 * Zeichenfläche mit einer Größe von 600 x 600 Pixeln
 *
 *  0,0 ----------------------------------------- 600,0
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  |                                               |
 *  0,600 --------------------------------------- 600,600
 */
public class Main {

    public static void main(String[] args) {

        /*
         * =====================================================================
         *
         * Dieses Zeichenbrett hat eine Länge und Breite von 600.
         *
         * AUFGABE: Schaue dir die Beispiele an und zeichne selbst ein paar Linien.
         * Schaffst du es, einen Tetrisspielstein zu zeichnen?
         * =====================================================================
         */

        Zeichenbrett zeichenbrett = new Zeichenbrett();

        /* vier Linien, die ein Rechteck ergeben */
        zeichenbrett.zeichneLinie(50, 350, 200, 350);
        zeichenbrett.zeichneLinie(200, 350, 200, 450);
        zeichenbrett.zeichneLinie(200, 450, 50, 450);
        zeichenbrett.zeichneLinie(50, 450, 50, 350);
    }
}