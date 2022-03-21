package models.entities;

import models.enums.TypeEnemy;

import java.util.ArrayList;

public class Invader extends Enemy {

    public static final byte WIDTH = 40;
    public static final byte HEIGHT = 32;

    public Invader(Coordinates coordinates, TypeEnemy type) {
        super(coordinates);
        this.type = type;
    }

    @Override
    public boolean verifyCollision(ArrayList<Coordinates> coordinates) {
        if (!this.getIsDead())
            if (this.coordinates.getCoordinateX() <= coordinates.get(0).getCoordinateX()
                    && this.coordinates.getCoordinateX() + WIDTH >= coordinates.get(1).getCoordinateX()
                    && this.coordinates.getCoordinateY() <= coordinates.get(0).getCoordinateY()
                    && this.coordinates.getCoordinateY() + HEIGHT >= coordinates.get(1).getCoordinateY())
                return true;
        return false;
    }


}
