package GameEngine;

import IconHandler.IconHandler;
import java.awt.*;
import javax.swing.*;

/**
 * Class Main
 *
 * <p>
 * Interaktives PC-Spiel Flappy Bird.
 * </p>
 *
 * <p>
 * Enthält Main Methode.
 * </p>
 *
 * @author SBalcke
 * @version 1.0
 * @since 03.06.2022
 *
 * @see javax.swing.JFrame
 */

public class Main extends JFrame {
    private static final int WIDTH = 920;
    private static final int HEIGHT = 920;

    /**
     * Konstruktor Main
     *
     * <p>
     * Erzeugt Instanz der Klasse Main
     * </p>
     *
     * <p>
     * Startmenü für den Spielstart, Sound- und Spieleinstellungen.
     * </p>
     */

    public Main() {

      // Frame Einstellungen (Titel, Größe, ohne Layout)
      super("Flappy Bird Startmenü");
      setSize(WIDTH, HEIGHT);
      setLayout(null);

      // IconHandler für Laden der Images
        IconHandler handler = new IconHandler();

      // JLabel Titel FlappyBird
      JLabel titleImg = new JLabel();
      titleImg.setIcon(handler.loadTitleImage());
      titleImg.setBounds(5, 5, 890, 270);
      add(titleImg);

      // Button Play
      JButton play = new JButton();
      play.setIcon(handler.loadPlayImage());
      play.setBounds(120, 390, 250, 150);

      // Lambda Ausdruck ActionListener → schließt Hauptmenü und startet Hauptspiel mit Flappy Bird Theme Musik
      play.addActionListener(e -> {this.dispose(); new FlappyBird(); SoundSettings.music("resources\\Flappy-Bird-Theme-Song.wav");});
      add(play);

      // Button Exit
      JButton exit = new JButton();
      exit.setIcon(handler.loadExitImage());
      exit.setBounds(520, 390, 250, 150);

      // Lambda Ausdruck ActionListener → beendet Programm auf Knopfdruck.
      exit.addActionListener(e -> System.exit(0));
      add(exit);

      // Button Options
      JButton options = new JButton();
      options.setIcon(handler.loadOptionsImage());
      options.setBounds(120, 690, 250, 150);

      // Lambda Ausdruck ActionListener → schließt Hauptmenü und öffnet Optionen
      options.addActionListener(e -> {dispose(); new GameSettings();});
      add(options);

      // Button Sounds
      JButton sounds = new JButton();
      sounds.setIcon(handler.loadSoundsImage());
      sounds.setBounds(520, 690, 250, 150);

      // Lambda Ausdruck ActionListener → schließt Hauptmenü und öffnet Soundeinstellungen
      sounds.addActionListener(e -> {dispose(); new SoundSettings();});
      add(sounds);

      // Frame Einstellungen (Icon, Hintergrund weiß, schließen bei rotem "x", zentriert, feste Größe, sichtbar)
      setIconImage(handler.loadBirdImage().getImage());
      getContentPane().setBackground(Color.WHITE);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      setVisible(true);
    }

    /**
     * Method main
     *
     * <p>
     * Main-Methode
     * </p>
     *
     * @param args an {@link java.lang.String} Array
     *                - contains Command line arguments
     */

    public static void main(String[] args) {

        new Main();
    }

}
