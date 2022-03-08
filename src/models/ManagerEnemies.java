package models;

public class ManagerEnemies {
    private SingleShip shipSingle;

    public ManagerEnemies() {
        this.shipSingle = new SingleShip(new Coordinates(-10,10));
    }

    public SingleShip getShipSingle() {
        return shipSingle;
    }
}
