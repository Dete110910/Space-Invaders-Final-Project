package models;

public class ShipPlayer extends Enemy{
    private int xPosition;
    public ShipPlayer(Coordinates coordinates) {
        super(coordinates);
        xPosition= coordinates.getCoordenateX();
    }

    @Override
    public int move() {
        return 0;
    }


    public int move(int xPosition) {
        return this.xPosition+=xPosition;
    }

    @Override
    public void defineXposition() {

    }

    @Override
    public void defineDirection() {

    }
}
