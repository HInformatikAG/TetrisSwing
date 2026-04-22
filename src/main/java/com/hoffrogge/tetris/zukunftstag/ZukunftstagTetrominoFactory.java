package com.hoffrogge.tetris.zukunftstag;

import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;

import java.util.List;
import java.util.Random;

public class ZukunftstagTetrominoFactory implements TetrominoFactory {

    private static final List<TetrominoTyp> TYPEN  = List.of((TetrominoTyp.values()));
    private static final int                ANZAHL = TYPEN.size();
    private static final Random             ZUFALL = new Random();

    @Override
    public TetrominoTyp erstelleZufaelligenTetrominoTyp() {
        return TYPEN.get(ZUFALL.nextInt(ANZAHL));
    }

    @Override
    public TetrominoSpielstein erstelleTetromino(TetrominoTyp typ) {
        return new TetrisSpielstein();
    }
}