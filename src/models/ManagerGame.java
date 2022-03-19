package models;

import java.util.ArrayList;

public class ManagerGame implements Runnable {
    private boolean isPlaying;
    private ManagerEnemies managerEnemies;
    private ManagerPlayer managerPlayer;
    private final int ZERO = 0;
    private int limitX;
    private int limitY;
    private PlayerBullet[] playerBullets;

    public ManagerGame(int width, int height) {
        managerEnemies = new ManagerEnemies();
        managerPlayer = new ManagerPlayer(width, height);
        limitX = width;
        limitY = height;
        isPlaying = false;
        playerBullets = new PlayerBullet[3];
        this.initBullets();
    }

    private void initBullets() {
        for (int i = 0; i < playerBullets.length; i++) {
            playerBullets[i] = new PlayerBullet();
        }
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

    public void createPlayerBullets() {
        boolean isNotShot = true;
        for (int i = 0; i < playerBullets.length && isNotShot; i++) {
            if (playerBullets[i].getIsCrashed()) {
                playerBullets[i] = new PlayerBullet(new Coordinates(managerPlayer.getCoordinates().getCoordenateX() + 28, managerPlayer.getCoordinates().getCoordenateY()));
                playerBullets[i].setIsCrashed(false);
                Thread bulletThread = new Thread(playerBullets[i]);
                bulletThread.start();
                isNotShot = false;
            }
        }
        for (PlayerBullet playerBullet:playerBullets) {
            System.out.println(playerBullet);
        }
    }

    public ArrayList<ArrayList<Integer>> getInformationPLayerBullets() {
        ArrayList<ArrayList<Integer>> informationBullets = new ArrayList<>();
        for (PlayerBullet playerBullet : playerBullets) {
            ArrayList<Integer> informationBullet = new ArrayList<>();
            informationBullet.add(playerBullet.getCoordinates().getCoordenateX());
            informationBullet.add(playerBullet.getCoordinates().getCoordenateY());
            informationBullet.add((playerBullet.getIsCrashed()) ? 0 : 1);
            informationBullets.add(informationBullet);
        }
        return informationBullets;
    }

    public void verifyCollitions() {
        for (int i = 0; i < playerBullets.length; i++) {
            if (!playerBullets[i].isCrashed)
                playerBullets[i].setIsCrashed(this.managerEnemies.verifyCollitions(playerBullets[i].calculateCoordinates()));

        }
    }

    private boolean verifyNotIsCrashed() {
        for (int i = 0; i < playerBullets.length; i++) {
            if (playerBullets[i].isCrashed == false)
                return true;
        }
        return false;

    }

    @Override
    public void run() {
        while (this.verifyNotIsCrashed()) {
            this.verifyCollitions();
        }

    }
}
