package com.hoffrogge.tetris.logik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hoffrogge.tetris.model.Farbe;
import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.TetrisMusikSpieler;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;
import com.hoffrogge.tetris.view.Spielfeld;
import com.hoffrogge.tetris.view.Spielfenster;
import com.hoffrogge.tetris.view.Vorschau;

public class Spiel implements Runnable {

    private TetrominoFactory          tetrominoFactory;
    private Spielfeld                 spielfeld;
    private Vorschau                  vorschau;
    private Spielfenster              spielfenster;

    private boolean                   spielLaeuft;
    private Thread                    spielThread;
    private Thread                    soundThread;

    private int                       level     = 1;
    private int                       punkte    = 0;
    private int                       highscore = 0;
    private int                       reihen    = 0;
    private boolean                   isPause;
    private boolean                   isBeschleunigterFall;

    private TetrominoTyp              naechsterSpielsteinTyp;
    private TetrominoSpielstein       fallenderSpielstein;
    private List<TetrominoSpielstein> gefalleneSteine;

    public Spiel(TetrominoFactory tetrominoFactory, Spielfeld spielfeld, Spielfenster spielfenster, Vorschau vorschau) {

        this.tetrominoFactory = tetrominoFactory;
        this.spielfeld = spielfeld;
        this.vorschau = vorschau;
        this.spielfenster = spielfenster;

        this.naechsterSpielsteinTyp = tetrominoFactory.erstelleZufaelligenTetrominoTyp();
        this.gefalleneSteine = new CopyOnWriteArrayList<>();

        this.spielfeld.setSpiel(this);
        this.spielLaeuft = true;
    }

    public void starteSpiel() {

        highscoreLaden();
        bestimmeNaechstenFallendenSpielstein();

        spielThread = new Thread(this);
        spielThread.start();

        if (TetrisKonstanten.MUSIK_AN) {

            soundThread = new Thread(new TetrisMusikSpieler());
            soundThread.start();
        }
    }

