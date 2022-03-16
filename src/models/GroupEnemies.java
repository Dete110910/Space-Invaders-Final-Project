package models;

import java.util.ArrayList;

public class GroupEnemies {

    private final byte SIZE_COLUM_ENEMIES = 7;
    private final byte SIZE_ROW_ENEMIES = 4;
    private final byte SPACE_BETWEEN_INVADERS = 15;
    private final byte INIT_COORDINATE_X_ENEMY = 10;
    private final byte INIT_COORDINATE_Y_ENEMY = 50;
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
            ArrayList<Invader> auxInvaderList = new ArrayList();
            for (int j = 0, auxXPosition = INIT_COORDINATE_X_ENEMY; j < SIZE_COLUM_ENEMIES; j++, auxXPosition += Invader.WIDTH + SPACE_BETWEEN_INVADERS) {
                Invader invader = new Invader(new Coordinates(auxXPosition, auxYPosition), enemies[(i < enemies.length) ? i : i - 1]);
                auxInvaderList.add(invader);
            }
            invadersList.add(auxInvaderList);
        }
    }

    public void move() {
        this.defineDirection();
        this.defineXPosition();
        this.defineYPosition();

    }

    private Coordinates verifyLast() {
        if (direction == 1) {
            for (int i = invadersList.size() - 1; i >= 0; i--) { //¿menos 1?
                for (int j = 0; j < invadersList.get(i).size(); j++) {
                    if (!invadersList.get(i).get(j).isDead()) {
                        return invadersList.get(i).get(j).getCoordinates();
                    }
                }
            }
        } else {
            for (int i = 0; i < invadersList.size() - 1; i++) { //¿menos 1?
                for (int j = 0; j < invadersList.get(i).size(); j++) {
                    if (!invadersList.get(i).get(j).isDead()) {
                        return invadersList.get(i).get(j).getCoordinates();
                    }
                }
            }
        }
        return new Coordinates(-5, -5);
    }

    public void win() {

    }

    private void defineDirection() {
        Coordinates coordinates = this.verifyLast();
        if (coordinates.getCoordenateX() <= 0) {
            this.direction = 1;
        } else if (coordinates.getCoordenateY() >= 680) {
            this.direction = 0;
        }
    }

    private void defineXPosition() {
        int aux = Invader.WIDTH + SPACE_BETWEEN_INVADERS;
        if (direction == 0) {
            aux *= -1;
        }
        for (int i = 0; i < invadersList.size(); i++) {
            for (int j = 0; j < invadersList.get(i).size(); j++) {
                Invader invader = invadersList.get(i).get(j);
                invader.setXCoordinates(invader.getCoordinates().getCoordenateX() + aux);
            }
        }
        System.out.println(invadersList);
    }

    private void defineYPosition() {
    }
}
