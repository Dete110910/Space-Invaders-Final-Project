package models;

import java.util.ArrayList;

public class ManagerHighScore {
    
    Score[] highScoresList;
    
    public ManagerHighScore (){
        highScoresList = new Score[5];
        for (int i = 0; i < highScoresList.length; i++) {
            highScoresList[i] = new Score(" .|.", i);
        }
    }
    public void addScore(String name, int score){
        Score newScore = new Score(name, score);
        boolean isAdd = false;
        for (int i = 0; i <highScoresList.length && !isAdd; i++) {
            if(highScoresList[i].getScore() < score ){
                this.changeList(newScore,i);
                isAdd = true;
            }
        }
    }

    private void changeList(Score score, int position) {
        Score scoreToChange = score;
        for (int i = position; i < highScoresList.length; i++) {
            Score aux = highScoresList[i];
            highScoresList[i] = scoreToChange;
            scoreToChange = aux;
        }
    }

    public ArrayList<String> getInformationHighScores() {
        ArrayList<String> informationHighScores = new ArrayList<>();
        for (Score score:highScoresList) {
            informationHighScores.add(score.getName());
            informationHighScores.add(String.valueOf(score.getScore()));
        }
        return  informationHighScores;
    }
}
