package models.managers;

import models.entities.Coordinates;
import models.entities.SingleEnemy;

import java.util.ArrayList;

public class ManagerEnemies implements Runnable {

    private static final byte INIT_COORDINATE_X_SINGLE_ENEMY = -10;
    private static final byte INIT_COORDINATE_Y_SINGLE_ENEMY = 10;
    private static final int LOWER_LIMIT = 580;

    private SingleEnemy singleEnemy;
    private GroupEnemies groupEnemies;
    private boolean isCrashedWithPlayer;

    public ManagerEnemies() {
        this.singleEnemy = new SingleEnemy(new Coordinates(INIT_COORDINATE_X_SINGLE_ENEMY, INIT_COORDINATE_Y_SINGLE_ENEMY));
        this.groupEnemies = new GroupEnemies();
        this.isCrashedWithPlayer = false;
    }

    public int verifyCollisionsGroupEnemies(ArrayList<Coordinates> coordinatesBullet){
        return this.groupEnemies.makeCollision(coordinatesBullet);
    }
    public void incrementVelocityEnemies() {
        this.groupEnemies.incrementVelocity();
    }

    public boolean verifyCollisionSingleEnemies(ArrayList<Coordinates> calculateCoordinates) {
        return  this.singleEnemy.verifyCollision(calculateCoordinates);
    }
    public void verifyCollisionWithPlayer(){
        Coordinates lastCoordinate = this.groupEnemies.calculateCoordinatesLimitLower();
        if(lastCoordinate.getCoordinateY() >=LOWER_LIMIT) {
            this.isCrashedWithPlayer = true;
            this.singleEnemy.setIsDead(true);
        }
    }

    public boolean isAllEnemiesDead(){
        return  this.groupEnemies.isAllDead() && this.singleEnemy.getIsDead();
    }
    public  boolean getIsCrashedWithPlayer(){
        return  this.isCrashedWithPlayer;
    }

    public boolean getIsDeadSingleEnemy() {
        return  this.singleEnemy.getIsDead();
    }

    public  int getXPositionSingleEnemy(){
        return this.singleEnemy.getXPosition();
    }

    public  int getYPositionSingleEnemy(){
        return this.singleEnemy.getYPosition();
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getInformationInvaders(){
        return this.groupEnemies.getInformationInvaders();
    }

    @Override
    public void run() {
        Thread singleInvaderThread = new Thread(this.singleEnemy);
        singleInvaderThread.start();
        while (!this.groupEnemies.isAllDead() && !this.getIsCrashedWithPlayer()) {
            this.verifyCollisionWithPlayer();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.groupEnemies.move();
        }
    }

}