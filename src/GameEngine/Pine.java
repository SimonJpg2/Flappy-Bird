package GameEngine;

import IconHandler.IconHandler;
import javax.swing.*;

/**
 * Class Pine
 *
 * <p>
 * Klasse für die Röhren als Hindernisse
 * </p>
 *
 * @version 1.0
 * @author SBalcke
 * @since 21.06.2022
 *
 * @see javax.swing.JLabel
 */

public class Pine extends JLabel {

  /**
   * Constructor Pine
   *
   * <p>
   * Erzeugt Instanz der Klasse Pine
   * </p>
   *
   * <p>
   * Röhre als Hindernis
   * </p>
   *
   * @see javax.swing.JLabel
   * @param x an {@link java.lang.Integer}
   *          Position x-achse
   * @param y an {@link java.lang.Integer}
   *          Position y-achse
   * @param pineNum an {@link java.lang.Integer}
   *                1 = Röhre Öffnung oben
   *                2 = Röhre Öffnung unten
   */
  public Pine(int x, int y, int pineNum) {
    
    IconHandler handler = new IconHandler();
    
    if (pineNum == 1) {
      
      setIcon(handler.loadPineUpImage());
    } // end of if
    
    else {
      
      setIcon(handler.loadPineDownImage());
    } // end of if-else
    
    setBounds(x, y, 50, 340);
  }
  
} // end of class Pine
