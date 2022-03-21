package models;

import java.util.ArrayList;

public abstract class Enemy {

    protected Coordinates coordinates;
    protected int direction;
    protected boolean isDead;
    protected TypeEnemy type;

    public Enemy(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.isDead = false;
    }

    public abstract int move();


    public abstract boolean verifyCollition(ArrayList<Coordinates> coordinates);

    public TypeEnemy getType() {
        return type;
    }

    public void setType(TypeEnemy type) {
        this.type = type;
    }
}

