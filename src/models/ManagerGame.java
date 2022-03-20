package models;

import java.util.ArrayList;

public class ManagerGame implements Runnable {
    private boolean isPlaying;
    private ManagerEnemies managerEnemies;
    private ManagerPlayer managerPlayer;
    private int limitX;
    private int limitY;
    private PlayerBullet[] playerBullets;
    private final byte SPACE_LIMIT_BORDERS = 20;

    public ManagerGame(int width, int height) {
        managerEnemies = new ManagerEnemies();
        managerPlayer = new ManagerPlayer(width, height);
        limitX = width - SPACE_LIMIT_BORDERS;
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
        if (getXPositionPlayer() > SPACE_LIMIT_BORDERS) {
            managerPlayer.moveLeft();
        }
    }

    public void moveRightPlayer() {
        if (getXPositionPlayer() < limitX - managerPlayer.getPlayer().WIDTH) {
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
            if (playerBullets[i] == null || playerBullets[i].getIsCrashed()) {
                playerBullets[i] = new PlayerBullet(new Coordinates(managerPlayer.getCoordinates().getCoordenateX() + 28, managerPlayer.getCoordinates().getCoordenateY()));
                playerBullets[i].setIsCrashed(false);
                Thread bulletThread = new Thread(playerBullets[i]);
                bulletThread.start();
                isNotShot = false;
            }
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

    public void verifyCollitionsBulletsWithEnemies() {
        for (int i = 0; i < playerBullets.length; i++) {
            if (!playerBullets[i].isCrashed)
                if (this.managerEnemies.verifyCollitionsGroupEnemies(playerBullets[i].calculateCoordinates())) {
                    playerBullets[i].setIsCrashed(true);
                    managerEnemies.incrementVelocityEnemies();

                } else if (this.managerEnemies.verifyCollitionSingleEnemies(playerBullets[i].calculateCoordinates())) {
                    playerBullets[i].setIsCrashed(true);
                }

        }
    }

    private synchronized boolean verifyNotIsCrashedBullets() {
        for (int i = 0; i < playerBullets.length; i++) {
            if (playerBullets[i].isCrashed == false)
                return true;
        }
        return false;

    }

    public boolean getIsDeadSingleEnemy() {
        return this.managerEnemies.getIsDeadSingleEnemy();
    }

    public boolean isWin(){
        return  managerEnemies.isAllEnemiesDead();
    }


    @Override
    public void run() {
        while (!this.managerEnemies.isAllEnemiesDead() && this.verifyNotIsCrashedBullets() && !managerEnemies.getIsCrashedWithPlayer()) {
            this.verifyCollitionsBulletsWithEnemies();
        }
        if (this.managerEnemies.isAllEnemiesDead()) {
            this.isPlaying = false;
        }
    }

}
