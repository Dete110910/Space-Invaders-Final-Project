package views;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    private int xPosition;
    private int yPosition;
    private boolean isVisible;

    public Bullet(int xPosition, int yPosition, boolean isVisible){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isVisible = isVisible;
    }


    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public void setYPosition(int yPosition){
        this.yPosition = yPosition;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void paintBullet(Graphics graphics, MainGamePanel mainGamePanel){
        if(isVisible) {
            Graphics2D g2d = (Graphics2D) graphics;
            ImageIcon bullet = new ImageIcon("src/rsc/bullet.png");
            Image iBullet = bullet.getImage();
            g2d.drawImage(iBullet, xPosition, yPosition, mainGamePanel);
        }
    }

}
