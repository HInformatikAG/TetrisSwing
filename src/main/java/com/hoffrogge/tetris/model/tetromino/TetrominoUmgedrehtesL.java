package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoUmgedrehtesL extends Tetromino {

    private int kantenLaengeTeilBlock;

    public TetrominoUmgedrehtesL() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
    }

    public TetrominoUmgedrehtesL(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE;
        kantenLaengeTeilBlock = durchmesser;

        teilBloecke.add(new TeilBlock(x, y));
        teilBloecke.add(new TeilBlock(x, y + kantenLaengeTeilBlock));
        teilBloecke.add(new TeilBlock(x, y + kantenLaengeTeilBlock * 2));
        teilBloecke.add(new TeilBlock(x - kantenLaengeTeilBlock, y + kantenLaengeTeilBlock * 2));
    }
}