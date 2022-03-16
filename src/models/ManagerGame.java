package models;

import java.util.ArrayList;

public class ManagerGame {
    private boolean isPlaying;
    private ManagerEnemies managerEnemies;
    private ManagerPlayer managerPlayer;
    private final int ZERO = 0;
    private int limitX;
    private int limitY;
    private Bullet playerBullet;

    public ManagerGame(int width, int height) {
        managerEnemies = new ManagerEnemies();
        managerPlayer = new ManagerPlayer(width, height);
        limitX = width;
        limitY = height;
        isPlaying = false;
    }

    public ManagerEnemies getManagerEnemies() {
        return managerEnemies;
    }

    public ManagerPlayer getManagerPlayer() {
        return managerPlayer;
    }

    public int getXPositionPlayer() {
        return managerPlayer.getCoordinates().getCoordenateX();
    }

    public int getYPositionPlayer() {
        return managerPlayer.getCoordinates().getCoordenateY();
    }

    public int getXPositionSingleEnemy() {
        return managerEnemies.getXPositionSingleEnemy();
    }

    public int getYPositionSingleEnemy() {
        return managerEnemies.getYPositionSingleEnemy();
    }

    public void moveLeftPlayer() {
        if (getXPositionPlayer() > ZERO) {
            managerPlayer.moveLeft();
        }
    }

    public void moveRightPlayer() {
        if (getXPositionPlayer() < limitY) {
            managerPlayer.moveRight();
        }
    }

    public void runEnemies() {
        Thread enemiesThread = new Thread(managerEnemies);
        enemiesThread.start();
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getInformationInvaders() {
        return managerEnemies.getInformationInvaders();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public void createPlayerBullet() {
        if(playerBullet == null || playerBullet.isCrashed) {
            playerBullet = new PlayerBullet(new Coordinates(managerPlayer.getCoordinates().getCoordenateX()+28,managerPlayer.getCoordinates().getCoordenateY()));
            Thread bulletThread = new Thread(playerBullet);
            bulletThread.start();
        }
    }

    public boolean getIsCrashedPlayerBullet() {
        return (playerBullet == null)?true:playerBullet.isCrashed;
    }

    public int getXPositionPlayerBullet() {
       return this.playerBullet.coordinates.getCoordenateX();
    }
    public int getYPositionPlayerBullet() {
        return this.playerBullet.coordinates.getCoordenateY();
    }
}
