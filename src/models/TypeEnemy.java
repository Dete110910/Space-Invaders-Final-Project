package models;

public enum TypeEnemy {
    ENEMY_BASIC(50), ENEMY_NORMAL(70), ENEMY_DIFFICULT(100);
    private int value;

    TypeEnemy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
