package GameEngine;

import IconHandler.IconHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Class GameSettings
 *
 * <p>
 * Klasse für die Spieloptionen.
 * </p>
 *
 * @since 28.06.2022
 * @author SBalcke
 * @version 1.0
 *
 * @see javax.swing.JFrame
 */
public class GameSettings extends JFrame {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 980;

    /**
     * Constructor GameSettings
     *
     * <p>
     * Erzeugt Instanz der Klasse GameSettings
     * </p>
     *
     * <p>
     * Erzeugt ein neues JFrame
     * </p>
     */
    public GameSettings() {

        // Frame Einstellungen (Titel, Größe, ohne Layout)
        super("Flappy Bird Settings");
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());

        IconHandler handler = new IconHandler();

        // JLabel background
        JLabel background = new JLabel();
        background.setIcon(handler.loadBackgroundImage());
        add(background);

        // JLabel jump
        JLabel jump = new JLabel();
        jump.setIcon(handler.loadJumpImage());
        jump.setBounds(50, 150, 200, 100);
        background.add(jump);

        // JLabel arrow_key
        JLabel arrow_key = new JLabel();
        arrow_key.setIcon(handler.loadArrowImage());
        arrow_key.setBounds(400, 150, 100, 100);
        background.add(arrow_key);

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

}
