package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoZ extends Tetromino {

    public TetrominoZ() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoZ(int x, int y) {

        viertelBloecke.add(new TeilBlock(x, y));
        viertelBloecke.add(new TeilBlock(x, y + TetrisKonstanten.BLOCK_BREITE));
        viertelBloecke.add(new TeilBlock(x - TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE));
        viertelBloecke.add(new TeilBlock(x - TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE * 2));
    }

}