package com.hoffrogge.tetris.model.tetromino;

import com.hoffrogge.tetris.model.TetrisKonstanten;

public class TetrominoUmgedrehtesL extends Tetromino {

	private int kantenLaengeViertelBlock;

	public TetrominoUmgedrehtesL() {
		this(TetrisKonstanten.SPIELFELD_BREITE / 2, -TetrisKonstanten.BLOCK_BREITE * 4);
	}

	public TetrominoUmgedrehtesL(int x, int y) {

		this.x = x;
		this.y = y;

		durchmesser = TetrisKonstanten.BLOCK_BREITE;
		kantenLaengeViertelBlock = durchmesser;

		viertelBloecke.add(new ViertelBlock(x, y));
		viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock));
		viertelBloecke.add(new ViertelBlock(x, y + kantenLaengeViertelBlock * 2));
		viertelBloecke.add(new ViertelBlock(x - kantenLaengeViertelBlock, y + kantenLaengeViertelBlock * 2));
	}

}