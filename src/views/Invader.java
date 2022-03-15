package views;

import javax.swing.*;
import java.awt.*;

public class Invader {

    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    private String src;

    public Invader(int xPosition, int yPosition, boolean isVisible, String src) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.src = src;
        this.isVisible = isVisible;
    }

    public void paintInvader(Graphics graphics, MainGamePanel mainGamePanel) {
        if (isVisible) {
            Graphics2D g2d = (Graphics2D) graphics;
            ImageIcon singleShip = new ImageIcon(this.src);
            Image iSingleShip = singleShip.getImage();
            g2d.drawImage(iSingleShip, xPosition, yPosition, mainGamePanel);
        }

    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public void setIsVisible(boolean isVisible){
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        return "Invader{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition;
    }
}
