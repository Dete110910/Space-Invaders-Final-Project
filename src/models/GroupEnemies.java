package models;

import java.util.ArrayList;

public class GroupEnemies {

    private final byte SIZE_COLUM_ENEMIES = 7;
    private final byte SIZE_ROW_ENEMIES = 4;
    private final byte SPACE_BETWEEN_INVADERS = 25;
    private final byte INIT_COORDINATE_X_ENEMY = 20;
    private final byte INIT_COORDINATE_Y_ENEMY = 50;
    private final byte VELOCITY_ENEMY = 5;
    private final byte VELOCITY_ENEMY_Y = 5;
    private byte direction;
    private ArrayList<ArrayList<Invader>> invadersList;

    public GroupEnemies() {
        invadersList = new ArrayList<>();
        this.direction = 1;
        this.initEnemies();

    }

    public void initEnemies() {
        TypeEnemy[] enemies = TypeEnemy.values();
        for (int i = 0, auxYPosition = INIT_COORDINATE_Y_ENEMY; i < SIZE_ROW_ENEMIES; i++, auxYPosition += Invader.HEIGHT + SPACE_BETWEEN_INVADERS) {
            ArrayList<Invader> auxInvaderList = new ArrayList<>();
            for (int j = 0, auxXPosition = INIT_COORDINATE_X_ENEMY; j < SIZE_COLUM_ENEMIES; j++, auxXPosition += Invader.WIDTH + SPACE_BETWEEN_INVADERS) {
                Invader invader = new Invader(new Coordinates(auxXPosition, auxYPosition), enemies[(i < enemies.length) ? i : i - 1]);
                auxInvaderList.add(invader);
            }
            invadersList.add(auxInvaderList);
        }

    }

    public void move() {
        int direction = this.defineDirection();
        this.defineYPosition(direction);
        this.defineXPosition();

    }

    private Coordinates verifyLast() {
        if (direction == 1) {
            for (int i = invadersList.size() - 1; i >= 0; i--) {
                for (int j = invadersList.get(i).size()-1; j >=0; j--) {
                    if (!invadersList.get(i).get(j).getIsDead()) {
                        return invadersList.get(i).get(j).getCoordinates();
                    }
                }
            }
        } else {
            for (ArrayList<Invader> invaders : invadersList) {
                for (Invader invader : invaders) {
                    if (!invader.getIsDead()) {
                        return invader.getCoordinates();
                    }
                }
            }
        }
        return new Coordinates(-5, -5);
    }

    public void win() {

    }

    private int defineDirection() {
        Coordinates coordinates = this.verifyLast();
        if (coordinates.getCoordenateX() <= INIT_COORDINATE_X_ENEMY) {
            return 1;
        } else if (coordinates.getCoordenateX() >= 620) {
            return 0;
        }
        return direction;
    }

    private void defineXPosition() {
        int aux = VELOCITY_ENEMY;
        if (direction == 0) {
            aux *= -1;
        }
        for (ArrayList<Invader> invaders : invadersList) {
            for (Invader invader : invaders) {
                invader.setXCoordinates(invader.getCoordinates().getCoordenateX() + aux);
            }
        }
    }

    private void defineYPosition(int direction) {
        if (this.direction != direction) {
            for (ArrayList<Invader> rowList : invadersList) {
                for (Invader invader : rowList) {
                    invader.setYCoordinates(invader.getCoordinates().getCoordenateY() + VELOCITY_ENEMY_Y);
                }
            }
            this.direction = (byte) direction;
        }

    }

    public boolean verifyIsCrashed(ArrayList<Coordinates> coordinatesBullet) {
        for (int i = 0; i < invadersList.size(); i++) {
            for (int j = 0; j < invadersList.get(i).size(); j++) {
                if (!invadersList.get(i).get(j).getIsDead()) {
                    if (invadersList.get(i).get(j).verifyCollition(coordinatesBullet)) {
                        System.out.println("Entro en group Enemies");
                        invadersList.get(i).get(j).setDead(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getInformationInvaders() {
        ArrayList<ArrayList<ArrayList<Integer>>> informationList = new ArrayList<>();
        for (ArrayList<Invader> rows : invadersList) {
            ArrayList<ArrayList<Integer>> informationRowList = new ArrayList<>();
            for (Invader invader : rows) {
                ArrayList<Integer> informationInvader = new ArrayList<>();
                informationInvader.add(invader.getCoordinates().getCoordenateX());
                informationInvader.add(invader.getCoordinates().getCoordenateY());
                informationInvader.add((invader.getIsDead()) ? 0 : 1);
                informationInvader.add(invader.getType().getType());
                informationRowList.add(informationInvader);
            }
            informationList.add(informationRowList);
        }
        return informationList;
    }

}
