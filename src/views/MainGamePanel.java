package views;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGamePanel extends JPanel {

    private SingleEnemy singleEnemy;
    private Player player;
    private Bullet[] playerBullets;
    private ArrayList<ArrayList<Invader>> invadersList;
    private final String SOURCE_BASIC_ENEMY = "src/rsc/enemyBasic.png";
    private final String SOURCE_NORMAL_ENEMY = "src/rsc/enemyNormal.png";
    private final String SOURCE_DIFFICULT_ENEMY = "src/rsc/enemyDifficult.png";

    public MainGamePanel(int weight, int height) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setBackground(Color.BLACK);
        this.initComponents(weight, height);
        this.playerBullets = new Bullet[3];
    }


    public synchronized void printGroupEnemies(Graphics g) {
        for (int i = 0; i < invadersList.size(); i++) {
            for (int j = 0; j < invadersList.get(i).size(); j++) {
                invadersList.get(i).get(j).paintInvader(g, this);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paintPlayer(g, this);
        singleEnemy.paintSingleEnemy(g, this);
        this.printGroupEnemies(g);
        this.printBullets(g);
        repaint();
    }

    private void printBullets(Graphics g) {
        for (Bullet bullet : playerBullets) {
            if(bullet != null)
                bullet.paintBullet(g, this);
        }
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


    public synchronized void setInformationInvader(ArrayList<ArrayList<ArrayList<Integer>>> informationList) {
        invadersList.clear();
        for (ArrayList<ArrayList<Integer>> informationRows : informationList) {
            ArrayList<Invader> invaderRowList = new ArrayList<>();
            for (ArrayList<Integer> informationInvader : informationRows) {
                Invader invader = new Invader(informationInvader.get(0), informationInvader.get(1), (informationInvader.get(2) == 0) ? false : true,
                        this.defineTypeInvader(informationInvader.get(3)));
                invaderRowList.add(invader);
            }
            invadersList.add(invaderRowList);
        }
    }

    public String defineTypeInvader(int type) {
        switch (type) {
            case 0:
                return SOURCE_DIFFICULT_ENEMY;
            case 1:
                return SOURCE_NORMAL_ENEMY;
            case 2:
                return SOURCE_BASIC_ENEMY ;

            default:
                return SOURCE_NORMAL_ENEMY;
        }

    }


    public void setInformationBullets(ArrayList<ArrayList<Integer>> informationBullets) {
        for (int i = 0; i < informationBullets.size(); i++) {
            playerBullets[i] = new Bullet(informationBullets.get(i).get(0), informationBullets.get(i).get(1), (informationBullets.get(i).get(2) == 0) ? false : true);
        }
    }

    public void setVisibleSingleEnemy(boolean isVisible) {
        singleEnemy.setIsVisible(isVisible);
    }
}
