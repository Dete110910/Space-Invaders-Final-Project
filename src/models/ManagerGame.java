package models;

public class ManagerGame {
    private ManagerEnemies managerEnemies;
    private ManagerPlayer managerPlayer;
    private final int ZERO =0;
    private int limitX;
    private int limitY;

    public ManagerGame(int width, int height) {
        managerEnemies= new ManagerEnemies( width, height);
        managerPlayer= new ManagerPlayer(width,height);
        limitX = width;
        limitY = height;
    }

    public ManagerEnemies getManagerEnemies() {
        return managerEnemies;
    }

    public ManagerPlayer getManagerPlayer() {
        return managerPlayer;
    }

    public  int getXPositionPlayer(){
        return managerPlayer.getCoordinates().getCoordenateX();
    }
    public  int getYPositionPlayer(){
        return managerPlayer.getCoordinates().getCoordenateY();
    }
    public void moveLeftPlayer(){
        if (getXPositionPlayer() > ZERO){
            managerPlayer.moveLeft();
        }
    }
    public void moveRightPlayer(){
        if (getXPositionPlayer() < limitY){
            managerPlayer.moveRight();
        }
    }
}
