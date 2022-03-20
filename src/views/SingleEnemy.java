package views;

import javax.swing.*;
import java.awt.*;

public class SingleEnemy {
    private int xPosition;
    private int yPosition;
    private boolean isVisible;

    public SingleEnemy(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void paintSingleEnemy(Graphics graphics, MainGamePanel mainGamePanel) {
        if(isVisible) {
            Graphics2D g2d = (Graphics2D) graphics;
            ImageIcon singleEnemy = new ImageIcon("src/rsc/SingleShip.png");
            Image iSingleEnemy = singleEnemy.getImage();
            g2d.drawImage(iSingleEnemy, xPosition, yPosition, mainGamePanel);
        }

    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition){
        this.yPosition = yPosition;
    }
    public void setIsVisible(boolean isVisible){
        this.isVisible = isVisible;
    }

}
