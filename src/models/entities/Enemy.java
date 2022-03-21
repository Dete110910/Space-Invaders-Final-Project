package models.entities;

import models.enums.TypeEnemy;

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


    public abstract boolean verifyCollision(ArrayList<Coordinates> coordinates);

    public TypeEnemy getType() {
        return type;
    }

    public void setType(TypeEnemy type) {
        this.type = type;
    }

    public boolean getIsDead(){
        return  this.isDead;
    }

    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setXCoordinates(int xCoordinate) {
        coordinates.setCoordinateX(xCoordinate);
    }

    public void setYCoordinates(int yCoordinate) {
        coordinates.setCoordinateY(yCoordinate);
    }


}

