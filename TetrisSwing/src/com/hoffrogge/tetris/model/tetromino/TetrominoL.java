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

        viertelBloecke.add(new ViertelBlock(x, y));
        viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock));
        viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock * 2));
        viertelBloecke.add(new ViertelBlock(x + kantenLaengeViertelBlock, y + kantenLaengeViertelBlock * 2));
    }
}