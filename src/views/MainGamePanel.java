package views;

import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JPanel {
    private SingleShip singleShip;
    private Player player;
    public MainGamePanel(int weight, int height){
        this.setVisible(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        singleShip= new SingleShip(weight, height-680);
        player = new Player(weight, height);
        System.out.println(weight);
        System.out.println(height);
        this.initComponents();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.paintShipPlayer(g, this);
        singleShip.paintSingleShip(g, this);
        repaint();
    }



    public void setXPositionPlayer(int xPosition){
        player.setXPosition(xPosition);
    }
    public void setYPositionPlayer(int yPosition){
        player.setYPosition(yPosition);
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
