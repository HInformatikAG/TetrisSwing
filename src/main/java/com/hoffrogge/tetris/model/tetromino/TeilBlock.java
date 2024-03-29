package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class TeilBlock implements TetrominoSpielstein {

    private int x;
    private int y;
    private int kantenLaengeTeilBlock;
    private Color linienFarbe;
    private Color fuellFarbe;

    public TeilBlock(int x, int y) {

	this.x = x;
	this.y = y;
	kantenLaengeTeilBlock = TetrisKonstanten.BLOCK_BREITE;

	Random r = new Random();

	fuellFarbe = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    @Override
    public void setLinienFarbe(Color farbe) {
	this.linienFarbe = farbe;
    }

    @Override
    public Color getFuellFarbe() {
	return fuellFarbe;
    }

    @Override
    public void setFuellFarbe(Color fuellFarbe) {
	this.fuellFarbe = fuellFarbe;
    }

    @Override
    public int getX() {
	return x;
    }

    @Override
    public void setX(int x) {
	this.x = x;
    }

    @Override
    public int getY() {
	return y;
    }

    @Override
    public void setY(int y) {
	this.y = y;
    }

    @Override
    public void zeichnen(Graphics graphics) {

	if (graphics == null)
	    return;

	if (linienFarbe != null)
	    graphics.setColor(linienFarbe);

	graphics.drawRect(x, y, kantenLaengeTeilBlock, kantenLaengeTeilBlock);

	graphics.setColor(fuellFarbe);

	graphics.fillRect(x + 1, y + 1, kantenLaengeTeilBlock - 1, kantenLaengeTeilBlock - 1);

    }

    @Override
    public int getHoechstesY() {
	return y;
    }

    @Override
    public int getTiefstesY() {
	return y + kantenLaengeTeilBlock;
    }

    @Override
    public int getKanteLinksX() {
	return x;
    }

    @Override
    public int getKanteRechtsX() {
	return x + kantenLaengeTeilBlock;
    }

    @Override
    public int compareTo(TetrominoSpielstein o) {
	return getX() - o.getX();
    }

    @Override
    public void bewegeNachUnten() {
	y += TetrisKonstanten.TETROMINO_FALL_HOEHE;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + x;
	result = prime * result + y;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TeilBlock other = (TeilBlock) obj;
	if (x != other.x)
	    return false;
	if (y != other.y)
	    return false;
	return true;
    }

    @Override
    public void bewegeNachRechts() {
	throw new IllegalStateException("Ein Teilblock darf nicht mehr bewegt werden!");
    }

    @Override
    public void bewegeNachLinks() {
	throw new IllegalStateException("Ein Teilblock darf nicht mehr bewegt werden!");
    }

    @Override
    public boolean faelltAuf(TetrominoSpielstein block) {
	throw new IllegalStateException("Ein Teilblock darf nicht mehr fallen!");
    }

    @Override
    public void rotiereNachLinks() {
	throw new IllegalStateException("Ein Teilblock darf nicht mehr rotiert werden!");
    }

    @Override
    public void rotiereNachRechts() {
	throw new IllegalStateException("Ein Teilblock darf nicht mehr rotiert werden!");
    }

    @Override
    public List<TetrominoSpielstein> getTeilBloecke() {
	throw new IllegalStateException("Ein Teilblock darf nicht mehr aufgeteilt werden!");
    }
}