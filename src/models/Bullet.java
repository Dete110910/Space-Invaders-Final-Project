package models;

import java.util.ArrayList;

public abstract class Bullet implements Runnable {
    protected Coordinates coordinates;
    protected boolean isCrashed;
    protected static final byte VELOCITY = 10;

    public Bullet(Coordinates coordinates) {
        this.isCrashed = true;
        this.coordinates = coordinates;
    }

    public abstract void move();

    public abstract ArrayList<Coordinates> calculateCoordinates();

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

    public  Coordinates getCoordinates() {
        return coordinates;
    }

    public  void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public  boolean getIsCrashed() {
        return isCrashed;
    }

    public void setIsCrashed(boolean isCrashed){
        this.isCrashed = isCrashed;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "coordinates=" + coordinates +
                ", isCrashed=" + isCrashed +
                '}';
    }
}
