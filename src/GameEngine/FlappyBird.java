package GameEngine;

import IconHandler.IconHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Runnable;
import java.lang.Thread;

/**
 * Class FlappyBird.java
 *
 * <p>
 * Klasse für Grundfunktionalität des PC-Spieles mit grafischer Oberfläche.
 * </p>
 *
 * @author SBalcke
 * @version 1.0
 * @since 15.06.2022
 *
 * @see javax.swing.JFrame
 * @see java.awt.event.KeyListener
 * @see java.lang.Runnable
 * @see java.lang.Thread
 *
 */

public class FlappyBird extends JFrame implements KeyListener, Runnable {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 980;
    private static final int BIRD_START_X = 140;
    private static final int BIRD_START_Y = 390;
    private static boolean GAME_RUNNING = false;
    private static boolean GAMEOVER = false;
    private Thread thread1;
    private final Bird bird;
    private final Pine pine_up;
    private final Pine pine_up2;
    private final Pine pine_down;
    private final Pine pine_down2;
    private JLabel get_ready;

    /**
     * Constructor FlappyBird
     *
     * <p>
     * Erzeugt Instanz der Klasse FlappyBird
     * </p>
     *
     * <p>
     * Erzeugt Hauptspiel FlappyBird mit GUI
     * </p>
     */

    public FlappyBird() {

        // Frame Einstellungen (Titel, Größe, ohne Layout)
        super("Flappy Bird");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        IconHandler handler = new IconHandler();

        // JLabel background
        JLabel background = new JLabel();
        background.setIcon(handler.loadBackgroundImage());
        add(background);

        // JLabel bird
        bird = new Bird(BIRD_START_X, BIRD_START_Y);
        background.add(bird);

        // JLabel get_Ready
        get_ready = new JLabel();
        get_ready.setIcon(handler.loadGetReadyImage());
        get_ready.setBounds(50, 100, 540, 140);
        background.add(get_ready);
    
        // JLabel pine_up
        pine_up = new Pine(450, 430, 1);
        background.add(pine_up);
        
        //JLabel pine_down
        pine_down = new Pine(450, 0, 2);
        pine_down.setVisible(false);
        background.add(pine_down);

        // JLabel pine_up2
        pine_up2 = new Pine(900, 430, 1);
        background.add(pine_up2);

        // JLabel pine_down2
        pine_down2 = new Pine(900, 0, 2);
        background.add(pine_down2);

        // KeyListener für Jumpbewegung
        this.addKeyListener(this);
    
        // Frame Einstellungen (Icon, schließen bei rotem "x", zentriert, feste Größe, sichtbar)
        setIconImage(handler.loadBirdImage().getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Method start
     *
     * <p>
     * Vorbereitungen für den Spielstart
     *             - Anzeige entfernen
     *             - Bewegungen einleiten
     * </p>
     */
    public void start() {

        GAME_RUNNING = true;
        get_ready.setVisible(false);
        get_ready = null;
        pine_down.setVisible(true);
        velocity();
    }

    /**
     * Method velocity
     *
     * <p>
     * Startet neuen Thread
     * </p>
     *
     * @see java.lang.Thread
     */
    public void velocity() {

        thread1 = new Thread(this);
        thread1.start();
    }

    /**
     * Method gameOver
     *
     * <p>
     * Anzeige JLabel GameOver
     * </p>
     *
     * <p>
     * Cleanup - beendet Thread
     * </p>
     */
    public void gameOver(int punkte) {

        GAMEOVER = true;
        dispose();
        new ScoreBoard(punkte);
        thread1.interrupt();
    }

    /**
     * Method run
     *
     * <p>
     * Verschiebung Vogel nach unten, Röhren nach links
     * </p>
     *
     * @see java.lang.Runnable
     */

    @Override
    public void run() {

        int punkte = 0;

        while (GAME_RUNNING && !thread1.isInterrupted()) {

            // Zurücksetzen der Röhren, sobald diese aus dem Bildschirm sind
            if (pine_down.getLocation().getX() < -52) {

                punkte++;
                pine_down.setLocation(900, 0);
                pine_up.setLocation(900, 430);
            }

            if (pine_down2.getLocation().getX() < -52) {

                punkte++;
                pine_down2.setLocation(900, 0);
                pine_up2.setLocation(900, 430);
            }

            // Abbruch aufprall auf dem Boden
            if (bird.getLocation().getY() > 720) {

                GAME_RUNNING = false;
                gameOver(punkte);
                return;
            }

            // Abbruch Kontakt Röhre 1 oben
            if ((pine_down.getLocation().getX() > 140 && pine_down.getLocation().getX() < 190) && (bird.getLocation().getY() < pine_down.getLocation().getY() + 340)) {

                GAME_RUNNING = false;
                gameOver(punkte);
                return;
            }

            // Abbruch Kontakt Röhre 1 unten
            if ((pine_up.getLocation().getX() > 140 && pine_up.getLocation().getX() < 190.0) && (bird.getLocation().getY() > pine_up.getLocation().getY())) {

                GAME_RUNNING = false;
                gameOver(punkte);
                return;
            }

            // Abbruch Kontakt Röhre 2 oben
            if ((pine_down2.getLocation().getX() > 140 && pine_down2.getLocation().getX() < 190) && (bird.getLocation().getY() < pine_down2.getLocation().getY() + 340)) {

                GAME_RUNNING = false;
                gameOver(punkte);
                return;
            }

            // Abbruch Kontakt Röhre 2 unten
            if ((pine_up2.getLocation().getX() > 140 && pine_up2.getLocation().getX() < 190.0) && (bird.getLocation().getY() > pine_up2.getLocation().getY())) {

                GAME_RUNNING = false;
                gameOver(punkte);
                return;
            }

            // Verschiebung Vogel 2 Pixel nach unten
            bird.setLocation((int) bird.getLocation().getX(), (int) bird.getLocation().getY() + 2);

            // Verschiebung Röhre 1 oben und unten 2 Pixel nach links
            pine_up.setLocation((int) pine_up.getLocation().getX() - 2, (int) pine_up.getLocation().getY());
            pine_down.setLocation((int) pine_down.getLocation().getX() - 2, (int) pine_down.getLocation().getY());

            // Verschiebung Röhre 2 oben und unten 2 Pixel nach links
            pine_up2.setLocation((int) pine_up2.getLocation().getX() - 2, (int) pine_up2.getLocation().getY());
            pine_down2.setLocation((int) pine_down2.getLocation().getX() - 2, (int) pine_down2.getLocation().getY());

            // Unterbrechung 25 Millisekunden
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } // end of try

        } // end of while

    }

    /**
     * Method keyPressed
     *
     * <p>
     * Ausführung des Codes bei erfolgtem KeyEvent.
     * </p>
     *
     * @see java.awt.event.KeyListener
     * @param e the event to be processed
     */

    @Override
    public void keyPressed(KeyEvent e) {

        if (GAME_RUNNING) {

            // KeyCode 38 entspricht Pfeiltaste nach oben
            if (e.getKeyCode() == 38) {

                bird.jump(bird);
            }

        }

        if (!GAMEOVER && !GAME_RUNNING && e.getKeyCode() == 38) {

            start();
        }

    }

    // Wird nicht verwendet, jedoch für Runnable Interface vonnöten
    @Override
    public void keyReleased(KeyEvent e) {}
  
    // Wird nicht verwendet, jedoch für Runnable Interface vonnöten
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
