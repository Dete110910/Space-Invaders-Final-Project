package models.managers;

import models.enums.TypeEnemy;
import models.entities.Coordinates;
import models.entities.Invader;

import java.util.ArrayList;

public class GroupEnemies {

    private static final byte SIZE_COLUM_ENEMIES = 7;
    private static final byte SIZE_ROW_ENEMIES = 4;
    private static final byte SPACE_BETWEEN_INVADERS = 25;
    private static final byte INIT_COORDINATE_X_ENEMY = 20;
    private static final byte INIT_COORDINATE_Y_ENEMY = 50;
    private static final byte QUANTITY_OF_ENEMIES = 28;
    private static final byte VELOCITY_ENEMY_Y = 10;
    private static final byte RIGHT_DIRECTION = 1;
    private static final byte LEFT_DIRECTION = 0;
    private static final byte MINIMUM_LIMIT_ARRAY = 0;
    private static final int RIGHT_LIMIT = 630;

    private byte xVelocityEnemy;
    private int lastPosition;
    private int firstPosition;
    private int lastRow;
    private byte direction;
    private ArrayList<ArrayList<Invader>> invadersList;
    private byte countEnemiesDead;

    public GroupEnemies() {
        this.invadersList = new ArrayList<>();
        this.initEnemies();

        this.xVelocityEnemy = 5;
        this.direction = 1;
        this.lastPosition = invadersList.get(0).size() - 1;
        this.firstPosition = 0;
        this.lastRow = invadersList.size() - 1;
        this.countEnemiesDead = 0;

    }

    public void initEnemies() {
        TypeEnemy[] enemies = TypeEnemy.values();
        for (int i = 0, auxYPosition = INIT_COORDINATE_Y_ENEMY; i < SIZE_ROW_ENEMIES; i++, auxYPosition += Invader.HEIGHT + SPACE_BETWEEN_INVADERS) {
            ArrayList<Invader> auxInvaderList = new ArrayList<>();
            for (int j = 0, auxXPosition = INIT_COORDINATE_X_ENEMY; j < SIZE_COLUM_ENEMIES; j++, auxXPosition += Invader.WIDTH + SPACE_BETWEEN_INVADERS) {
                Invader invader = new Invader(new Coordinates(auxXPosition, auxYPosition), enemies[(i < enemies.length - 1) ? i : i - 1]);
                auxInvaderList.add(invader);
            }
            this.invadersList.add(auxInvaderList);
        }
    }

    public void move() {
        if (!this.isAllDead()) {
            int direction = this.defineDirection();
            this.defineYPosition(direction);
            this.defineXPosition();
        }
    }

    private Coordinates verifyLast() {
        return (this.direction == RIGHT_DIRECTION) ? calculateCoordinatesLimitRight() : calculateCoordinatesLimitLeft();
    }

    private Coordinates calculateCoordinatesLimitRight() {
        Coordinates coordinatesLimit = null;
        boolean isFound = false;
        while (this.lastPosition >= MINIMUM_LIMIT_ARRAY && !isFound) {
            for (int i = this.invadersList.size() - 1; i >= 0 && !isFound; i--) {
                if (!this.invadersList.get(i).get(this.lastPosition).getIsDead()) {
                    coordinatesLimit = this.invadersList.get(i).get(this.lastPosition).getCoordinates();
                    isFound = true;
                }
            }
            if (!isFound)
                this.lastPosition--;
        }
        return coordinatesLimit;
    }

    private Coordinates calculateCoordinatesLimitLeft() {
        Coordinates coordinatesLimit = null;
        boolean isFound = false;
        while (this.firstPosition < SIZE_COLUM_ENEMIES && !isFound) {
            for (int i = this.invadersList.size() - 1; i >= 0 && !isFound; i--) {
                if (!this.invadersList.get(i).get(this.firstPosition).getIsDead()) {
                    coordinatesLimit = this.invadersList.get(i).get(this.firstPosition).getCoordinates();
                    isFound = true;
                }
            }
            if (!isFound)
                this.firstPosition++;
        }
        return coordinatesLimit;
    }

    public Coordinates calculateCoordinatesLimitLower() {
        Coordinates coordinatesLimit = null;
        boolean isFound = false;
        while (!isFound && this.lastRow >= MINIMUM_LIMIT_ARRAY) {
            for (int i = this.invadersList.get(this.lastRow).size() - 1; i >= 0 && !isFound; i--) {
                if (!this.invadersList.get(this.lastRow).get(i).getIsDead()) {
                    coordinatesLimit = this.invadersList.get(this.lastRow).get(i).getCoordinates();
                    isFound = true;
                }
            }
            if (!isFound) {
                this.lastRow--;
            }
        }
        return coordinatesLimit;
    }

    private int defineDirection() {
        Coordinates coordinates = this.verifyLast();
        if (coordinates.getCoordinateX() <= INIT_COORDINATE_X_ENEMY)
            return RIGHT_DIRECTION;
        else if (coordinates.getCoordinateX() >= RIGHT_LIMIT)
            return LEFT_DIRECTION;

        return this.direction;
    }

    private void defineXPosition() {
        int aux = this.xVelocityEnemy;
        if (this.direction == LEFT_DIRECTION)
            aux *= -1;
        for (ArrayList<Invader> invaders : this.invadersList)
            for (Invader invader : invaders)
                invader.setXCoordinates(invader.getCoordinates().getCoordinateX() + aux);
    }

    private void defineYPosition(int direction) {
        if (this.direction != direction) {
            for (ArrayList<Invader> rowList : this.invadersList)
                for (Invader invader : rowList)
                    invader.setYCoordinates(invader.getCoordinates().getCoordinateY() + VELOCITY_ENEMY_Y);
            this.direction = (byte) direction;
        }
    }

    public int makeCollision(ArrayList<Coordinates> coordinatesBullet) {
        for (int i = 0; i < this.invadersList.size(); i++)
            for (int j = 0; j < this.invadersList.get(i).size(); j++)
                if (!this.invadersList.get(i).get(j).getIsDead())
                    if (this.invadersList.get(i).get(j).verifyCollision(coordinatesBullet)) {
                        this.invadersList.get(i).get(j).setIsDead(true);
                        this.countEnemiesDead++;
                        return this.invadersList.get(i).get(j).getType().getValue();
                    }
        return 0;
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getInformationInvaders() {
        ArrayList<ArrayList<ArrayList<Integer>>> informationList = new ArrayList<>();
        for (ArrayList<Invader> rows : this.invadersList) {
            ArrayList<ArrayList<Integer>> informationRowList = new ArrayList<>();
            for (Invader invader : rows) {
                ArrayList<Integer> informationInvader = new ArrayList<>();
                informationInvader.add(invader.getCoordinates().getCoordinateX());
                informationInvader.add(invader.getCoordinates().getCoordinateY());
                informationInvader.add((invader.getIsDead()) ? 0 : 1);
                informationInvader.add(invader.getType().getType());
                informationRowList.add(informationInvader);
            }
            informationList.add(informationRowList);
        }
        return informationList;
    }

    public void incrementVelocity() {
        this.xVelocityEnemy++;
    }

    public boolean isAllDead() {
        return this.countEnemiesDead == QUANTITY_OF_ENEMIES;
    }
}
