package com.hoffrogge.tetris.logik;

import com.hoffrogge.tetris.model.TetrisKonstanten;
import com.hoffrogge.tetris.model.TetrisMusikSpieler;
import com.hoffrogge.tetris.model.tetromino.TetrominoFactory;
import com.hoffrogge.tetris.model.tetromino.TetrominoSpielstein;
import com.hoffrogge.tetris.model.tetromino.TetrominoTyp;
import com.hoffrogge.tetris.view.Spielfeld;
import com.hoffrogge.tetris.view.Spielfenster;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spiel implements Runnable {

    /**
     * Eventtyp fuer ein {@link PropertyChangeEvent}, das ausgeloest wird, sobald
     * sich der Spielsteintyp aendert.
     */
    public static final String NAECHSTER_SPIELSTEIN_TYP = "naechsterSpielsteinTyp";

    private TetrominoFactory tetrominoFactory;
    private Spielfeld spielfeld;
    private Spielfenster spielfenster;

    private boolean spielLaeuft;
    private Thread spielThread;
    private Thread soundThread;

    private int level = 1;
    private int punkte = 0;
    private int highscore = 0;
    private int reihen = 0;
    private boolean isPause;
    private boolean isBeschleunigterFall;

    private TetrominoTyp naechsterSpielsteinTyp;
    private TetrominoSpielstein naechsterSpielstein;
    private TetrominoSpielstein fallenderSpielstein;
    private List<TetrominoSpielstein> gefalleneSteine;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Spiel(TetrominoFactory tetrominoFactory, Spielfeld spielfeld, Spielfenster spielfenster) {

        this.tetrominoFactory = tetrominoFactory;
        this.spielfeld = spielfeld;
        this.spielfenster = spielfenster;

        this.gefalleneSteine = new CopyOnWriteArrayList<>();

        this.spielfeld.setSpiel(this);
        this.spielLaeuft = true;
    }

    public void starteSpiel() {

        highscoreLaden();

        naechsterSpielsteinTyp = tetrominoFactory.erstelleZufaelligenTetrominoTyp();

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

            if (!isPause())
                aktualisiereSpiel();

            zeichneSpielfeld();

            if (istSpielfeldVoll()) {

                beendeSpiel();
                continue;
            }

            try {

                int spielBeschleuniger = (level - 1) * 50;

                int spielGeschwindigkeit = Math.max(TetrisKonstanten.SPIEL_GESCHWINDIGKEIT - spielBeschleuniger,
                        TetrisKonstanten.SPIEL_GESCHWINDIGKEIT_MIN);

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
     * Prueft, ob der Spielstein in das aktuelle Spiel passt, das heisst, ob kein
     * anderer Stein oder eine Wand im Weg ist.
     */
    public boolean passtGedrehterSpielstein(TetrominoSpielstein spielstein) {
        // TODO falls kein Teilnehmer der Java AG es schafft
        /*
         * =============================================================================
         * EXTRAAUFGABE: Implementiere diese Methode.
         * =============================================================================
         */
        return true;
    }

    public void zeichneSpielfeld() {
        spielfeld.zeichnen();
    }

    private void aktualisiereSpiel() {

        loescheVolleReihen();

        if (fallenderSpielstein == null) {

            fallenderSpielstein = naechsterSpielstein;
            naechsterSpielstein = neuerZufaelligerSpielstein();
        }

        if (fallenderSpielstein != null) {

            fallenderSpielstein.bewegeNachUnten();

            if (hatFallenderSteinBodenErreicht() || faelltFallenderSteinAufAnderenStein()) {

                List<TetrominoSpielstein> teilBloecke = fallenderSpielstein.getTeilBloecke();

                if (teilBloecke != null)
                    getGefalleneSteine().addAll(teilBloecke);

                fallenderSpielstein = null;

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

    private TetrominoSpielstein neuerZufaelligerSpielstein() {

        TetrominoSpielstein tetromino = tetrominoFactory.erstelleTetromino(naechsterSpielsteinTyp);

        naechsterSpielsteinTyp = getNeachsterSpielsteinTyp();

        return tetromino;
    }

    private TetrominoTyp getNeachsterSpielsteinTyp() {

        TetrominoTyp vorherigerSpielsteinTyp = naechsterSpielsteinTyp;

        naechsterSpielsteinTyp = tetrominoFactory.erstelleZufaelligenTetrominoTyp();

        propertyChangeSupport.firePropertyChange(NAECHSTER_SPIELSTEIN_TYP, vorherigerSpielsteinTyp,
                naechsterSpielsteinTyp);

        return naechsterSpielsteinTyp;
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

            block.setFuellFarbe(new Color(255, 60, 255));
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

        /* Integer ist Y-Koordinate */
        Map<Integer, List<TetrominoSpielstein>> bloeckeProReihe = new HashMap<>();

        for (TetrominoSpielstein block : getGefalleneSteine()) {

            List<TetrominoSpielstein> blockListe = bloeckeProReihe.get(block.getY());

            if (blockListe == null)
                blockListe = new ArrayList<>();

            blockListe.add(block);

            bloeckeProReihe.put(block.getY(), blockListe);
        }

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
                Logger.getGlobal().log(Level.WARNING, "Highscore-Datei konnte nicht angelegt werden! " + e.getMessage(),
                        e);
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

    public void addObserver(PropertyChangeListener observer) {
        propertyChangeSupport.addPropertyChangeListener(observer);
    }
}