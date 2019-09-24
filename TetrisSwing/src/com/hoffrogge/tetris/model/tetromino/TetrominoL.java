package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoL extends Tetromino {

    private int kantenLaengeViertelBlock;

    public TetrominoL() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoL(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE;
        kantenLaengeViertelBlock = durchmesser;

        viertelBloecke.add(new TeilBlock(x, y));
        viertelBloecke.add(new TeilBlock(x, y + kantenLaengeViertelBlock));
        viertelBloecke.add(new TeilBlock(x, y + kantenLaengeViertelBlock * 2));
        viertelBloecke.add(new TeilBlock(x + kantenLaengeViertelBlock, y + kantenLaengeViertelBlock * 2));
    }
}