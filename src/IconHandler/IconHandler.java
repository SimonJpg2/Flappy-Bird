package IconHandler;

import javax.swing.*;
import java.net.URL;

/**
 * Class IconHandler
 *
 * <p>
 * Lädt Images aus dem resources Ordner.
 * </p>
 *
 * @since 13.06.2022
 * @author SBalcke
 * @version 1.0
 *
 */

public class IconHandler {

    private ImageIcon image;
    private URL path;

    /**
     * Method loadTitleImage.
     *
     * <p>
     *     gets Title.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadTitleImage() {

        try {
            path = getClass().getResource("resources\\Title.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
      return image;
    }

    /**
     * Method loadSoundsImage.
     *
     * <p>
     *     gets Sounds.jpg image from resource folder.
     * </p>
     *
     * @throws  NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadSoundsImage() {

        try {
            path = getClass().getResource("resources\\Sounds.jpg");
            image = new ImageIcon(path);
        }

        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadPlayImage.
     *
     * <p>
     *     gets Play.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */


    public ImageIcon loadPlayImage() {

        try {
            path = getClass().getResource("resources\\Play.jpg");
            image = new ImageIcon(path);
        }

        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadOptionsImage.
     *
     * <p>
     *     gets Options.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */


    public ImageIcon loadOptionsImage() {

        try {
            path = getClass().getResource("resources\\Options.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadExitImage.
     *
     * <p>
     *     gets Exit.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */


    public ImageIcon loadExitImage() {

        try {
            path = getClass().getResource("resources\\Exit.png");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadBirdImage.
     *
     * <p>
     *     gets Bird.png image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadBirdImage() {

        try {
            path = getClass().getResource("resources\\Bird.png");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadBirdPlayImage.
     *
     * <p>
     *     gets Bird_play.png image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadBirdPlayImage() {

        try {
            path = getClass().getResource("resources\\Bird_play.png");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadBackgroundImage.
     *
     * <p>
     *     gets Background.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadBackgroundImage() {

        try {
            path = getClass().getResource("resources\\Background.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadGetReadyImage.
     *
     * <p>
     *     gets getReady.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadGetReadyImage() {

        try {
            path = getClass().getResource("resources\\getReady.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }
  
    /**
     * Method loadPineUpImage.
     *
     * <p>
     *     gets pine_UP.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */
  
    public ImageIcon loadPineUpImage() {

        try {
            path = getClass().getResource("resources\\pine_UP.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }
  
    /**
     * Method loadPineDownImage.
     *
     * <p>
     *     gets pine_DOWN.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */
  
    public ImageIcon loadPineDownImage() {

        try {
            path = getClass().getResource("resources\\pine_DOWN.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadGameOverImage.
     *
     * <p>
     *     gets GameOver.png image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadGameOverImage() {

        try {
            path = getClass().getResource("resources\\GameOver.png");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadBackImage.
     *
     * <p>
     *     gets Back.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */


    public ImageIcon loadBackImage() {

        try {
            path = getClass().getResource("resources\\Back.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadJumpImage.
     *
     * <p>
     *     gets Jump.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadJumpImage() {

        try {
            path = getClass().getResource("resources\\Jump.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadArrowImage.
     *
     * <p>
     *     gets Pfeiltaste.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */

    public ImageIcon loadArrowImage() {

        try {
            path = getClass().getResource("resources\\Pfeiltaste.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadSoundOnImage.
     *
     * <p>
     *     gets SoundOn.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */


    public ImageIcon loadSoundOnImage() {

        try {
            path = getClass().getResource("resources\\SoundOn.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Method loadSoundOffImage.
     *
     * <p>
     *     gets SoundOff.jpg image from resource folder.
     * </p>
     *
     * @throws NullPointerException if no image is found.
     *
     * @return an {@link javax.swing.ImageIcon}.
     */


    public ImageIcon loadSoundOffImage() {

        try {
            path = getClass().getResource("resources\\SoundOff.jpg");
            image = new ImageIcon(path);
        }

        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return image;
    }

}
