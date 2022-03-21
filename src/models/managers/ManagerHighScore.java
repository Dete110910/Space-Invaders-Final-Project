package models.managers;

import java.util.ArrayList;

public class ManagerHighScore {

    private Score[] highScoresList;

    public ManagerHighScore() {
        this.highScoresList = new Score[5];
    }

    public void addScore(String name, int score) {
        Score newScore = new Score(name, score);
        boolean isAdd = false;
        for (int i = 0; i < this.highScoresList.length && !isAdd; i++)
            if (this.highScoresList[i].getScore() < score) {
                this.changeList(newScore, i);
                isAdd = true;
            }
    }

    private void changeList(Score score, int position) {
        Score scoreToChange = score;
        for (int i = position; i < this.highScoresList.length; i++) {
            Score aux = this.highScoresList[i];
            this.highScoresList[i] = scoreToChange;
            scoreToChange = aux;
        }
    }

    public ArrayList<String> getInformationHighScores() {
        ArrayList<String> informationHighScores = new ArrayList<>();
        for (Score score : this.highScoresList) {
            informationHighScores.add(score.getName());
            informationHighScores.add(String.valueOf(score.getScore()));
        }
        return informationHighScores;
    }
}
