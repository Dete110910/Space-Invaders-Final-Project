package views;

import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JPanel {
    private SingleShip singleShip;
    private ShipPlayer shipPlayer;
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
        singleShip.paintSingleShip(g, this);
        repaint();
    }



    public void setXPosition(int xPosition){
        shipPlayer.setxPosition(xPosition);
    }
    public void setPosition(int xPosition){
        singleShip.move(xPosition);
    }
    public void setYPosition(int yPosition){
    // this.yPosition += yPosition;
    }


    private void initComponents(){



    }


}
