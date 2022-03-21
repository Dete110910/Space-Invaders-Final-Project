package models.entities;

import java.util.ArrayList;

public abstract class Bullet implements Runnable {

    protected static final byte VELOCITY = 10;

    protected Coordinates coordinates;
    protected boolean isCrashed;

    public Bullet(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.isCrashed = true;
    }

    public abstract void move();

    public abstract ArrayList<Coordinates> calculateCoordinates();

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean getIsCrashed() {
        return isCrashed;
    }

    public void setIsCrashed(boolean isCrashed) {
        this.isCrashed = isCrashed;
    }

    @Override
    public void run() {
        while (!isCrashed) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.move();
        }
    }


}
