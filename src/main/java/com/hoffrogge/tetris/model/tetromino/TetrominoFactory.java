package com.hoffrogge.tetris.model.tetromino;

/**
 * Diese Fabrik erstellt die Tetrisspielsteine, Tetrominos genannt.
 */
public interface TetrominoFactory {

    /**
     * Erstellt den {@link TetrominoTyp} eines {@link TetrominoSpielstein}s,
     * also ob es ein L, ein Block etc. ist. Erstellt noch nicht den Spielstein
     * selbst.
     * 
     * @return {@link TetrominoTyp}
     */
    TetrominoTyp erstelleZufaelligenTetrominoTyp();

    /**
     * Erstellt einen Tetromino-Spielstein mit dem Typ, der als Parameter
     * angegeben ist.
     * 
     * @param tetrominoTyp
     *            {@link TetrominoTyp}
     * @return neue Instanz von {@link TetrominoSpielstein}
     */
    TetrominoSpielstein erstelleTetromino(TetrominoTyp tetrominoTyp);

}