package views;

import javax.swing.*;
import java.awt.*;

public class MainGamePanel extends JPanel {

    private int xPosition;
    private int yPosition;

    public MainGamePanel(int weight, int height){
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        xPosition = (weight / 2);
        yPosition = (height - 100);
        System.out.println(weight);
        System.out.println(height);
        this.initComponents();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon ic = new ImageIcon("src/rsc/player.png");
        Image image = ic.getImage();
        g2d.drawImage(image, xPosition,yPosition, this);

    }

    public void setXPosition(int xPosition){
        this.xPosition += xPosition;
        this.paintComponent(this.getGraphics());
    }
    public void setYPosition(int yPosition){
     this.yPosition += yPosition;
    }


    private void initComponents(){
    }
}
