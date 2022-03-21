package views;

import javax.swing.*;
import java.awt.*;

public class TopGamePanel extends JPanel {

    private JLabel score, scorePoints;

    public TopGamePanel(){
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.initComponents();
    }

    private void initComponents(){
        score = new JLabel("Score: ");
        SettingsComponents.setCharacteristicsLabel(score,50);
        scorePoints = new JLabel("0");
        SettingsComponents.setCharacteristicsLabel(scorePoints,50);
        this.add(score);
        this.add(scorePoints);

    }


    public void updateScorePlayer(int scorePlayer) {
        this.scorePoints.setText(String.valueOf(scorePlayer));
    }
}
