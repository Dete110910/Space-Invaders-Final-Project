package models;

import java.util.ArrayList;

public class ManagerEnemies implements Runnable {

    private SingleEnemy singleEnemy;
    private GroupEnemies groupEnemies;
    private final byte INIT_COORDINATE_X_SINGLE_ENEMY = -10;
    private final byte INIT_COORDINATE_Y_SINGLE_ENEMY = 10;
    private boolean isCrashedWithPlayer;


    public ManagerEnemies() {
        this.singleEnemy = new SingleEnemy(new Coordinates(INIT_COORDINATE_X_SINGLE_ENEMY, INIT_COORDINATE_Y_SINGLE_ENEMY));
        this.groupEnemies = new GroupEnemies();
        this.isCrashedWithPlayer = false;
        singleEnemy.isDead = true;
    }

    public SingleEnemy getSingleEnemy() {
        return singleEnemy;
    }
    public  int getXPositionSingleEnemy(){
        return singleEnemy.getXPosition();
    }
    public  int getYPositionSingleEnemy(){
        return singleEnemy.getYPosition();
    }
    public ArrayList<ArrayList<ArrayList<Integer>>> getInformationInvaders(){
        return groupEnemies.getInformationInvaders();
    }

    public boolean verifyCollitionsGroupEnemies(ArrayList<Coordinates> coordinatesBullet){
        return this.groupEnemies.verifyIsCrashed(coordinatesBullet);
    }
    public void incrementVelocityEnemies() {
        groupEnemies.incrementVelocity();
    }

    public boolean verifyCollitionSingleEnemies(ArrayList<Coordinates> calculateCoordinates) {
        return  this.singleEnemy.verifyCollition(calculateCoordinates);
    }

    public boolean getIsDeadSingleEnemy() {
        return  this.singleEnemy.getIsDead();
    }
    public boolean verifyCollitionWithPlayer(){
        Coordinates lastCoordinate = this.groupEnemies.calculateCoordinatesLimitLower();
        if(lastCoordinate.getCoordenateY() >=580) {
            this.isCrashedWithPlayer = true;
            this.singleEnemy.isDead = true;
        }
        return this.isCrashedWithPlayer;
    }
    public  boolean getIsCrashedWithPlayer(){
        return  this.isCrashedWithPlayer;
    }

    public boolean isAllEnemiesDead(){
        return  (groupEnemies.isAllDead() && singleEnemy.getIsDead())?true:false;
    }
    @Override
    public void run() {
        Thread singleInvaderThread = new Thread(this.singleEnemy);
        singleInvaderThread.start();
        while (!groupEnemies.isAllDead() && !verifyCollitionWithPlayer()) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            groupEnemies.move();
        }
    }


}