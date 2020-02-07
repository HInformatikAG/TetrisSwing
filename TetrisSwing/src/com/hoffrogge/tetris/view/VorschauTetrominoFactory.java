package com.hoffrogge.tetris.view;

import java.util.Objects;

import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.tetromino.TetrominoBlock;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoL;
import com.hoffrogge.tetris.model.tetromino.TetrominoLanger;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoT;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;
import com.hoffrogge.tetris.model.tetromino.TetrominoUmgedrehtesL;
import com.hoffrogge.tetris.model.tetromino.TetrominoUmgedrehtesZ;
import com.hoffrogge.tetris.model.tetromino.TetrominoZ;

public class VorschauTetrominoFactory implements TetrominoFactory {

    @Override
    public TetrominoTyp erstelleZufaelligenTetrominoTyp() {
	throw new UnsupportedOperationException("Diese Factory kann keinen Typ erstellen!");
    }

    @Override
    public TetrominoSpielstein erstelleTetromino(TetrominoTyp naechsterSpielsteinTyp) {

	Objects.requireNonNull(naechsterSpielsteinTyp);

	int xKoordinate = 0;
	int yKoordinate = 0;

	switch (naechsterSpielsteinTyp) {

	case BLOCK:
	    xKoordinate = (int) (TetrisKonstanten.BLOCK_BREITE * 1.5);
	    yKoordinate = TetrisKonstanten.BLOCK_BREITE * 2;
	    break;

	case L:
	case UMGEDREHTES_Z:
	    xKoordinate = (int) (TetrisKonstanten.BLOCK_BREITE * 1.5);
	    yKoordinate = (int) (TetrisKonstanten.BLOCK_BREITE * 1.5);
	    break;

	case UMGEDREHTES_L:
	    xKoordinate = (int) (TetrisKonstanten.BLOCK_BREITE * 2.5);
	    yKoordinate = TetrisKonstanten.BLOCK_BREITE;
	    break;

	case LANGER:
	    xKoordinate = TetrisKonstanten.BLOCK_BREITE * 2;
	    yKoordinate = TetrisKonstanten.BLOCK_BREITE;
	    break;

	case Z:
	    xKoordinate = (int) (TetrisKonstanten.BLOCK_BREITE * 2.5);
	    yKoordinate = (int) (TetrisKonstanten.BLOCK_BREITE * 1.5);
	    break;

	case T:
	    xKoordinate = TetrisKonstanten.BLOCK_BREITE * 2;
	    yKoordinate = TetrisKonstanten.BLOCK_BREITE * 2;
	    break;

	default:
	    throw new IllegalStateException("TetrominoTyp " + naechsterSpielsteinTyp + " ist nicht bekannt!");
	}

	switch (naechsterSpielsteinTyp) {

	case BLOCK:
	    return new TetrominoBlock(xKoordinate, yKoordinate);

	case LANGER:
	    return new TetrominoLanger(xKoordinate, yKoordinate);

	case L:
	    return new TetrominoL(xKoordinate, yKoordinate);

	case UMGEDREHTES_L:
	    return new TetrominoUmgedrehtesL(xKoordinate, yKoordinate);

	case T:
	    return new TetrominoT(xKoordinate, yKoordinate);

	case Z:
	    return new TetrominoZ(xKoordinate, yKoordinate);

	case UMGEDREHTES_Z:
	    return new TetrominoUmgedrehtesZ(xKoordinate, yKoordinate);

	default:
	    throw new IllegalStateException("TetrominoTyp " + naechsterSpielsteinTyp + " ist nicht bekannt!");
	}
    }
}