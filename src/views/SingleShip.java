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

    public void paintInvader(Graphics graphics, MainGamePanel mainGamePanel){
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon singleShip = new ImageIcon("src/rsc/SingleShip.png");
        Image iSingleShip = singleShip.getImage();
        g2d.drawImage(iSingleShip, xPosition,yPosition, mainGamePanel);
        System.out.println(iSingleShip.getHeight(mainGamePanel));
        System.out.println(iSingleShip.getWidth(mainGamePanel));
    }
    public int move() {
            defineDirection();
            defineXposition();
            return  xPosition;
    }

    private void defineXposition() {
        if(this.direction==1){
            this.xPosition= this.xPosition+20;
        }else{
            this.xPosition= this.xPosition-20;
        }
    }

    private void defineDirection() {
        if(this.xPosition==0){
            this.direction=1;
        }else if(this.xPosition==680){
            this.direction=0;
        }
    }
}
