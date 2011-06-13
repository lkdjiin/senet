package senet.game.element;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class SticksPanel extends JPanel {

    private static int THIS_WIDTH = 145;
    private static int THIS_HEIGHT = 150;


    private BufferedImage offscreenImage;
    private BufferedImage lightStick;
    private BufferedImage darkStick;

    public SticksPanel() throws IOException {
        offscreenImage = new BufferedImage(THIS_WIDTH, THIS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        lightStick = ImageIO.read(new File("images/white-stick.png"));
        darkStick = ImageIO.read(new File("images/black-stick.png"));
        setSize(THIS_WIDTH, THIS_HEIGHT);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(THIS_WIDTH, THIS_HEIGHT);
    }

    @Override
    public int getWidth() {
        return THIS_WIDTH;
    }

    @Override
    public int getHeight() {
        return THIS_HEIGHT;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(offscreenImage, 0, 0, null);
    }

    public void clear() {
        Graphics2D g = offscreenImage.createGraphics();
        g.setColor(new Color(201,193,146));
        g.fillRect(0, 0, THIS_WIDTH, THIS_HEIGHT);
        repaint();
    }

    public void draw(Integer[] detail) {
        Graphics2D g = offscreenImage.createGraphics();

        if(detail[0] == 0) {
            g.drawImage(darkStick, 5, 5, null);
        } else {
            g.drawImage(lightStick, 5, 5, null);
        }

        if(detail[1] == 0) {
            g.drawImage(darkStick, 40, 5, null);
        } else {
            g.drawImage(lightStick, 40, 5, null);
        }

        if(detail[2] == 0) {
            g.drawImage(darkStick, 75, 5, null);
        } else {
            g.drawImage(lightStick, 75, 5, null);
        }

        if(detail[3] == 0) {
            g.drawImage(darkStick, 110, 5, null);
        } else {
            g.drawImage(lightStick, 110, 5, null);
        }

        repaint();
    }
}
