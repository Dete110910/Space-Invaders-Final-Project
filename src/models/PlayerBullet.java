package models;

public class PlayerBullet extends Bullet{

    public PlayerBullet(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public void move() {
        if (this.coordinates.getCoordenateY() >= 0)
            coordinates.setCoordenateY(coordinates.getCoordenateY() - VELOCITY);
        else
            isCrashed = true;
    }

    @Override
    public void verifyIsCrashes() {

    }



}
