package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoBlock extends Tetromino {

    private int kantenLaengeTeilBlock;

    public TetrominoBlock() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 2);
    }

    public TetrominoBlock(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE * 2;
        kantenLaengeTeilBlock = durchmesser / 2;

        teilBloecke.add(new TeilBlock(x, y));
        teilBloecke.add(new TeilBlock(x + kantenLaengeTeilBlock, y));
        teilBloecke.add(new TeilBlock(x, y + kantenLaengeTeilBlock));
        teilBloecke.add(new TeilBlock(x + kantenLaengeTeilBlock, y + kantenLaengeTeilBlock));

        for (TetrominoSpielstein block : teilBloecke)
            block.setFuellFarbe(TetrisKonstanten.TETROMINO_FARBE_BLOCK);
    }

    @Override
    public void rotiereNachLinks() {
        /* Ein Block muss nicht rotiert werden */
    }

    @Override
    public void rotiereNachRechts() {
        /* Ein Block muss nicht rotiert werden */
    }
}