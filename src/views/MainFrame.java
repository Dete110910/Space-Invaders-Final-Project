package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class MainFrame extends JFrame {

    private StartingPanel startingPanel;
    private NamePanel namePanel;
    private ChooseGameMode chooseGameMode;
    private MainGamePanel mainGamePanel;
    private TopGamePanel topGamePanel;
    private TutorialPanel tutorialPanel;



    public MainFrame(ActionListener actionListener, KeyListener keyListener){
        super("Space Invaders");
       // this.setResizable(false);
        this.setFocusable(true);
        this.setSize(700,700);
        this.initComponents(actionListener, keyListener);
        this.addKeyListener(keyListener);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void changeToMainPanel(){
        this.remove(chooseGameMode);
        SwingUtilities.updateComponentTreeUI(this);
        this.namePanel.makeVisibleBackButton(false);
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
        this.add(chooseGameMode);

    }

    public void changeToOnePlayerPanel(){
        this.remove(chooseGameMode);
        this.remove(namePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(mainGamePanel);
        this.add(topGamePanel, BorderLayout.NORTH);

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


    private void initComponents(ActionListener actionListener, KeyListener keyListener){
        startingPanel = new StartingPanel(actionListener);
        namePanel = new NamePanel(actionListener);
        chooseGameMode = new ChooseGameMode(actionListener);
        mainGamePanel = new MainGamePanel(this.getWidth(), this.getHeight());
        topGamePanel = new TopGamePanel();
        tutorialPanel= new TutorialPanel(actionListener);
        this.add(namePanel, BorderLayout.NORTH);
        this.add(startingPanel);
    }

}
