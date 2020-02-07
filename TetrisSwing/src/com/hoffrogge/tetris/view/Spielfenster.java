package com.hoffrogge.tetris.view;

import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.hoffrogge.tetris.model.TetrisKonstanten;

@SuppressWarnings("serial")
public class Spielfenster extends JFrame {

    private JLabel levelWertLabel;
    private JLabel reihenWertLabel;
    private JLabel punkteWertLabel;

    private JLabel highscoreWertLabel;

    public Spielfenster(Spielfeld spielfeld, Vorschau vorschau) {

	getContentPane().add(spielfeld);

	getContentPane().add(vorschau);

	getContentPane().setBackground(TetrisKonstanten.HINTERGRUND);
	getContentPane().setForeground(TetrisKonstanten.VORDERGRUND);

	setTitle("Hoffrogge Tetris Klon");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	setSize(new Dimension(TetrisKonstanten.FENSTER_BREITE, TetrisKonstanten.FENSTER_HOEHE));

	setResizable(false);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);

	Font font = new Font("Arial Black", Font.TRUETYPE_FONT, (int) (TetrisKonstanten.BLOCK_BREITE / 2.2));

	JLabel levelLabel = new JLabel("Level");
	levelLabel.setFont(font);
	levelLabel.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X, TetrisKonstanten.LABEL_LINKS_POS_Y,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	levelLabel.setForeground(TetrisKonstanten.TEXT);
	getContentPane().add(levelLabel);

	JLabel reihenLabel = new JLabel("Reihen");
	reihenLabel.setFont(font);
	reihenLabel.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X,
		TetrisKonstanten.LABEL_LINKS_POS_Y + TetrisKonstanten.BLOCK_BREITE,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	reihenLabel.setForeground(TetrisKonstanten.TEXT);
	getContentPane().add(reihenLabel);

	JLabel punkteLabel = new JLabel("Punkte");
	punkteLabel.setFont(font);
	punkteLabel.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X,
		TetrisKonstanten.LABEL_LINKS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 2,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	punkteLabel.setForeground(TetrisKonstanten.TEXT);
	getContentPane().add(punkteLabel);

	JLabel lblHighscore = new JLabel("Highscore");
	lblHighscore.setForeground(TetrisKonstanten.TEXT);
	lblHighscore.setFont(font);
	lblHighscore.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X,
		TetrisKonstanten.LABEL_LINKS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 3,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	getContentPane().add(lblHighscore);

	levelWertLabel = new JLabel();
	levelWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	levelWertLabel.setFont(font);
	levelWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X, TetrisKonstanten.LABEL_RECHTS_POS_Y,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	levelWertLabel.setForeground(TetrisKonstanten.TEXT);
	getContentPane().add(levelWertLabel);

	reihenWertLabel = new JLabel();
	reihenWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	reihenWertLabel.setFont(font);
	reihenWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X,
		TetrisKonstanten.LABEL_RECHTS_POS_Y + TetrisKonstanten.BLOCK_BREITE,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	reihenWertLabel.setForeground(TetrisKonstanten.TEXT);
	getContentPane().add(reihenWertLabel);

	punkteWertLabel = new JLabel();
	punkteWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	punkteWertLabel.setFont(font);
	punkteWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X,
		TetrisKonstanten.LABEL_RECHTS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 2,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	punkteWertLabel.setForeground(TetrisKonstanten.TEXT);
	getContentPane().add(punkteWertLabel);

	highscoreWertLabel = new JLabel();
	highscoreWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	highscoreWertLabel.setForeground(TetrisKonstanten.TEXT);
	highscoreWertLabel.setFont(font);
	highscoreWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X,
		TetrisKonstanten.LABEL_RECHTS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 3,
		TetrisKonstanten.VORSCHAU_BREITE / 2, TetrisKonstanten.BLOCK_BREITE);
	getContentPane().add(highscoreWertLabel);

	Font steuerungFont = new Font("Arial", Font.PLAIN, TetrisKonstanten.BLOCK_BREITE / 4);
	JLabel lblPauseMitP = new JLabel(
		"<html><p align=\"right\">Pause mit P <br> Drehen mit Q, E <br> Bewegen mit Pfeiltasten</p></html>");
	lblPauseMitP.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPauseMitP.setForeground(TetrisKonstanten.TEXT);
	lblPauseMitP.setFont(steuerungFont);
	lblPauseMitP.setBounds(TetrisKonstanten.SPIELFELD_BREITE + TetrisKonstanten.BLOCK_BREITE * 2,
		TetrisKonstanten.SPIELFELD_HOEHE, TetrisKonstanten.VORSCHAU_BREITE, TetrisKonstanten.BLOCK_BREITE);
	getContentPane().add(lblPauseMitP);

	URL resource = getClass().getResource("tetrisIcon.png");

	ImageIcon icon = new ImageIcon(resource);

	setIconImage(icon.getImage());

	setVisible(true);

	spielfeld.createBufferStrategy(2);
	vorschau.createBufferStrategy(2);
    }

    public void setLevel(String level) {
	levelWertLabel.setText(level);
    }

    public void setPunkte(String punkte) {
	punkteWertLabel.setText(punkte);
    }

    public void setReihen(String reihen) {
	reihenWertLabel.setText(reihen);
    }

    public void setHighscore(String highscore) {
	highscoreWertLabel.setText(highscore);
    }
}