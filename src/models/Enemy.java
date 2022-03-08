package models;

public abstract class Enemy {
private Coordinates coordinates;
    private int  direction;
    public Enemy(Coordinates coordinates) {
        this.coordinates= coordinates;
    }

    public abstract int  move();

    public abstract void defineXPosition();

    public abstract void defineDirection();
}
