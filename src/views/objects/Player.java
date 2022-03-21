package views.objects;

import views.panels.MainGamePanel;

import javax.swing.*;
import java.awt.*;

public class Player {

    private static final String SOURCE = "src/rsc/img/player.png";

    private int xPosition;
    private int yPosition;

    public Player(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void paintPlayer(Graphics graphics, MainGamePanel mainGamePanel) {
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon shipPlayer = new ImageIcon(SOURCE);
        Image iShipPlayer = shipPlayer.getImage();
        g2d.drawImage(iShipPlayer, this.xPosition, this.yPosition, mainGamePanel);
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
