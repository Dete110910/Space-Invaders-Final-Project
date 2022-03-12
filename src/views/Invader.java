package views;

import javax.swing.*;
import java.awt.*;

public class Invader {

    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    private String src;

    public Invader(int xPosition, int yPosition, String src){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.src = src;
        this.isVisible = true;
    }

    public void paintInvader(Graphics graphics, MainGamePanel mainGamePanel) {
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon singleShip = new ImageIcon(this.src);
        Image iSingleShip = singleShip.getImage();
        g2d.drawImage(iSingleShip, xPosition, yPosition, mainGamePanel);

    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition){
        this.yPosition = yPosition;
    }

}
