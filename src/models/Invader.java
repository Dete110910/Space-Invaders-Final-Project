package models;

import java.util.ArrayList;

public class Invader extends Enemy {

    public static final byte WIDTH = 40;
    public static final byte HEIGHT = 32;

    public Invader(Coordinates coordinates, TypeEnemy type) {
        super(coordinates);
        this.type = type;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setXCoordinates(int xCoordinate) {
        coordinates.setCoordenateX(xCoordinate);
    }

    public void setYCoordinates(int yCoordinate) {
        coordinates.setCoordenateY(yCoordinate);
    }

    @Override
    public int move() {
        return 0;
    }


    @Override
    public boolean verifyCollition(ArrayList<Coordinates> coordinates) {
        if (!this.getIsDead())
            if (this.coordinates.getCoordenateX() <= coordinates.get(0).getCoordenateX()
                    && this.coordinates.getCoordenateX() + WIDTH >= coordinates.get(1).getCoordenateX()
                    && this.coordinates.getCoordenateY() <= coordinates.get(0).getCoordenateY()
                    && this.coordinates.getCoordenateY() + HEIGHT >= coordinates.get(1).getCoordenateY())
                return true;
        return false;
    }


    @Override
    public String toString() {
        return "Invader{" +
                "coordinates=" + coordinates +
                '}';
    }
}
