package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoT extends Tetromino {

    public TetrominoT() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 2);
    }

    public TetrominoT(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE * 3;

        viertelBloecke.add(new TeilBlock(x, y));
        viertelBloecke.add(new TeilBlock(x, y + TetrisKonstanten.BLOCK_BREITE));
        viertelBloecke.add(new TeilBlock(x - TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE));
        viertelBloecke.add(new TeilBlock(x + TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE));
    }

}