package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoUmgedrehtesZ extends Tetromino {

    public TetrominoUmgedrehtesZ() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoUmgedrehtesZ(int x, int y) {

        teilBloecke.add(new TeilBlock(x, y));
        teilBloecke.add(new TeilBlock(x, y + TetrisKonstanten.BLOCK_BREITE));
        teilBloecke.add(new TeilBlock(x + TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE));
        teilBloecke.add(new TeilBlock(x + TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE * 2));
    }

}