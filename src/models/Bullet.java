package models;

public class Bullet implements Runnable {
    private Coordinates coordinates;
    private final byte VELOCITY = 30;

    public Bullet(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void move() {
        if (coordinates.getCoordenateY() >= 0)
            coordinates.setCoordenateY(coordinates.getCoordenateY() - VELOCITY);
    }

    @Override
    public void run() {
        this.move();
    }
}
