package com.hoffrogge.tetris.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

public class TetrisKeyListener implements KeyListener {

    private Spielfeld spielfeld;
    private Spiel     spiel;
    private boolean   isBeschleunigterFall;

    public TetrisKeyListener(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

    public void setSpiel(Spiel spiel) {
        this.spiel = spiel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        /* nichts zu tun */
    }

    @Override
    public void keyPressed(KeyEvent e) {

        TetrominoSpielstein fallenderSpielstein = spielfeld.getFallenderSpielstein();

        if (fallenderSpielstein == null)
            return;

        int keyCode = e.getKeyCode();

        switch (keyCode) {

            case KeyEvent.VK_LEFT:

                if (spiel.isPause())
                    return;

                fallenderSpielstein.bewegeNachLinks();
                break;

            case KeyEvent.VK_RIGHT:

                if (spiel.isPause())
                    return;

                fallenderSpielstein.bewegeNachRechts();
                break;

            case KeyEvent.VK_DOWN:

                if (spiel.isPause())
                    return;

                isBeschleunigterFall = true;
                spielfeld.aktualisieren();
                break;

            case KeyEvent.VK_Q:

                if (spiel.isPause())
                    return;

                /*
                 * Spielstein drehen und pruefen, ob der gedrehte Spielstein
                 * Platz hat. Wenn nein, zurueckdrehen.
                 */
                fallenderSpielstein.rotiereNachLinks();

                if (!spiel.passtGedrehterSpielstein(fallenderSpielstein))
                    fallenderSpielstein.rotiereNachRechts();

                break;

            case KeyEvent.VK_E:

                if (spiel.isPause())
                    return;

                /*
                 * Spielstein drehen und pruefen, ob der gedrehte Spielstein
                 * Platz hat. Wenn nein, zurueckdrehen.
                 */
                fallenderSpielstein.rotiereNachRechts();

                if (!spiel.passtGedrehterSpielstein(fallenderSpielstein))
                    fallenderSpielstein.rotiereNachLinks();

                break;

            case KeyEvent.VK_P:
                spiel.togglePause();
                break;

            default:
                break;
        }

        spielfeld.zeichnen();
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (KeyEvent.VK_DOWN == e.getKeyCode())
            isBeschleunigterFall = false;
    }

    // TODO das geh�rt ins Spiel, nicht in den Listener
    public boolean isBeschleunigterFall() {
        return isBeschleunigterFall;
    }
}