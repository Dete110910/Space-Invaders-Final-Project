package views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class SingleShip  {
    private int xPosition;
    private int yPosition;
    private int  direction;
    public SingleShip(int xPosition, int yPosition) {
        this.xPosition=xPosition;
       this.yPosition=yPosition;
    }

    public void paintInvader(Graphics graphics, MainGamePanel mainGamePanel){
        Graphics2D g2d = (Graphics2D) graphics;
        ImageIcon singleShip = new ImageIcon("src/rsc/SingleShip.png");
        Image ISingleShip = singleShip.getImage();
        g2d.drawImage(ISingleShip, xPosition,yPosition, mainGamePanel);
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
        if(this.xPosition==-50){
            this.direction=1;
        }else if(this.xPosition==750){
            this.direction=0;
        }
    }
}
