package views.objects;

import views.panels.MainGamePanel;

import javax.swing.*;
import java.awt.*;

public class Bullet {

    private static final String SOURCE = "src/rsc/img/bullet.png";
    private int xPosition;
    private int yPosition;
    private boolean isVisible;

    public Bullet(int xPosition, int yPosition, boolean isVisible) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isVisible = isVisible;
    }

    public void paintBullet(Graphics graphics, MainGamePanel mainGamePanel) {
        if (this.isVisible) {
            Graphics2D g2d = (Graphics2D) graphics;
            ImageIcon bullet = new ImageIcon(SOURCE);
            Image iBullet = bullet.getImage();
            g2d.drawImage(iBullet, this.xPosition, this.yPosition, mainGamePanel);
        }
    }

}
