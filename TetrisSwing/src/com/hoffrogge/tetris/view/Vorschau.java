package com.hoffrogge.tetris.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;

@SuppressWarnings("serial")
public class Vorschau extends Canvas implements PropertyChangeListener {

    private static final Color FUELL_FARBE = new Color(200, 240, 255);

    private TetrominoFactory tetrominoFactory;

    private TetrominoSpielstein naechsterSpielstein;

    public Vorschau() {

	this.tetrominoFactory = new VorschauTetrominoFactory();

	setBackground(TetrisKonstanten.HINTERGRUND);
	setForeground(TetrisKonstanten.VORDERGRUND);

	setBounds(TetrisKonstanten.VORSCHAU_POS_X, TetrisKonstanten.VORSCHAU_POS_Y, TetrisKonstanten.VORSCHAU_BREITE,
		TetrisKonstanten.VORSCHAU_HOEHE);
    }

    // FIXME es kommt manchmal vor, dass das allererste Event im Spiel nicht ankommt
    // und der "erste naechste" Spielstein deswegen nicht in der Vorschau auftaucht.
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

	if (!Spiel.NAECHSTER_SPIELSTEIN_TYP.equals(evt.getPropertyName()))
	    return;

	TetrominoTyp naechsterSpielsteinTyp = (TetrominoTyp) evt.getOldValue();

	if (naechsterSpielsteinTyp == null)
	    return;

	naechsterSpielstein = tetrominoFactory.erstelleTetromino(naechsterSpielsteinTyp);

	for (TetrominoSpielstein teilblock : naechsterSpielstein.getTeilBloecke())
	    teilblock.setFuellFarbe(FUELL_FARBE);

	zeichnen();
    }

    private void zeichnen() {

	Graphics g = null;

	try {

	    g = getBufferStrategy().getDrawGraphics();

	    /* Hintergrund des Feldes */
	    g.setColor(TetrisKonstanten.VORDERGRUND);
	    g.fill3DRect(0, 0, TetrisKonstanten.VORSCHAU_BREITE, TetrisKonstanten.VORSCHAU_HOEHE, true);

	    /* Rahmen */
	    g.setColor(TetrisKonstanten.RAHMEN);
	    g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

	    if (naechsterSpielstein != null)
		naechsterSpielstein.zeichnen(g);

	} finally {
	    if (g != null)
		g.dispose();
	}

	getBufferStrategy().show();
    }
}