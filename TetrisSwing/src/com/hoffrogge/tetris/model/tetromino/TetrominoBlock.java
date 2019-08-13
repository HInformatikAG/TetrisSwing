package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoBlock extends Tetromino {

    private int kantenLaengeViertelBlock;

    public TetrominoBlock() {
        this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 2);
    }

    public TetrominoBlock(int x, int y) {

        durchmesser = TetrisKonstanten.BLOCK_BREITE * 2;
        kantenLaengeViertelBlock = durchmesser / 2;

        viertelBloecke.add(new ViertelBlock(x, y));
        viertelBloecke.add(new ViertelBlock(x + kantenLaengeViertelBlock, y));
        viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock));
        viertelBloecke.add(new ViertelBlock(x + kantenLaengeViertelBlock, y + kantenLaengeViertelBlock));

        for (TetrominoSpielstein block : viertelBloecke)
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