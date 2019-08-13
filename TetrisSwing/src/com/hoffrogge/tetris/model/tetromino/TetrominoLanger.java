package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoLanger extends Tetromino {

    private int kantenLaengeViertelBlock;

    public TetrominoLanger() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoLanger(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE;
        kantenLaengeViertelBlock = durchmesser;

        viertelBloecke.add(new ViertelBlock(x, y));
        viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock));
        viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock * 2));
        viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock * 3));
    }

    @Override
    public void rotiereNachLinks() {

        if (viertelBloecke.size() != 4)
            throw new IllegalStateException("Der Tetromino hat keine vier Bloecke!");

        TetrominoSpielstein ersterBlock = viertelBloecke.get(0);
        TetrominoSpielstein dritterBlock = viertelBloecke.get(2);
        TetrominoSpielstein vierterBlock = viertelBloecke.get(3);

        boolean senkrecht = ersterBlock.getX() == vierterBlock.getX();

        if (senkrecht) {

            ersterBlock.setX(ersterBlock.getX() - TetrisKonstanten.BLOCK_BREITE);
            ersterBlock.setY(ersterBlock.getY() + TetrisKonstanten.BLOCK_BREITE);

            dritterBlock.setX(dritterBlock.getX() + TetrisKonstanten.BLOCK_BREITE);
            dritterBlock.setY(dritterBlock.getY() - TetrisKonstanten.BLOCK_BREITE);

            vierterBlock.setX(vierterBlock.getX() + TetrisKonstanten.BLOCK_BREITE * 2);
            vierterBlock.setY(vierterBlock.getY() - TetrisKonstanten.BLOCK_BREITE * 2);

        } else {

            ersterBlock.setX(ersterBlock.getX() + TetrisKonstanten.BLOCK_BREITE);
            ersterBlock.setY(ersterBlock.getY() - TetrisKonstanten.BLOCK_BREITE);

            dritterBlock.setX(dritterBlock.getX() - TetrisKonstanten.BLOCK_BREITE);
            dritterBlock.setY(dritterBlock.getY() + TetrisKonstanten.BLOCK_BREITE);

            vierterBlock.setX(vierterBlock.getX() - TetrisKonstanten.BLOCK_BREITE * 2);
            vierterBlock.setY(vierterBlock.getY() + TetrisKonstanten.BLOCK_BREITE * 2);

        }
    }
}