package models;

public class ManagerEnemies {
    private SingleEnemy shipSingle;

    public ManagerEnemies(int x, int y) {
        this.shipSingle = new SingleEnemy(new Coordinates(x,y));
    }

    public SingleEnemy getShipSingle() {
        return shipSingle;
    }
}
