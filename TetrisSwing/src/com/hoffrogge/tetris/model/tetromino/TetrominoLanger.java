package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoLanger extends Tetromino {

    private int kantenLaengeTeilBlock;

    public TetrominoLanger() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoLanger(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE;
        kantenLaengeTeilBlock = durchmesser;

        teilBloecke.add(new TeilBlock(x, y));
        teilBloecke.add(new TeilBlock(x, y + kantenLaengeTeilBlock));
        teilBloecke.add(new TeilBlock(x, y + kantenLaengeTeilBlock * 2));
        teilBloecke.add(new TeilBlock(x, y + kantenLaengeTeilBlock * 3));
    }

    @Override
    public void rotiereNachLinks() {

        if (teilBloecke.size() != 4)
            throw new IllegalStateException("Der Tetromino hat keine vier Bloecke!");

        TetrominoSpielstein ersterBlock = teilBloecke.get(0);
        TetrominoSpielstein dritterBlock = teilBloecke.get(2);
        TetrominoSpielstein vierterBlock = teilBloecke.get(3);

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