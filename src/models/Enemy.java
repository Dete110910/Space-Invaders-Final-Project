package models;

import java.util.ArrayList;

public abstract class Enemy {

    protected Coordinates coordinates;
    protected int direction;
    protected boolean isDead;
    public Enemy(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.isDead = false;
    }

    public abstract int move();


    public abstract boolean verifyCollition(ArrayList<Coordinates> coordinates);
}
