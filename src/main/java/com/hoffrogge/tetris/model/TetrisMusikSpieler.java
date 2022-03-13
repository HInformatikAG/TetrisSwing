package com.hoffrogge.tetris.model;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TetrisMusikSpieler implements Runnable {

    @Override
    public void run() {

        ClassLoader classLoader = getClass().getClassLoader();
        /* Lizenz: https://creativecommons.org/licenses/by-nc-sa/3.0/ */
        InputStream midiStream = getClass().getResourceAsStream("Tetris_-_Theme_A_by_Gori_Fater.mid");

        try (AudioInputStream ais = AudioSystem.getAudioInputStream(midiStream)) {

            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Integer.MAX_VALUE);

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            Logger.getGlobal().log(Level.WARNING, e.getMessage(), e);
        }
    }
}