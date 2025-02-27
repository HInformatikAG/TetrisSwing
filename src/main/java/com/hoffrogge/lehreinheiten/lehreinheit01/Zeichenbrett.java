package com.hoffrogge.lehreinheiten.lehreinheit01;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.MessageFormat;

/*
 * Zeichenfläche mit einer Größe von 800 x 800 Pixeln
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

/**
 * Zeichenfläche mit einer Größe von 800 x 800 Pixeln. <br />
 * Zeichnen einer Linie ist möglich mit
 * {@link Zeichenbrett#zeichneLinie(int, int, int, int)}<br />
 */
public class Zeichenbrett extends JPanel {

    private static final int KANTEN_LAENGE = 600;

    private BufferedImage zeichenflaeche;

    private JFrame fenster;

    public Zeichenbrett() {

        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        zeichenflaeche = new BufferedImage(KANTEN_LAENGE + 1, KANTEN_LAENGE + 1, BufferedImage.TYPE_INT_RGB);

        Graphics g2d = zeichenflaeche.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, zeichenflaeche.getWidth(), zeichenflaeche.getHeight());

        g2d.dispose();

        fenster = new JFrame();
        fenster.setTitle(MessageFormat.format("Zeichenbrett {0} x {1}", KANTEN_LAENGE, KANTEN_LAENGE));

        URL resource = getClass().getResource("LehreinheitenIcon.png");
        ImageIcon icon = new ImageIcon(resource);
        fenster.setIconImage(icon.getImage());

        Container fensterInhalt = fenster.getContentPane();
        fensterInhalt.setLayout(new BorderLayout());

        fensterInhalt.add(this, BorderLayout.CENTER);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenster.setSize(new Dimension(KANTEN_LAENGE, KANTEN_LAENGE));

        /*
         * Kleiner Trick, um das Fenster in der Mitte des Bildschirms anzuzeigen
         */
        fenster.setLocationRelativeTo(null);
        fenster.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(zeichenflaeche, 2, 2, this);
    }

    /**
     * Zeichnet eine Linie vom Punkt x1, y1 zum Punkt x2, y2
     */
    public void zeichneLinie(int x1, int y1, int x2, int y2) {

        Graphics g2d = zeichenflaeche.getGraphics();

        g2d.setColor(Color.BLACK);
        g2d.drawLine(x1, y1, x2, y2);
    }

    /**
     * Zeichnet eine Linie vom Punkt x1, y1 zum Punkt x2, y2 mit der Farbe "farbe"
     */
    public void zeichneFarbigeLinie(int x1, int y1, int x2, int y2, Color farbe) {

        Graphics g2d = zeichenflaeche.getGraphics();

        g2d.setColor(farbe);
        g2d.drawLine(x1, y1, x2, y2);
    }
}