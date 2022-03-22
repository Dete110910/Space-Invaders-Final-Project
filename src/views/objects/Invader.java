package views.objects;

import views.panels.MainGamePanel;

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
        if (this.isVisible) {
            Graphics2D g2d = (Graphics2D) graphics;
            ImageIcon invader = new ImageIcon(this.src);
            Image iInvader = invader.getImage();
            g2d.drawImage(iInvader, this.xPosition, this.yPosition, mainGamePanel);
        }

    }
}
