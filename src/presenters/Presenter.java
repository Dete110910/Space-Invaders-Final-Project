package presenters;

import models.ManagerGame;
import views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Presenter implements ActionListener, KeyListener, Runnable {

    private MainFrame mainFrame;
    private ManagerGame managerGame;
    private Thread threadManagerGame;

    public Presenter() {
        mainFrame = new MainFrame(this, this);
        managerGame = new ManagerGame(mainFrame.getWidth(), mainFrame.getHeight());
        mainFrame.setXPositionPlayer(managerGame.getXPositionPlayer());
        mainFrame.setYPositionPlayer(managerGame.getYPositionPlayer());
        this.threadManagerGame = new Thread(managerGame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Play":
                mainFrame.changeToSelectPlayersPanel();
                break;
            case "HighScore":
                mainFrame.changeToHighScoresPanel();
                break;
            case "Back":
                mainFrame.changeToMainPanel();
                break;
            case "PlayOnePlayer":
                managerGame.setPlaying(true);
                mainFrame.changeToOnePlayerPanel();
                managerGame.runEnemies();
                Thread gameThread = new Thread(this);
                gameThread.start();
                break;
            case "PlayTwoPlayers":
                System.out.println("To implement");
                break;
            case "PlayTwoPlayersLAN":
                System.out.println("To implement");
                break;
            case "Tutorial":
                mainFrame.changeToTutorialPanel();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (managerGame.isPlaying())
            if (e.getKeyChar() == 'a') {
                managerGame.moveLeftPlayer();
                mainFrame.setXPositionPlayer(managerGame.getXPositionPlayer());
            } else if (e.getKeyChar() == 'd') {
                managerGame.moveRightPlayer();
                mainFrame.setXPositionPlayer(managerGame.getXPositionPlayer());
            } else if (e.getKeyChar() == ' ') {

                managerGame.createPlayerBullets();
                if (Thread.State.NEW == threadManagerGame.getState()){
                     threadManagerGame.start();
                    System.out.println("me comencé");
                }else if ( Thread.State.TERMINATED == threadManagerGame.getState()){
                    threadManagerGame = new Thread(managerGame);
                    System.out.println("soy nuevo en el presenter ");
                }
            }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.controlSingleEnemy();
            this.controlGroupEnemies();
            this.controlBulletPlayer();
        }
    }

    private void controlBulletPlayer() {
        mainFrame.setInformationBullets(managerGame.getInformationPLayerBullets());

    }

    private void controlSingleEnemy() {
        mainFrame.setXPositionSingleEnemy(managerGame.getXPositionSingleEnemy());
        mainFrame.setYPositionSingleEnemy(managerGame.getYPositionSingleEnemy());
    }

    private void controlGroupEnemies() {
        mainFrame.setInformationInvaders(managerGame.getInformationInvaders());
    }

}
