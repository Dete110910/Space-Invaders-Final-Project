package models.managers;

import models.entities.Coordinates;
import models.entities.Player;

public class ManagerPlayer {

    private Player player;

    public ManagerPlayer(int width , int height) {
        this.player = new Player(new Coordinates(width/2, height-100));
    }

    public void moveLeft(){
        this.player.moveLeft();
    }

    public void moveRight(){
        this.player.moveRight();
    }

    public void addScore(int score) {
        this.player.addScore(score);
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getScore() {
        return this.player.getScore();
    }

    public Coordinates getCoordinates(){
        return  this.player.getCoordinates();
    }
}
