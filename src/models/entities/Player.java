package models.entities;

public class Player {

    private static final byte SPEED = 5;
    public static final byte WIDTH = 60;

    private Coordinates coordinates;
    private int score;

    public Player(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.score = 0;
    }

    public void moveLeft() {
        coordinates.setCoordinateX(coordinates.getCoordinateX() - SPEED);
    }

    public void moveRight() {
        coordinates.setCoordinateX(coordinates.getCoordinateX() + SPEED);
    }

    public void addScore(int score) {
        this.score += score;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getScore() {
        return this.score;
    }
}
