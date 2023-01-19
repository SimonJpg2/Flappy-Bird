package GameEngine;

import IconHandler.IconHandler;
import javax.swing.*;

/**
 * Class Bird.java
 *
 * <p>
 * Klasse für den Vogel, welcher den Rohren ausweichen muss.
 * </p>
 *
 * @author SBalcke
 * @version 1.0
 * @since 16.06.2022
 *
 * @see javax.swing.JLabel
 */

public class Bird extends JLabel {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    /**
     *  Constructor Bird
     *
     *  <p>
     *  Erzeugt Instanz der Klasse Bird
     *  </p>
     *
     *  <p>
     *  JLabel mit Flappy Bird image als Spielfigur
     *  </p>
     *
     * @param x an integer
     *          Legt die Koordinate des Vogels auf der x-achse fest.
     * @param y an integer
     *          Legt die Koordinate des Vogels auf der y-achse fest.
     */
    public Bird(int x, int y) {

        IconHandler handler = new IconHandler();

        setIcon(handler.loadBirdPlayImage());
        setBounds(x, y, WIDTH, HEIGHT);
    }

    /**
     * Method jump
     *
     * <p>
     * Verschiebt das {@link javax.swing.JLabel} entlang der y-achse um 15px nach oben.
     * </p>
     *
     * @param bird a {@link javax.swing.JLabel}
     *             Flappy Bird Vogel.
     */

    public void jump(JLabel bird) {
    
      //verhindern, dass der Vogel aus dem Bild springt
      if (bird.getLocation().getY() + 50.0 < 65.0) {
      
        return;  
      }
      bird.setLocation((int) bird.getLocation().getX(), (int) (bird.getLocation().getY() - 25.0));
    }

}
