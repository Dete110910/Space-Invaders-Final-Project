package models.entities;

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
    public synchronized void move() {
        if (this.getCoordinates().getCoordinateY() >= VELOCITY)
            this.getCoordinates().setCoordinateY(this.getCoordinates().getCoordinateY() - VELOCITY);
        else
            this.setIsCrashed(true);

    }

    @Override
    public ArrayList<Coordinates> calculateCoordinates() {
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(this.getCoordinates());
        coordinatesList.add(new Coordinates(this.getCoordinates().getCoordinateX()  + WIDTH, this.getCoordinates().getCoordinateY() + HIGH));
        return coordinatesList;
    }

}
