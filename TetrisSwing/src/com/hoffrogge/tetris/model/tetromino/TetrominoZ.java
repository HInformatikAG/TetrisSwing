package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoZ extends Tetromino {

    public TetrominoZ() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoZ(int x, int y) {

        this.x = x;
        this.y = y;

        viertelBloecke.add(new ViertelBlock(x, y));
        viertelBloecke.add(new ViertelBlock(x, y + TetrisKonstanten.BLOCK_BREITE));
        viertelBloecke.add(new ViertelBlock(x - TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE));
        viertelBloecke.add(new ViertelBlock(x - TetrisKonstanten.BLOCK_BREITE, y + TetrisKonstanten.BLOCK_BREITE * 2));
    }

}