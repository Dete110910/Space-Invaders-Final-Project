package models;

import java.util.ArrayList;

public class ManagerEnemies implements Runnable {

    private SingleEnemy singleEnemy;
    private GroupEnemies groupEnemies;
    private final byte INIT_COORDINATE_X_SINGLE_ENEMY = -10;
    private final byte INIT_COORDINATE_Y_SINGLE_ENEMY = 10;


    public ManagerEnemies() {
        this.singleEnemy = new SingleEnemy(new Coordinates(INIT_COORDINATE_X_SINGLE_ENEMY, INIT_COORDINATE_Y_SINGLE_ENEMY));
        this.groupEnemies = new GroupEnemies();
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

    public boolean verifyCollitions(ArrayList<Coordinates> coordinatesBullet){
        return this.groupEnemies.verifyIsCrashed(coordinatesBullet);
    }

    @Override
    public void run() {
        Thread singleInvaderThread = new Thread(this.singleEnemy);
        singleInvaderThread.start();
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            groupEnemies.move();
        }
    }

}