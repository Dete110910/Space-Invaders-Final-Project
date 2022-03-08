package models;

public enum Enemies {
    ENEMY_BASIC(50), ENEMY_NORMAL(70), ENEMY_DIFFICULT(100);
    private int value;

    Enemies(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
