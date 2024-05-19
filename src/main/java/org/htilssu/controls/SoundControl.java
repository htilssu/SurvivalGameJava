package org.htilssu.controls;

import org.htilssu.utils.Assets;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class SoundControl {
    static AudioInputStream currentAudio;
    static Clip currentClip;

    static {
        try {
            currentClip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void playAudio() {
        // Play audio
        if (currentAudio == null) return;
        try {
            if (!currentClip.isRunning()) {
                currentClip.open(currentAudio);
                currentClip.start();
            }
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isPlaying() {
        return currentClip.isRunning();
    }

    public static void setAudio(String audioUrl) {
        // Set audio
        try {
            if (currentAudio != null) currentAudio.close();
            currentAudio = Assets.loadAudio(audioUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopAudio() {
        // Stop audio
        if (currentClip.isRunning()) {
            currentClip.close();
        }
    }
}
