package com.hoffrogge.tetris.view;

import com.hoffrogge.tetris.logik.Spiel;
import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;

import java.awt.*;
import java.text.MessageFormat;

@SuppressWarnings("serial")
public class Spielfeld extends Canvas {

    private Spiel spiel;

    /* Konstruktor */
    public Spielfeld(TetrominoFactory tetrominoFactory) {

        setBackground(TetrisKonstanten.HINTERGRUND);
        setForeground(TetrisKonstanten.VORDERGRUND);

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
                    zeichenFallendenSpielstein(g, fallenderSpielstein);

                for (TetrominoSpielstein gefallenerStein : spiel.getGefalleneSteine())
                    gefallenerStein.zeichnen(g);

            } else
                zeichneSchriftzug(g, "Pause");

            if (spiel.istSpielfeldVoll())
                zeichneSchriftzug(g, "Game Over");

            getBufferStrategy().show();

        } finally {
            if (g != null)
                g.dispose();
        }
    }

    private static void zeichenFallendenSpielstein(Graphics g, TetrominoSpielstein fallenderSpielstein) {

        fallenderSpielstein.zeichnen(g);

        if (TetrisKonstanten.KOORDINATEN_AUS)
            return;

        int kanteLinksX = fallenderSpielstein.getKanteLinksX();
        int hoechstesY = fallenderSpielstein.getHoechstesY();

        int kanteRechtsX = fallenderSpielstein.getKanteRechtsX();
        int tiefstesY = fallenderSpielstein.getTiefstesY();

        Color backupColor = g.getColor();

        g.setColor(Color.BLACK);
        g.drawString(MessageFormat.format("{0},{1}", kanteLinksX, hoechstesY), kanteLinksX, hoechstesY);
        g.drawString(MessageFormat.format("{0},{1}", kanteRechtsX, tiefstesY), kanteRechtsX, tiefstesY);

        g.setColor(backupColor);

        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                0, new float[]{4}, 0);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(dashed);
        g2d.drawRect(kanteLinksX, hoechstesY, kanteRechtsX - kanteLinksX, tiefstesY - hoechstesY);
    }

    private void zeichneSpielfeld(Graphics g) {

        /* Hintergrund des Spielfeldes */
        g.setColor(TetrisKonstanten.VORDERGRUND);
        g.fill3DRect(TetrisKonstanten.SPIELFELD_X0, TetrisKonstanten.SPIELFELD_Y0, TetrisKonstanten.SPIELFELD_BREITE,
                TetrisKonstanten.SPIELFELD_HOEHE, true);

        /* Rahmen */
        g.setColor(TetrisKonstanten.RAHMEN);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        zeichenHilfslinien(g);
        zeichneKoordinaten(g);
    }

    private void zeichneKoordinaten(Graphics g) {

        if (TetrisKonstanten.KOORDINATEN_AUS)
            return;

        Color backupColor = g.getColor();
        g.setColor(Color.BLACK);

        g.drawString("x=0, y=0", 2, 12);
        g.drawString("x=400, y=800", 324, 796);

        g.setColor(backupColor);
    }

    private void zeichenHilfslinien(Graphics g) {

        if (TetrisKonstanten.KOORDINATEN_AUS)
            return;

        Color backupColor = g.getColor();
        g.setColor(new Color(240, 240, 240));

        for (int i = TetrisKonstanten.BLOCK_BREITE; i < TetrisKonstanten.SPIELFELD_BREITE; i += TetrisKonstanten.BLOCK_BREITE)
            g.drawLine(i, 0, i, TetrisKonstanten.SPIELFELD_HOEHE);

        for (int i = TetrisKonstanten.BLOCK_BREITE; i < TetrisKonstanten.SPIELFELD_HOEHE; i += TetrisKonstanten.BLOCK_BREITE)
            g.drawLine(0, i, TetrisKonstanten.SPIELFELD_BREITE, i);

        g.setColor(backupColor);
    }

    private static void zeichneSchriftzug(Graphics g, String text) {

        Font font = new Font("Arial Black", Font.PLAIN, TetrisKonstanten.BLOCK_BREITE);

        g.setFont(font);

        int textBreite = g.getFontMetrics().stringWidth(text);

        g.setColor(TetrisKonstanten.HINTERGRUND);
        g.fillRect(TetrisKonstanten.BLOCK_BREITE, TetrisKonstanten.SPIELFELD_HOEHE / 2 - TetrisKonstanten.BLOCK_BREITE,
                TetrisKonstanten.SPIELFELD_BREITE - TetrisKonstanten.BLOCK_BREITE * 2, TetrisKonstanten.BLOCK_BREITE);

        g.setColor(TetrisKonstanten.RAHMEN);
        g.drawRect(TetrisKonstanten.BLOCK_BREITE, TetrisKonstanten.SPIELFELD_HOEHE / 2 - TetrisKonstanten.BLOCK_BREITE,
                TetrisKonstanten.SPIELFELD_BREITE - TetrisKonstanten.BLOCK_BREITE * 2, TetrisKonstanten.BLOCK_BREITE);

        g.setColor(TetrisKonstanten.TEXT);
        g.drawString(text, TetrisKonstanten.SPIELFELD_BREITE / 2 - textBreite / 2,
                TetrisKonstanten.SPIELFELD_HOEHE / 2);
    }
}