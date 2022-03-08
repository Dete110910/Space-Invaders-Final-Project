package models;

public class ManagerPlayer {
    private Player player;

    public ManagerPlayer(int width , int height) {
        this.player = new Player(new Coordinates(width/2, height-100));
    }

    public Player getPlayer() {
        return player;
    }

    public Coordinates getCoordinates(){
        return  player.getCoordinates();
    }

    public void moveLeft(){
        player.moveLeft();
    }
    public void moveRight(){
        player.moveRight();
    }
}
