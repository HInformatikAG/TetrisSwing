package com.hoffrogge.tetris.view;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

@SuppressWarnings("serial")
public class Spielfeld extends Canvas {

    private Spiel spiel;

    /* Konstruktor */
    public Spielfeld(TetrominoFactory tetrominoFactory) {

	setBackground(TetrisKonstanten.HINTERGRUND);
	setBounds(TetrisKonstanten.SPIELFELD_POS_X, TetrisKonstanten.SPIELFELD_POS_Y, TetrisKonstanten.SPIELFELD_BREITE,
		TetrisKonstanten.SPIELFELD_HOEHE);
    }

    public void setSpiel(Spiel spiel) {
	this.spiel = spiel;
    }

    public void zeichnen() {

	Graphics g = null;

	try {

	    g = getBufferStrategy().getDrawGraphics();

	    zeichneSpielfeld(g);

	    if (!spiel.isPause()) {

		TetrominoSpielstein fallenderSpielstein = spiel.getFallenderSpielstein();

		if (fallenderSpielstein != null)
		    fallenderSpielstein.zeichnen(g);

		for (TetrominoSpielstein gefallenerStein : spiel.getGefalleneSteine())
		    gefallenerStein.zeichnen(g);

	    } else
		zeichneSchriftzug(g, "Pause");

	    if (spiel.istSpielfeldVoll())
		zeichneSchriftzug(g, "Game Over");

	} finally {
	    if (g != null)
		g.dispose();
	}

	getBufferStrategy().show();
    }

    private static void zeichneSpielfeld(Graphics g) {

	/* Hintergrund des Spielfeldes */
	g.setColor(TetrisKonstanten.VORDERGRUND);
	g.fillRect(TetrisKonstanten.SPIELFELD_X0, TetrisKonstanten.SPIELFELD_Y0, TetrisKonstanten.SPIELFELD_BREITE,
		TetrisKonstanten.SPIELFELD_HOEHE);
    }

    private static void zeichneSchriftzug(Graphics g, String text) {

	Font font = new Font("Arial Black", Font.BOLD, (int) (TetrisKonstanten.BLOCK_BREITE * 1.4));

	g.setColor(TetrisKonstanten.AKZENT);
	g.setFont(font);


	g.drawString(text, TetrisKonstanten.BLOCK_BREITE ,
		TetrisKonstanten.SPIELFELD_HOEHE / 2);
    }
}