package models.entities;

import models.enums.TypeEnemy;

import java.util.ArrayList;


public class SingleEnemy extends Enemy implements Runnable {

    private static final byte LEFT_LIMIT = 0;
    private static final int RIGHT_LIMIT = 680;
    private static final byte VELOCITY = 15;
    private static final byte WIDTH = 40;
    private static final byte HEIGHT = 20;
    private static final byte RIGHT_DIRECTION = 1;
    private static final byte LEFT_DIRECTION = 0;

    public SingleEnemy(Coordinates coordinates) {
        super(coordinates);
        this.setType(TypeEnemy.SINGLE_ENEMY);
    }

    public void move() {
        defineDirection();
        defineXPosition();
    }

    public void defineXPosition() {
        if (this.direction == RIGHT_DIRECTION)
            this.coordinates.setCoordinateX(this.coordinates.getCoordinateX() + VELOCITY);
        else
            this.coordinates.setCoordinateX(this.coordinates.getCoordinateX() - VELOCITY);

    }

    public void defineDirection() {
        if (this.coordinates.getCoordinateX() <= LEFT_LIMIT)
            this.direction = RIGHT_DIRECTION;
        else if (this.coordinates.getCoordinateX() >= RIGHT_LIMIT)
            this.direction = LEFT_DIRECTION;

    }

    @Override
    public boolean verifyCollision(ArrayList<Coordinates> coordinates) {
        if (this.coordinates.getCoordinateX() <= coordinates.get(0).getCoordinateX()
                && this.coordinates.getCoordinateX() + WIDTH >= coordinates.get(1).getCoordinateX()
                && this.coordinates.getCoordinateY() <= coordinates.get(0).getCoordinateY()
                && this.coordinates.getCoordinateY() + HEIGHT >= coordinates.get(1).getCoordinateY()) {
            this.isDead = true;
            return true;
        }
        return false;
    }


    public int getXPosition() {
        return coordinates.getCoordinateX();
    }

    public int getYPosition() {
        return coordinates.getCoordinateY();
    }

    @Override
    public void run() {
        while (!isDead) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.move();
        }
    }

}
