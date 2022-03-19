package models;

import java.util.ArrayList;

public class SingleEnemy extends Enemy implements  Runnable {

    private static final byte VELOCITY = 7;

    public SingleEnemy(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public int move() {
        defineDirection();
        defineXPosition();
        return this.coordinates.getCoordenateX();
    }

    public void defineXPosition() {
        if (this.direction == 1) {
            this.coordinates.setCoordenateX(this.coordinates.getCoordenateX() + VELOCITY);
        } else {
            this.coordinates.setCoordenateX(this.coordinates.getCoordenateX() - VELOCITY);
        }

    }

    public void defineDirection() {
        if (this.coordinates.getCoordenateX() <= 0) {
            this.direction = 1;
        } else if (this.coordinates.getCoordenateX() >= 680) {
            this.direction = 0;
        }
    }

    @Override
    public boolean verifyCollition(ArrayList<Coordinates> coordinates) {
        return false;
    }


    public int getXPosition() {
        return coordinates.getCoordenateX();
    }

    public int getYPosition() {
        return coordinates.getCoordenateY();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.move();
        }
    }
}
