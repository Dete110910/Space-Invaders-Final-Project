package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGamePanel extends JPanel {

    private SingleEnemy singleEnemy;
    private Player player;
    private ArrayList<ArrayList<Invader>> invadersList;
    private final String SOURCE_BASIC_ENEMY = "src/rsc/enemyBasic.png";
    private final String SOURCE_NORMAL_ENEMY = "src/rsc/enemyNormal.png";
    private final String SOURCE_DIFFICULT_ENEMY = "src/rsc/enemyDifficult.png";

    public MainGamePanel(int weight, int height) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        System.out.println(weight);
        System.out.println(height);
        this.initComponents(weight, height);

    }

    public void createInvadersList() {
        for (int i = 0, w = 40; i < 3; i++, w += 40) {
            ArrayList<Invader> auxInvaderList = new ArrayList<>();
            for (int j = 0, k = 40; j < 7; j++, k += 40) {
                switch (i) {
                    case 0:
                        Invader invader = new Invader(i + k, j + w, SOURCE_DIFFICULT_ENEMY);
                        auxInvaderList.add(invader);
                        break;
                    case 1:
                        invader = new Invader(i + k, j + w, SOURCE_NORMAL_ENEMY);
                        auxInvaderList.add(invader);
                        break;
                    case 2:
                        invader = new Invader(i + k, j + w, SOURCE_BASIC_ENEMY);
                        auxInvaderList.add(invader);
                        break;
                }
            }
            invadersList.add(auxInvaderList);
        }
    }

    public void printGroupEnemies(Graphics g){
        this.createInvadersList();
        for(int i = 0; i < invadersList.size(); i++){
            for(int j = 0; j < invadersList.get(i).size(); j++){
                invadersList.get(i).get(j).paintInvader(g, this);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paintShipPlayer(g, this);
        singleEnemy.paintSingleShip(g, this);
        this.printGroupEnemies(g);
        repaint();
    }




    public void setXPositionPlayer(int xPosition) {
        player.setXPosition(xPosition);
    }

    public void setYPositionPlayer(int yPosition) {
        player.setYPosition(yPosition);
    }

    public void setXPositionSingleEnemy(int xPosition) {
        singleEnemy.setXPosition(xPosition);
    }

    public void setYPositionSingleEnemy(int yPosition) {
        singleEnemy.setYPosition(yPosition);
    }


    private void initComponents(int weight, int height) {
        singleEnemy = new SingleEnemy(weight, height - 680);
        player = new Player(weight, height);
        invadersList = new ArrayList<>();
    }


}
