package views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SingleShip  {
    private int xPosition;
    private int yPosition;
    private int  direction;
    private ImageIcon imageIcon;
    public SingleShip(int xPosition, int yPosition) {
        this.xPosition=xPosition;
       this.yPosition=yPosition;
       imageIcon= new ImageIcon();
    }

    public void paintSingleShip(Graphics graphics, MainGamePanel mainGamePanel){
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon singleShip = new ImageIcon("src/rsc/SingleShip.png");
        Image iSingleShip = singleShip.getImage();
        g2d.drawImage(iSingleShip, xPosition,yPosition, mainGamePanel);

    }
    public void move(int xPosition1){
        xPosition=xPosition1;
    }

}
