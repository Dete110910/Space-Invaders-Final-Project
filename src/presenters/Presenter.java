package presenters;

import models.managers.ManagerGame;
import views.frames.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Presenter implements ActionListener, KeyListener, Runnable {

    private MainFrame mainFrame;
    private ManagerGame managerGame;
    private Thread threadManagerGame;

    public Presenter() {
        this.managerGame = new ManagerGame();
        this.mainFrame = new MainFrame(this, this, this.managerGame.getInformationHighScores());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Play":
                this.controlPlay();
                break;
            case "HighScore":
                this.mainFrame.changeToHighScoresPanel();
                this.mainFrame.updateLabels(this.managerGame.getInformationHighScores());
                break;
            case "Back":
                this.mainFrame.changeToMainPanel();
                break;
            case "PlayOnePlayer":

            case "Done":
                this.managerGame.setNamePlayer(this.mainFrame.getNamePlayer());
                this.mainFrame.changeToMainPanelFromFinalGamePanel();
                break;
            case "Tutorial":
                this.mainFrame.changeToTutorialPanel();
                break;
        }
    }

    private void controlPlay() {
        this.managerGame = new ManagerGame(this.mainFrame.getWidth(), this.mainFrame.getHeight());
        this.mainFrame.setXPositionPlayer(this.managerGame.getXPositionPlayer());
        this.mainFrame.setYPositionPlayer(this.managerGame.getYPositionPlayer());
        this.threadManagerGame = new Thread(this.managerGame);
        this.managerGame.setPlaying(true);
        this.mainFrame.changeToOnePlayerPanel();
        this.managerGame.runEnemies();
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.managerGame.getIsPlaying())
            if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                this.managerGame.moveLeftPlayer();
                this.mainFrame.setXPositionPlayer(this.managerGame.getXPositionPlayer());
            } else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
                this.managerGame.moveRightPlayer();
                this.mainFrame.setXPositionPlayer(this.managerGame.getXPositionPlayer());
            } else if (e.getKeyChar() == ' ') {
                this.controlShot();
            }
    }

    private void controlShot() {
        this.managerGame.createPlayerBullets();
        if (Thread.State.NEW == this.threadManagerGame.getState()) {
            this.threadManagerGame.start();
        } else if (Thread.State.TERMINATED == threadManagerGame.getState()) {
            this.threadManagerGame = new Thread(this.managerGame);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    private void controlBulletPlayer() {
        this.mainFrame.setInformationBullets(this.managerGame.getInformationPLayerBullets());
    }

    private void controlSingleEnemy() {
        this.mainFrame.setXPositionSingleEnemy(this.managerGame.getXPositionSingleEnemy());
        this.mainFrame.setYPositionSingleEnemy(this.managerGame.getYPositionSingleEnemy());
        this.mainFrame.setVisibleSingleEnemy(!this.managerGame.getIsDeadSingleEnemy());
    }

    private void controlGroupEnemies() {
        this.mainFrame.setInformationInvaders(this.managerGame.getInformationInvaders());
    }

    private void manageScorePlayer() {
        this.mainFrame.changeToWinAndLosePanel(this, this.managerGame.getIsWin());
        this.mainFrame.setFinalScore(String.valueOf(this.managerGame.getScorePlayer()));
    }

    private void controlScorePlayer() {
        this.mainFrame.updateScorePlayer(this.managerGame.getScorePlayer());
    }

    @Override
    public void run() {
        while (this.managerGame.getIsPlaying()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.managerGame.verifyIsPlaying();
            this.controlSingleEnemy();
            this.controlGroupEnemies();
            this.controlBulletPlayer();
            this.controlScorePlayer();
        }
        this.manageScorePlayer();
    }


}
