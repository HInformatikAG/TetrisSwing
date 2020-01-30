package com.hoffrogge.tetris.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//FIXME funktioniert nicht auf allen Platformen
public class TetrisMusikSpieler implements Runnable {

    @Override
    public void run() {

        ClassLoader classLoader = getClass().getClassLoader();
        /* Lizenz: https://creativecommons.org/licenses/by-nc-sa/3.0/ */
        InputStream midiStream = classLoader.getResourceAsStream("Tetris_-_Theme_A_by_Gori_Fater.mid");

        try (AudioInputStream ais = AudioSystem.getAudioInputStream(midiStream)) {

            Clip clip = AudioSystem.getClip();
            clip.open(ais);

            clip.start();

        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            Logger.getGlobal().log(Level.WARNING, e.getMessage(), e);
        }
    }
}