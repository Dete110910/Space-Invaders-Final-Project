package views;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int xPosition;
    private int yPosition;
    public Player(int xPosition, int yPosition) {
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }


    public void setXPosition(int xPosition) {
            this.xPosition = xPosition;
    }
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void paintPlayer(Graphics graphics, MainGamePanel mainGamePanel){
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon shipPlayer = new ImageIcon("src/rsc/player.png");
        Image iShipPlayer= shipPlayer.getImage();
        g2d.drawImage(iShipPlayer, xPosition,yPosition, mainGamePanel);
    }
}
