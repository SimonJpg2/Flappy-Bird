package GameEngine;

import IconHandler.IconHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Class ScoreBoard
 *
 * <p>
 * Punkteanzeige am Ende des Spieles
 * </p>
 *
 * @version 1.0
 * @since 27.06.2022
 * @author SBalcke
 *
 * @see javax.swing.JFrame
 */

public class ScoreBoard extends JFrame {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 980;

    /**
     * Constructor ScoreBoard
     *
     * <p>
     * Erzeugt Instanz der Klasse ScoreBoard
     * </p>
     *
     * @param punkte a {@link java.lang.Integer}
     *               - Erreichten Punkte
     */
    public ScoreBoard(int punkte) {

        // Frame Einstellungen (Titel, Größe, ohne Layout)
        super("Flappy Bird Scoreboard");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        IconHandler handler = new IconHandler();

        // JLabel background
        JLabel background = new JLabel();
        background.setIcon(handler.loadBackgroundImage());
        add(background);

        // JLabel gameOver
        JLabel gameOver = new JLabel();
        gameOver.setIcon(handler.loadGameOverImage());
        gameOver.setBounds(25, 100, 540, 140);
        background.add(gameOver);

        // JLabel punkteLabel
        JLabel punkteLabel = new JLabel();
        punkteLabel.setText("Erreichte Punkte: " + punkte);
        punkteLabel.setBounds(250, 220, 250, 100);
        background.add(punkteLabel);

        //JButton exit
        JButton exit = new JButton();
        exit.setIcon(handler.loadExitImage());
        exit.setBounds(200, 420, 250, 150);

        // Lambda Ausdruck ActionListener → beendet das Programm.
        exit.addActionListener(e -> System.exit(0));
        background.add(exit);

        // Frame Einstellungen (Icon, schließen bei rotem "x", zentriert, feste Größe, sichtbar)
        setIconImage(handler.loadBirdImage().getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}
