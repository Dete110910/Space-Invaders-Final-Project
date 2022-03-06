package views;

import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JPanel implements Runnable{

    private int xPosition;
    private int yPosition;
    private SingleShip singleShip;
    private ShipPlayer shipPlayer;
    private int x= 0;
    private int y= 250;

    public MainGamePanel(int weight, int height){
        this.setVisible(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        singleShip= new SingleShip(weight, height-680);
        shipPlayer = new ShipPlayer(weight, height);
        System.out.println(weight);
        System.out.println(height);
        this.initComponents();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        shipPlayer.paintShipPlayer(g, this);
        singleShip.paintInvader(g, this);

    }



    public void setXPosition(int xPosition){
        shipPlayer.setxPosition(xPosition);

    }
    public void setYPosition(int yPosition){
    // this.yPosition += yPosition;
    }


    private void initComponents(){

            Thread thread= new Thread(this);
          thread.start();

    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            singleShip.move();
            repaint();
        }
    }
}
