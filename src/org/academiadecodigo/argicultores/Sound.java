package org.academiadecodigo.argicultores;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Sound {
    private Clip clip;

    public Sound(String path) {
        initClip(path);
    }

    public void play(boolean fromStart) {
        if (fromStart) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void setLoop(int times) {
        clip.loop(times);
    }
    private void initClip(String path) {

        URL soundURL = getClass().getClassLoader().getResource(path);
        AudioInputStream inputStream;
        try {
            if (soundURL == null) {
                File file = new File(path);
                soundURL = file.toURI().toURL();
            }
            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
