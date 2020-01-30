package com.hoffrogge.tetris.view;

import java.awt.Dimension;
import java.awt.Font;

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

        setTitle("Hoffrogge Tetris Klon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(TetrisKonstanten.FENSTER_BREITE, TetrisKonstanten.FENSTER_HOEHE));

        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        Font font = new Font("Arial Black", Font.BOLD, 16);

        JLabel levelLabel = new JLabel("Level");
        levelLabel.setFont(font);
        levelLabel.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X, TetrisKonstanten.LABEL_LINKS_POS_Y, 100, 25);
        levelLabel.setForeground(TetrisKonstanten.TEXT);
        getContentPane().add(levelLabel);

        JLabel reihenLabel = new JLabel("Reihen");
        reihenLabel.setFont(font);
        reihenLabel.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X, TetrisKonstanten.LABEL_LINKS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 2, 100, 25);
        reihenLabel.setForeground(TetrisKonstanten.TEXT);
        getContentPane().add(reihenLabel);

        JLabel punkteLabel = new JLabel("Punkte");
        punkteLabel.setFont(font);
        punkteLabel.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X, TetrisKonstanten.LABEL_LINKS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 4, 100, 25);
        punkteLabel.setForeground(TetrisKonstanten.TEXT);
        getContentPane().add(punkteLabel);

        JLabel lblHighscore = new JLabel("Highscore");
        lblHighscore.setForeground(TetrisKonstanten.TEXT);
        lblHighscore.setFont(font);
        lblHighscore.setBounds(TetrisKonstanten.LABEL_LINKS_POS_X, TetrisKonstanten.LABEL_LINKS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 6, 100, 25);
        getContentPane().add(lblHighscore);

        levelWertLabel = new JLabel("New label");
        levelWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        levelWertLabel.setFont(font);
        levelWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X, TetrisKonstanten.LABEL_RECHTS_POS_Y, 100, 25);
        levelWertLabel.setForeground(TetrisKonstanten.TEXT);
        getContentPane().add(levelWertLabel);

        reihenWertLabel = new JLabel("New label");
        reihenWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        reihenWertLabel.setFont(font);
        reihenWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X, TetrisKonstanten.LABEL_RECHTS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 2, 100, 25);
        reihenWertLabel.setForeground(TetrisKonstanten.TEXT);
        getContentPane().add(reihenWertLabel);

        punkteWertLabel = new JLabel("New label");
        punkteWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        punkteWertLabel.setFont(font);
        punkteWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X, TetrisKonstanten.LABEL_RECHTS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 4, 100, 25);
        punkteWertLabel.setForeground(TetrisKonstanten.TEXT);
        getContentPane().add(punkteWertLabel);

        highscoreWertLabel = new JLabel("New label");
        highscoreWertLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        highscoreWertLabel.setForeground(TetrisKonstanten.TEXT);
        highscoreWertLabel.setFont(font);
        highscoreWertLabel.setBounds(TetrisKonstanten.LABEL_RECHTS_POS_X, TetrisKonstanten.LABEL_RECHTS_POS_Y + TetrisKonstanten.BLOCK_BREITE * 6, 100, 25);
        getContentPane().add(highscoreWertLabel);

        Font steuerungFont = new Font("Arial", Font.PLAIN, 12);
        JLabel lblPauseMitP = new JLabel("Pause mit P");
        lblPauseMitP.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPauseMitP.setForeground(TetrisKonstanten.TEXT);
        lblPauseMitP.setFont(steuerungFont);
        lblPauseMitP.setBounds(460, 780, 150, 25);
        getContentPane().add(lblPauseMitP);

        JLabel lblDrehenMitQ = new JLabel("Drehen mit Q, E");
        lblDrehenMitQ.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDrehenMitQ.setForeground(TetrisKonstanten.TEXT);
        lblDrehenMitQ.setFont(steuerungFont);
        lblDrehenMitQ.setBounds(460, 744, 150, 25);
        getContentPane().add(lblDrehenMitQ);

        JLabel lblBewegenMitPfeiltasten = new JLabel("Bewegen mit Pfeiltasten");
        lblBewegenMitPfeiltasten.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBewegenMitPfeiltasten.setForeground(TetrisKonstanten.TEXT);
        lblBewegenMitPfeiltasten.setFont(steuerungFont);
        lblBewegenMitPfeiltasten.setBounds(450, 708, 160, 25);
        getContentPane().add(lblBewegenMitPfeiltasten);

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