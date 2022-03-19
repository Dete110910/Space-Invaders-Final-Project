package models;

import java.util.ArrayList;

public class PlayerBullet extends Bullet{
    private final byte WIDTH = 5;
    private final byte HIGH = 8;

    public PlayerBullet(Coordinates coordinates) {
        super(coordinates);
    }
    public PlayerBullet(){
        super(new Coordinates(0,0));
        this.isCrashed = true;
    }
    @Override
    public void move() {
        if (this.coordinates.getCoordenateY() >= -10)
            coordinates.setCoordenateY(coordinates.getCoordenateY() - VELOCITY);
        else
            isCrashed = true;
    }

    @Override
    public void verifyIsCrashes() {

    }

    @Override
    public ArrayList<Coordinates> calculateCoordinates() {
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(coordinates);
        coordinatesList.add(new Coordinates(coordinates.getCoordenateX()  + WIDTH, coordinates.getCoordenateY() + HIGH));
        return coordinatesList;
    }

}
