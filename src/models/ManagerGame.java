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

    public void createPlayerBullet() {
        boolean isNotShot = true;
        for (int i = 0; i < playerBullets.length && isNotShot; i++) {
            if (playerBullets[i].isCrashed) {
                playerBullets[i] = new PlayerBullet(new Coordinates(managerPlayer.getCoordinates().getCoordenateX() + 28, managerPlayer.getCoordinates().getCoordenateY()));
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
            informationBullet.add(playerBullet.coordinates.getCoordenateX());
            informationBullet.add(playerBullet.coordinates.getCoordenateY());
            informationBullet.add((playerBullet.isCrashed) ? 0 : 1);
            informationBullets.add(informationBullet);
        }

        return informationBullets;
    }

    public void verifyCollitions(){
        for(PlayerBullet playerBullet : playerBullets){
            playerBullet.isCrashed =  this.managerEnemies.verifyCollitions(playerBullet.calculateCoordinates());
        }
    }

    private boolean verifyNotIsCrashed() {
        for (PlayerBullet playerBullet : playerBullets) {
            if (playerBullet.isCrashed == false)
                return true;
        }
        return false;

    }
    @Override
    public void run() {
        while (this.verifyNotIsCrashed()) {
            System.out.println(" aquí ");
            try {
                Thread.sleep(509);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.verifyCollitions();
        }
    }
}
