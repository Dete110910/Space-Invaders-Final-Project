package views;

import javax.swing.*;
import java.awt.*;

public class ShipPlayer {
    private int xPosition;
    private int yPosition;
    public ShipPlayer(int xPosition, int yPosition) {
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xposition) {
            this.xPosition += xposition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yposition) {
        this.yPosition += yPosition;
    }

    public void paintShipPlayer(Graphics graphics, MainGamePanel mainGamePanel){
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon shipPlayer = new ImageIcon("src/rsc/player.png");
        Image IshipPlayer= shipPlayer.getImage();
        g2d.drawImage(IshipPlayer, xPosition / 2,yPosition - 100, mainGamePanel);
    }
}
