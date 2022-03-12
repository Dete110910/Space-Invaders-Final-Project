package presenters;

import models.ManagerGame;
import views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Presenter implements ActionListener, KeyListener,Runnable {

    private MainFrame mainFrame;
    private ManagerGame managerGame;

    public Presenter() {
        mainFrame = new MainFrame(this, this);
        managerGame = new ManagerGame(mainFrame.getWidth(), mainFrame.getHeight());
        mainFrame.setXPositionPlayer(managerGame.getXPositionPlayer());
        mainFrame.setYPositionPlayer(managerGame.getYPositionPlayer());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "Play":
                mainFrame.changeToSelectPlayersPanel();
                break;
            case "HighScore":
                System.out.println("To implement");
                break;
            case "Back":
                mainFrame.changeToMainPanel();
                break;
            case "PlayOnePlayer":
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

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            managerGame.moveLeftPlayer();
            mainFrame.setXPositionPlayer(managerGame.getXPositionPlayer());
        } else if (e.getKeyChar() == 'd') {
            managerGame.moveRightPlayer();
            mainFrame.setXPositionPlayer(managerGame.getXPositionPlayer());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mainFrame.setXPositionSingleEnemy(managerGame.getXPositionSingleEnemy());
            mainFrame.setYPositionSingleEnemy(managerGame.getYPositionSingleEnemy());
        }
    }
}
