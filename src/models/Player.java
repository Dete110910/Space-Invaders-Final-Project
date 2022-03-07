package models;

public class Player {
    private ShipPlayer shipPlayer;

    public Player(ShipPlayer shipPlayer) {
        this.shipPlayer = shipPlayer;
    }

    public ShipPlayer getShipPlayer() {
        return shipPlayer;
    }
}
