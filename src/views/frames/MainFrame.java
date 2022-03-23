package views.frames;

import views.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private static final String TITLE = "Space Invaders";
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    private StartingPanel startingPanel;
    private NamePanel namePanel;
    private ChooseGameModePanel chooseGameMode;
    private MainGamePanel mainGamePanel;
    private TopGamePanel topGamePanel;
    private TutorialPanel tutorialPanel;
    private HighScorePanel highScoresPanel;
    private FinalGamePanel finalGamePanel;

    public MainFrame(ActionListener actionListener, KeyListener keyListener, ArrayList<String> informationScores) {
        super(TITLE);
        this.setResizable(false);
        this.setFocusable(true);
        this.setSize(WIDTH, HEIGHT);
        this.initComponents(actionListener, informationScores);
        this.addKeyListener(keyListener);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void changeToMainPanel() {
        this.remove(this.chooseGameMode);
        this.remove(this.tutorialPanel);
        this.remove(this.highScoresPanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.namePanel.makeVisibleBackButton(false);
        this.namePanel.makeInvisibleTutorialButton(true);
        this.add(this.namePanel, BorderLayout.NORTH);
        this.add(this.startingPanel);
    }

    public void changeToMainPanelFromFinalGamePanel() {
        this.remove(this.finalGamePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.namePanel.makeVisibleBackButton(false);
        this.namePanel.makeInvisibleTutorialButton(true);
        this.add(this.namePanel, BorderLayout.NORTH);
        this.add(this.startingPanel);
    }

    public void changeToTutorialPanel() {
        this.remove(this.startingPanel);
        this.remove(this.namePanel);
        this.remove(this.chooseGameMode);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(this.tutorialPanel);
    }


    public void changeToOnePlayerPanel() {
        this.remove(this.startingPanel);
        this.remove(this.namePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(this.mainGamePanel);
        this.add(this.topGamePanel, BorderLayout.NORTH);

    }

    public void changeToHighScoresPanel() {
        this.remove(this.startingPanel);
        this.remove(this.namePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(this.highScoresPanel);
    }

    public void changeToWinAndLosePanel(ActionListener actionListener, boolean win) {
        this.remove(this.mainGamePanel);
        this.remove(this.topGamePanel);
        this.finalGamePanel = new FinalGamePanel(actionListener, win);
        this.add(this.finalGamePanel);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void initComponents(ActionListener actionListener, ArrayList<String> informationScores) {
        this.startingPanel = new StartingPanel(actionListener);
        this.namePanel = new NamePanel(actionListener);
        this.chooseGameMode = new ChooseGameModePanel(actionListener);
        this.mainGamePanel = new MainGamePanel(this.getWidth(), this.getHeight());
        this.topGamePanel = new TopGamePanel();
        this.tutorialPanel = new TutorialPanel(actionListener);
        this.highScoresPanel = new HighScorePanel(actionListener, informationScores);

        this.add(this.namePanel, BorderLayout.NORTH);
        this.add(this.startingPanel);
    }

    public void setXPositionPlayer(int xPosition) {
        this.mainGamePanel.setXPositionPlayer(xPosition);
    }

    public void setYPositionPlayer(int yPosition) {
        this.mainGamePanel.setYPositionPlayer(yPosition);
    }

    public void setXPositionSingleEnemy(int xPosition) {
        this.mainGamePanel.setXPositionSingleEnemy(xPosition);
    }

    public void setYPositionSingleEnemy(int yPosition) {
        this.mainGamePanel.setYPositionSingleEnemy(yPosition);
    }

    public void setVisibleSingleEnemy(boolean isVisible) {
        this.mainGamePanel.setVisibleSingleEnemy(isVisible);
    }

    public void setInformationInvaders(ArrayList<ArrayList<ArrayList<Integer>>> informationList) {
        this.mainGamePanel.setInformationInvader(informationList);
    }

    public void setInformationBullets(ArrayList<ArrayList<Integer>> informationBullets) {
        this.mainGamePanel.setInformationBullets(informationBullets);
    }

    public String getNamePlayer() {
        return finalGamePanel.getNamePlayer();
    }

    public void updateScorePlayer(int scorePlayer) {
        this.topGamePanel.updateScorePlayer(scorePlayer);
    }

    public void setFinalScore(String finalScore) {
        this.finalGamePanel.setScore(finalScore);
    }

    public void updateLabels(ArrayList<String> informationHighScores) {
        this.highScoresPanel.updateLabels(informationHighScores);
    }
}