    @Override
    public void run() {

        while (spielLaeuft) {

            aktualisierePunkteUndLevelUndReihen();

            if (!isPause()) {

                aktualisiereSpiel();
                vorschau.aktualisieren(naechsterSpielsteinTyp);
            }

            spielfeld.zeichnen();

            if (istSpielfeldVoll()) {

                beendeSpiel();
                continue;
            }

            try {

                int spielBeschleuniger = (level - 1) * 50;

                int spielGeschwindigkeit = Math.max(TetrisKonstanten.SPIEL_GESCHWINDIGKEIT - spielBeschleuniger, TetrisKonstanten.SPIEL_GESCHWINDIGKEIT_MIN);

                Thread.sleep(spielGeschwindigkeit);

            } catch (InterruptedException e) {
                Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
        }
    }

    public void aktualisiereSpielfeld() {
        aktualisiereSpiel();
    }

    public TetrominoSpielstein getFallenderSpielstein() {
        return fallenderSpielstein;
    }

    public List<TetrominoSpielstein> getGefalleneSteine() {
        return gefalleneSteine;
    }

    public boolean isBeschleunigterFall() {
        return isBeschleunigterFall;
    }

    public void setBeschleunigterFall(boolean isBeschleunigterFall) {
        this.isBeschleunigterFall = isBeschleunigterFall;
    }

    public boolean isPause() {
        return isPause;
    }

    public void togglePause() {
        isPause = !isPause;
    }

    public boolean istSpielfeldVoll() {

        for (TetrominoSpielstein gefallenerStein : getGefalleneSteine())
            if (gefallenerStein.getHoechstesY() <= TetrisKonstanten.SPIELFELD_X0)
                return true;

        return false;
    }

    /**
     * Prueft, ob der Spielstein in das aktuelle Spiel passt, das heisst, ob
     * kein anderer Stein oder eine Wand im Weg ist.
     */
    public boolean passtGedrehterSpielstein(TetrominoSpielstein spielstein) {
        // TODO Auto-generated method stub
        return true;
    }

    public void zeichneSpielfeld() {
        spielfeld.zeichnen();
    }

    private void aktualisiereSpiel() {

        loescheVolleReihen();

        TetrominoSpielstein fallenderSpielstein = getFallenderSpielstein();

        if (fallenderSpielstein != null) {

            fallenderSpielstein.bewegeNachUnten();

            if (hatFallenderSteinBodenErreicht() || faelltFallenderSteinAufAnderenStein()) {

                List<TetrominoSpielstein> viertelBloecke = fallenderSpielstein.getViertelBloecke();

                if (viertelBloecke != null)
                    getGefalleneSteine().addAll(viertelBloecke);

                bestimmeNaechstenFallendenSpielstein();

                erhoehePunkte();
            }
        }
    }

    private void aktualisierePunkteUndLevelUndReihen() {

        spielfenster.setLevel(String.valueOf(level));
        spielfenster.setPunkte(String.valueOf(punkte));
        spielfenster.setReihen(String.valueOf(reihen));

        highscore = Math.max(punkte, highscore);
        spielfenster.setHighscore(String.valueOf(highscore));
    }

    private void erhoehePunkte() {

        if (isBeschleunigterFall())
            punkte += level * 3 + 21;
        else
            punkte += level * 3 + 3;

        pruefeUndSetzeLevel();
    }

    private void erhoeheReihen() {
        reihen++;
    }

    private void bestimmeNaechstenFallendenSpielstein() {
        fallenderSpielstein = neuerZufaelligerSpielstein();
    }

    private TetrominoSpielstein neuerZufaelligerSpielstein() {

        TetrominoSpielstein tetromino = tetrominoFactory.erstelleTetromino(naechsterSpielsteinTyp);

        naechsterSpielsteinTyp = tetrominoFactory.erstelleZufaelligenTetrominoTyp();

        return tetromino;
    }

    private boolean faelltFallenderSteinAufAnderenStein() {

        if (getGefalleneSteine().isEmpty())
            return false;

        for (TetrominoSpielstein block : getGefalleneSteine())
            if (getFallenderSpielstein().faelltAuf(block))
                return true;

        return false;
    }

    private boolean hatFallenderSteinBodenErreicht() {
        return getFallenderSpielstein().getTiefstesY() >= TetrisKonstanten.SPIELFELD_HOEHE;
    }

    private void loescheReihe(List<TetrominoSpielstein> blockListe) {

        int hoehe = 0;

        for (TetrominoSpielstein block : blockListe) {

            block.setFuellFarbe(new Farbe(255, 60, 255));
            getGefalleneSteine().remove(block);
            hoehe = block.getY();
        }

        for (TetrominoSpielstein block : getGefalleneSteine())
            if (block.getY() < hoehe)
                block.bewegeNachUnten();

        erhoeheReihen();
    }

    private void loescheVolleReihen() {

        Collections.sort(getGefalleneSteine());

        Map<Integer, List<TetrominoSpielstein>> bloeckeProReihe = new HashMap<>();

        for (TetrominoSpielstein block : getGefalleneSteine()) {

            List<TetrominoSpielstein> blockListe = bloeckeProReihe.get(block.getY());

            if (blockListe == null)
                blockListe = new ArrayList<>();

            blockListe.add(block);

            bloeckeProReihe.put(block.getY(), blockListe);
        }

        // TODO hier wird implizit angenommen, das die blockListe aus
        // ViertelBloecken besteht, dass muss noch besser gekapselt werden
        for (Entry<Integer, List<TetrominoSpielstein>> reihe : bloeckeProReihe.entrySet()) {

            List<TetrominoSpielstein> blockListe = reihe.getValue();

            if (blockListe.size() == TetrisKonstanten.SPIELFELD_BREITE / TetrisKonstanten.BLOCK_BREITE)
                loescheReihe(blockListe);
        }
    }

    private void pruefeUndSetzeLevel() {

        if (reihen / level >= 10)
            level++;
    }

    private void highscoreLaden() {

        File highscoreCsv = new File("highscore.csv");

        if (!highscoreCsv.exists())
            return;

        try (BufferedReader br = new BufferedReader(new FileReader("highscore.csv"))) {

            String line = br.readLine();

            highscore = Integer.parseInt(line);

        } catch (FileNotFoundException e) {
            Logger.getGlobal().log(Level.WARNING, "Konnte Highscore-Datei nicht finden! " + e.getMessage(), e);
            e.printStackTrace();
        } catch (IOException | NumberFormatException e) {
            Logger.getGlobal().log(Level.WARNING, "Konnte Highscore nicht lesen! " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    private void highscoreSpeichern() {

        File highscoreCsv = new File("highscore.csv");

        if (!highscoreCsv.exists())
            try {
                highscoreCsv.createNewFile();
            } catch (IOException e) {
                Logger.getGlobal().log(Level.WARNING, "Highscore-Datei konnte nicht angelegt werden! " + e.getMessage(), e);
                e.printStackTrace();
            }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.csv"))) {

            int aktuellerHighscore = Math.max(punkte, highscore);
            String content = String.valueOf(aktuellerHighscore);

            bw.write(content);

        } catch (IOException e) {
            Logger.getGlobal().log(Level.WARNING, "Konnte Highscore nicht speichern! " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    private void beendeSpiel() {

        spielLaeuft = false;

        try {

            if (TetrisKonstanten.MUSIK_AN)
                soundThread.join();

        } catch (InterruptedException e) {
            Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
            Thread.currentThread().interrupt();
        }

        highscoreSpeichern();
    }
}