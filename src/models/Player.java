package models;

public class Player {
    private Coordinates coordinates;
    private final byte SPEED = 5;
    public static final byte WIDTH = 60;

    public Player(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void moveLeft(){
        coordinates.setCoordenateX(coordinates.getCoordenateX()-SPEED);
    }
    public void moveRight(){
        coordinates.setCoordenateX(coordinates.getCoordenateX()+SPEED);
    }


}
