package models;

public class SingleEnemy extends Enemy {

    private static final byte VELOCITY = 20;

    public SingleEnemy(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public int move() {
        defineDirection();
        defineXPosition();
        return this.coordinates.getCoordenateX();
    }

    @Override
    public void defineXPosition() {
        if (this.direction == 1) {
            this.coordinates.setCoordenateX(this.coordinates.getCoordenateX() + VELOCITY);
        } else {
            this.coordinates.setCoordenateX(this.coordinates.getCoordenateX() - VELOCITY);
        }

    }

    @Override
    public void defineDirection() {
        if (this.coordinates.getCoordenateX() <= 0) {
            this.direction = 1;
        } else if (this.coordinates.getCoordenateX() >= 680) {
            this.direction = 0;
        }
    }

    public int getXPosition() {
        return coordinates.getCoordenateX();
    }

    public int getYPosition() {
        return coordinates.getCoordenateY();
    }
}
