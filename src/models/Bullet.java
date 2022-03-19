package models;

import java.util.ArrayList;

public abstract class Bullet implements Runnable {
    protected Coordinates coordinates;
    protected boolean isCrashed;
    protected static final byte VELOCITY = 5;

    public Bullet(Coordinates coordinates) {
        this.isCrashed = false;
        this.coordinates = coordinates;
    }

    public abstract void move();

    public abstract void verifyIsCrashes();

    public abstract ArrayList<Coordinates> calculateCoordinates();

    @Override
    public void run() {
        while (!isCrashed){
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            this.move();
            this.verifyIsCrashes();
        }
    }


}
