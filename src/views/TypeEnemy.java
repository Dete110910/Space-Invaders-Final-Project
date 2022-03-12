package views;

public enum TypeEnemy {
    ENEMY_BASIC("src/rsc/enemyBasic.png"), ENEMY_NORMAL("src/rsc/enemyNormal.png"), ENEMY_DIFFICULT("src/rsc/enemyDifficult.png");
    private String src;

    TypeEnemy(String src){
        this.src = src;
    }

    public String getSrc(){
        return src;
    }
}
