package models;

import java.util.ArrayList;

public abstract class Enemy {

    protected Coordinates coordinates;
    protected int direction;

    public Enemy(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public abstract int move();


    public abstract boolean verifyCollition(ArrayList<Coordinates> coordinates);
}
