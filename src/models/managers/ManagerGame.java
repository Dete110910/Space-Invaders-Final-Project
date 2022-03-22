package models.managers;

import models.enums.TypeEnemy;
import models.entities.Coordinates;
import models.entities.PlayerBullet;
import persistence.PersistenceHighScore;

import java.util.ArrayList;

public class ManagerGame implements Runnable {

    private final byte SPACE_LIMIT_BORDERS = 20;

    private ManagerEnemies managerEnemies;
    private ManagerPlayer managerPlayer;
    private ManagerHighScore managerHighScore;
    private PlayerBullet[] playerBullets;
    private boolean isPlaying;
    private int limitX;

    public ManagerGame(int width, int height) {
        this.managerEnemies = new ManagerEnemies();
        this.managerPlayer = new ManagerPlayer(width, height);
        this.managerHighScore = PersistenceHighScore.getManagerHighScore();
        this.playerBullets = new PlayerBullet[3];
        this.initBullets();

        this.limitX = width - SPACE_LIMIT_BORDERS;
        this.isPlaying = false;
    }

    public ManagerGame() {
        this.managerHighScore = PersistenceHighScore.getManagerHighScore();
    }

    private void initBullets() {
        for (int i = 0; i < this.playerBullets.length; i++)
            this.playerBullets[i] = new PlayerBullet();

    }

    public void moveLeftPlayer() {
        if (getXPositionPlayer() > SPACE_LIMIT_BORDERS) {
            this.managerPlayer.moveLeft();
        }
    }

    public void moveRightPlayer() {
        if (getXPositionPlayer() < limitX - this.managerPlayer.getPlayer().WIDTH) {
            this.managerPlayer.moveRight();
        }
    }

    public void runEnemies() {
        Thread enemiesThread = new Thread(this.managerEnemies);
        enemiesThread.start();
    }

    public void createPlayerBullets() {
        boolean isNotShot = true;
        for (int i = 0; i < this.playerBullets.length && isNotShot; i++) {
            if (this.playerBullets[i] == null || this.playerBullets[i].getIsCrashed()) {
                this.playerBullets[i] = new PlayerBullet(new Coordinates(this.managerPlayer.getCoordinates().getCoordinateX() + 28, managerPlayer.getCoordinates().getCoordinateY()));
                this.playerBullets[i].setIsCrashed(false);
                Thread bulletThread = new Thread(this.playerBullets[i]);
                bulletThread.start();
                isNotShot = false;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getInformationPLayerBullets() {
        ArrayList<ArrayList<Integer>> informationBullets = new ArrayList<>();
        for (PlayerBullet playerBullet : this.playerBullets) {
            ArrayList<Integer> informationBullet = new ArrayList<>();
            informationBullet.add(playerBullet.getCoordinates().getCoordinateX());
            informationBullet.add(playerBullet.getCoordinates().getCoordinateY());
            informationBullet.add((playerBullet.getIsCrashed()) ? 0 : 1);
            informationBullets.add(informationBullet);
        }
        return informationBullets;
    }

    public void verifyCollisionsBulletsWithEnemies() {
        for (int i = 0; i < this.playerBullets.length; i++) {
            if (!this.playerBullets[i].getIsCrashed()) {
                int score = this.managerEnemies.verifyCollisionsGroupEnemies(this.playerBullets[i].calculateCoordinates());
                if (score != 0) {
                    this.playerBullets[i].setIsCrashed(true);
                    this.managerEnemies.incrementVelocityEnemies();
                    this.managerPlayer.addScore(score);
                } else if (!getIsDeadSingleEnemy() && this.managerEnemies.verifyCollisionSingleEnemies(this.playerBullets[i].calculateCoordinates())) {
                    this.playerBullets[i].setIsCrashed(true);
                    this.managerPlayer.addScore(TypeEnemy.SINGLE_ENEMY.getValue());
                }

            }
        }
    }

    private synchronized boolean verifyNotIsCrashedBullets() {
        for (PlayerBullet playerBullet : this.playerBullets)
            if (!playerBullet.getIsCrashed())
                return true;
        return false;
    }

    public void verifyIsPlaying() {
        if (this.managerEnemies.isAllEnemiesDead() || this.managerEnemies.getIsCrashedWithPlayer()) {
            this.isPlaying = false;
        }
    }

    public boolean getIsDeadSingleEnemy() {
        return this.managerEnemies.getIsDeadSingleEnemy();
    }

    public boolean getIsWin() {
        return this.managerEnemies.isAllEnemiesDead();
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getInformationInvaders() {
        return this.managerEnemies.getInformationInvaders();
    }

    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public int getScorePlayer() {
        return this.managerPlayer.getScore();
    }

    public int getXPositionPlayer() {
        return this.managerPlayer.getCoordinates().getCoordinateX();
    }

    public int getYPositionPlayer() {
        return this.managerPlayer.getCoordinates().getCoordinateY();
    }

    public int getXPositionSingleEnemy() {
        return this.managerEnemies.getXPositionSingleEnemy();
    }

    public int getYPositionSingleEnemy() {
        return this.managerEnemies.getYPositionSingleEnemy();
    }

    public void setNamePlayer(String namePlayer) {
        this.managerHighScore.addScore(namePlayer, this.managerPlayer.getScore());
        PersistenceHighScore.writeHighScores(managerHighScore);
    }

    public ArrayList<String> getInformationHighScores() {
        return this.managerHighScore.getInformationHighScores();
    }

    @Override
    public void run() {
        while (!this.managerEnemies.isAllEnemiesDead() && this.verifyNotIsCrashedBullets() && !this.managerEnemies.getIsCrashedWithPlayer()) {
            this.verifyCollisionsBulletsWithEnemies();
        }
    }

}
