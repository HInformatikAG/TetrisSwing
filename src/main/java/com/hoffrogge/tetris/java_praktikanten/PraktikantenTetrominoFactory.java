package com.hoffrogge.tetris.java_praktikanten;

import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;

import java.util.List;
import java.util.Random;

public class PraktikantenTetrominoFactory implements TetrominoFactory {

    private static final List<TetrominoTyp> TYPEN  = List.of((TetrominoTyp.values()));
    private static final int                ANZAHL = TYPEN.size();
    private static final Random             ZUFALL = new Random();

    @Override
    public TetrominoTyp erstelleZufaelligenTetrominoTyp() {
        return TYPEN.get(ZUFALL.nextInt(ANZAHL));
    }

    @Override
    public TetrominoSpielstein erstelleTetromino(TetrominoTyp typ) {

        return new PraktikantenSpielstein();

//        return switch (typ) {
//            case BLOCK -> new TetrominoBlock();
//            case LANGER -> new TetrominoLanger();
//            case L -> new TetrominoL();
//            case UMGEDREHTES_L -> new TetrominoUmgedrehtesL();
//            case T -> new TetrominoT();
//            case Z -> new TetrominoZ();
//            case UMGEDREHTES_Z -> new TetrominoUmgedrehtesZ();
//        };
    }
}