package views.objects;

import views.panels.MainGamePanel;

import javax.swing.*;
import java.awt.*;

public class SingleEnemy {

    private static final String SOURCE = "src/rsc/img/SingleShip.png";

    private int xPosition;
    private int yPosition;
    private boolean isVisible;

    public SingleEnemy(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void paintSingleEnemy(Graphics graphics, MainGamePanel mainGamePanel) {
        if (this.isVisible) {
            Graphics2D g2d = (Graphics2D) graphics;
            ImageIcon singleEnemy = new ImageIcon(SOURCE);
            Image iSingleEnemy = singleEnemy.getImage();
            g2d.drawImage(iSingleEnemy, this.xPosition, this.yPosition, mainGamePanel);
        }
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

}
