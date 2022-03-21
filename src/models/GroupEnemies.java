package models;

import java.util.ArrayList;

public class GroupEnemies {

    private final byte SIZE_COLUM_ENEMIES = 7;
    private final byte SIZE_ROW_ENEMIES = 4;
    private final byte SPACE_BETWEEN_INVADERS = 25;
    private final byte INIT_COORDINATE_X_ENEMY = 20;
    private final byte INIT_COORDINATE_Y_ENEMY = 50;
    private final byte QUANTITY_OF_ENEMIES = 28;
    private byte xVelocityEnemy;
    private final byte VELOCITY_ENEMY_Y = 10;
    private int lastPosition;
    private int firstPosition;
    private int lastRow;
    private byte direction;
    private ArrayList<ArrayList<Invader>> invadersList;
    private byte countEnemiesDead;

    public GroupEnemies() {
        invadersList = new ArrayList<>();
        this.xVelocityEnemy = 5;
        this.direction = 1;
        this.initEnemies();
        this.lastPosition = invadersList.get(0).size() - 1;
        this.firstPosition = 0;
        this.lastRow = invadersList.size()-1;
        this.countEnemiesDead = 0;

    }

    public void initEnemies() {
        TypeEnemy[] enemies = TypeEnemy.values();
        for (int i = 0, auxYPosition = INIT_COORDINATE_Y_ENEMY; i < SIZE_ROW_ENEMIES; i++, auxYPosition += Invader.HEIGHT + SPACE_BETWEEN_INVADERS) {
            ArrayList<Invader> auxInvaderList = new ArrayList<>();
            for (int j = 0, auxXPosition = INIT_COORDINATE_X_ENEMY; j < SIZE_COLUM_ENEMIES; j++, auxXPosition += Invader.WIDTH + SPACE_BETWEEN_INVADERS) {
                Invader invader = new Invader(new Coordinates(auxXPosition, auxYPosition), enemies[(i < enemies.length-1) ? i : i - 1]);
                auxInvaderList.add(invader);
            }
            invadersList.add(auxInvaderList);
        }

    }

    public void move() {
        if(!this.isAllDead()) {
            int direction = this.defineDirection();
            this.defineYPosition(direction);
            this.defineXPosition();
        }
    }

    private Coordinates verifyLast() {
        return (direction == 1) ? calculateCoordinatesLimitRight() : calculateCoordinatesLimitLeft();
    }

    private Coordinates calculateCoordinatesLimitRight() {
        Coordinates coordinatesLimit = null;
        boolean isFound = false;
        while (lastPosition >= 0 && !isFound) {
            for (int i = invadersList.size() - 1; i >= 0 && !isFound; i--) {
                if (!invadersList.get(i).get(this.lastPosition).getIsDead()) {
                    coordinatesLimit = invadersList.get(i).get(this.lastPosition).getCoordinates();
                    isFound = true;
                }
            }
            if (!isFound)
                lastPosition--;
        }
        return coordinatesLimit;
    }

    private Coordinates calculateCoordinatesLimitLeft() {
        Coordinates coordinatesLimit = null;
        boolean isFound = false;
        while (firstPosition < 7 && !isFound) {
            for (int i = invadersList.size() - 1; i >= 0 && !isFound; i--) {
                if (!invadersList.get(i).get(this.firstPosition).getIsDead()) {
                    coordinatesLimit = invadersList.get(i).get(this.firstPosition).getCoordinates();
                    isFound = true;
                }
            }
            if (!isFound)
                firstPosition++;
        }
        return coordinatesLimit;
    }

    public Coordinates calculateCoordinatesLimitLower(){
        Coordinates coordinatesLimit = null;
        boolean isFound = false;
        while(!isFound && lastRow>=0) {
            for (int i = invadersList.get(lastRow).size() - 1; i >= 0&& !isFound; i--) {
                if (!invadersList.get(lastRow).get(i).getIsDead()) {
                    coordinatesLimit = invadersList.get(lastRow).get(i).getCoordinates();
                    isFound = true;
                }
            }
            if (!isFound){
                lastRow--;
            }
        }
        return  coordinatesLimit;
    }

    private int defineDirection() {
        Coordinates coordinates = this.verifyLast();
        if (coordinates.getCoordenateX() <= INIT_COORDINATE_X_ENEMY) {
            return 1;
        } else if (coordinates.getCoordenateX() >= 600) {
            return 0;
        }
        return direction;
    }

    private void defineXPosition() {
        int aux = xVelocityEnemy;
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

    public int verifyIsCrashed(ArrayList<Coordinates> coordinatesBullet) {
        for (int i = 0; i < invadersList.size(); i++) {
            for (int j = 0; j < invadersList.get(i).size(); j++) {
                if (!invadersList.get(i).get(j).getIsDead()) {
                    if (invadersList.get(i).get(j).verifyCollition(coordinatesBullet)) {
                        invadersList.get(i).get(j).setDead(true);
                        this.countEnemiesDead++;
                        return invadersList.get(i).get(j).getType().getValue();
                    }
                }
            }
        }
        return 0;
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

    public void incrementVelocity() {
        xVelocityEnemy++;
    }
    public boolean isAllDead(){
        return  (countEnemiesDead ==QUANTITY_OF_ENEMIES)?true:false;
    }
}
