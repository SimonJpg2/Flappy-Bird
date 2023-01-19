package GameEngine;

import IconHandler.IconHandler;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Class SoundSettings
 *
 * <p>
 * Sound Einstellungen
 * </p>
 *
 * @version 1.0
 * @since 01.07.2022
 * @author SBalcke
 *
 * @see javax.swing.JFrame
 */

public class SoundSettings extends JFrame {

    private static boolean isPlaying = true;
    private static Thread musicPlayer;
    private final JButton changeSoundStatus;
    private final IconHandler handler;

    /**
     * Constructor SoundSettings
     *
     * <p>
     * Erzeugt Instanz der Klasse SoundSettings
     * </p>
     */

    public SoundSettings() {

        super("Flappy Bird Soundeinstellungen");
        setSize(640, 980);
        setLayout(new BorderLayout());

        handler = new IconHandler();

        // JLabel background
        JLabel background = new JLabel();
        background.setIcon(handler.loadBackgroundImage());
        add(background);

        // JButton changeSoundStatus
        changeSoundStatus = new JButton();
        changeSoundStatus.setIcon(handler.loadSoundOnImage());
        changeSoundStatus.setBounds(240, 100, 100, 100);

        // Lambda Ausdruck ActionListener → verändert die Icons und den Soundstatus
        changeSoundStatus.addActionListener(e -> {changeIcons(); changePlayingStatus();});
        background.add(changeSoundStatus);

        //JButton back
        JButton back = new JButton();
        back.setIcon(handler.loadBackImage());
        back.setBounds(200, 420, 250, 150);

        // Lambda Ausdruck ActionListener → schließt Spieleinstellungen und öffnet das Hauptmenü
        back.addActionListener(e -> {dispose(); new Main();});
        background.add(back);

        // Frame Einstellungen (Icon, schließen bei rotem "x", zentriert, feste Größe, sichtbar)
        setIconImage(handler.loadBirdImage().getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Method changeIcons
     *
     * <p>
     * verändert die Icons des JButtons changeSoundStatus
     * </p>
     */

    public void changeIcons() {

        if (isPlaying) {

            changeSoundStatus.setIcon(handler.loadSoundOnImage());
        }

        else {

            changeSoundStatus.setIcon(handler.loadSoundOffImage());
        }

    }

    /**
     * Method music
     *
     * <p>
     * Spielt den mitgegebenen Track in Dauerschleife
     * </p>
     *
     * @param track a {@link java.lang.String}
     *              - der zu spielende Track in .wav Format
     *
     * @see java.lang.Thread
     */
    public static synchronized void music(String track) {

        final String trackName = track;

        // Lambda Ausdruck für run Methode aus Runnable Interface
        musicPlayer = new Thread(() -> {

            while (!musicPlayer.isInterrupted() && isPlaying) {

                try {

                    // Öffnet den Clip via AudioInputStream (nur im .wav Format möglich)
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(new File(trackName)));

                    // Dauerhaft den Clip abspielen
                    clip.loop(clip.LOOP_CONTINUOUSLY);

                    // Thread so lange unterbrechen, bis der Clip zuende ist, um ihn erneut abzuspielen.

                                // Umrechnung Micro in Milli
                    Thread.sleep(clip.getMicrosecondLength() / 1000);
                }

                // Abfangen der möglichen Exceptions von getClip
                catch (LineUnavailableException
                       | SecurityException
                       | IllegalArgumentException
                       | UnsupportedAudioFileException
                       | IOException
                       | InterruptedException e) {
                    e.printStackTrace();
                }

            }

        });
        musicPlayer.start();
    }

    /**
     * Method changePlayingStatus
     *
     * <p>
     * verändert booleschen Ausdruck isPlaying
     * </p>
     */

    public static void changePlayingStatus() {

        isPlaying = !isPlaying;
    }

}
