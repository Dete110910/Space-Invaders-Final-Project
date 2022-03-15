package models;

public enum TypeEnemy {
    ENEMY_BASIC(50,2), ENEMY_NORMAL(70,1), ENEMY_DIFFICULT(100,0);
    private int value;
    private int type;

    TypeEnemy(int value, int type) {
        this.value = value;
        this.type = type;
    }


    public int getValue() {
        return value;
    }

    public int getType() {
        return type;
    }
}
