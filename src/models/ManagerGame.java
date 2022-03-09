package models;

public class ManagerGame {
    private ManagerEnemies managerEnemies;
    private ManagerPlayer managerPlayer;

    public ManagerGame(int wide, int height) {
        managerEnemies= new ManagerEnemies(new ShipSingle(new Coordinates(wide, height-30)));
        managerPlayer= new ManagerPlayer(new Player(new ShipPlayer(new Coordinates(wide, height-30))));
    }

    public ManagerEnemies getManagerEnemies() {
        return managerEnemies;
    }

    public ManagerPlayer getManagerPlayer() {
        return managerPlayer;
    }
}
