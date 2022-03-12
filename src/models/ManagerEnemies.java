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


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleEnemy.move();
            groupEnemies.move();
        }
    }
}