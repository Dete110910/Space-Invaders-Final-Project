package models;

public class Invader extends Enemy {

    public static final byte WIDTH = 40;
    public static final byte HEIGHT = 32;
    private boolean isDead;
    private TypeEnemy type;

    public Invader(Coordinates coordinates, TypeEnemy type) {
        super(coordinates);
        this.isDead = false;
        this.type = type;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public TypeEnemy getType() {
        return type;
    }

    public void setType(TypeEnemy type) {
        this.type = type;
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
    public void defineXPosition() {

    }

    @Override
    public void defineDirection() {

    }

    @Override
    public String toString() {
        return "Invader{" +
                "coordinates=" + coordinates +
                '}';
    }
}
