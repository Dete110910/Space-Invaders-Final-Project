package views;

import javax.swing.*;
import java.awt.*;

public class SingleEnemy {
    private int xPosition;
    private int yPosition;

    public SingleEnemy(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void paintSingleShip(Graphics graphics, MainGamePanel mainGamePanel) {
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon singleShip = new ImageIcon("src/rsc/SingleShip.png");
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
