package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private StartingPanel startingPanel;
    private NamePanel namePanel;
    private ChooseGameMode chooseGameMode;
    private MainGamePanel mainGamePanel;
    private TopGamePanel topGamePanel;
    private TutorialPanel tutorialPanel;
    private HighScorePanel highScoresPanel;



    public MainFrame(ActionListener actionListener, KeyListener keyListener){
        super("Space Invaders");
        this.setResizable(false);
        this.setFocusable(true);
        this.setSize(700,700);
        this.initComponents(actionListener, keyListener);
        this.addKeyListener(keyListener);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void changeToMainPanel(){
        this.remove(chooseGameMode);
        this.remove(tutorialPanel);
        this.remove(highScoresPanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.namePanel.makeVisibleBackButton(false);
        this.namePanel.makeInvisibleTutorialButton(true);
        this.add(namePanel, BorderLayout.NORTH);
        this.add(startingPanel);
    }
    public void changeToTutorialPanel(){
        this.remove(startingPanel);
        this.remove(namePanel);
        this.remove(chooseGameMode);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(tutorialPanel);
    }
    public void changeToSelectPlayersPanel(){
        this.remove(startingPanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.namePanel.makeVisibleBackButton(true);
        this.namePanel.makeInvisibleTutorialButton(false);
        this.add(chooseGameMode);
    }
    public void changeToOnePlayerPanel(){
        this.remove(chooseGameMode);
        this.remove(namePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(mainGamePanel);
        this.add(topGamePanel, BorderLayout.NORTH);

    }
    public void changeToHighScoresPanel(){
        this.remove(startingPanel);
        this.remove(namePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(highScoresPanel);
    }

    private void initComponents(ActionListener actionListener, KeyListener keyListener){
        startingPanel = new StartingPanel(actionListener);
        namePanel = new NamePanel(actionListener);
        chooseGameMode = new ChooseGameMode(actionListener);
        mainGamePanel = new MainGamePanel(this.getWidth(), this.getHeight());
        topGamePanel = new TopGamePanel();
        tutorialPanel= new TutorialPanel(actionListener);
        highScoresPanel = new HighScorePanel(actionListener, new ArrayList<>()); //cuidado
        this.add(namePanel, BorderLayout.NORTH);
        this.add(startingPanel);
    }

    public void setXPositionPlayer(int xPosition){
        mainGamePanel.setXPositionPlayer(xPosition);
    }
    public void setYPositionPlayer(int yPosition){
        mainGamePanel.setYPositionPlayer(yPosition);
    }
    public void setXPositionSingleEnemy(int xPosition){
        mainGamePanel.setXPositionSingleEnemy(xPosition);
    }
    public void setYPositionSingleEnemy(int yPosition){
        mainGamePanel.setYPositionSingleEnemy(yPosition);
    }

    public void setInformationInvaders(ArrayList<ArrayList<ArrayList<Integer>>> informationList){
       mainGamePanel.setInformationInvader(informationList);
    }

    public void setXPositionPlayerBullet(int xPositionBullet) {
        mainGamePanel.setXPositionPlayerBullet(xPositionBullet);
    }

    public void setYPositionPlayerBullet(int yPositionBullet) {
        mainGamePanel.setYPositionPlayerBullet(yPositionBullet);
    }

    public void setIsVisiblePlayerBullet(boolean isVisibleBullet) {
        mainGamePanel.setIsVisiblePlayerBullet(isVisibleBullet);
    }

}
