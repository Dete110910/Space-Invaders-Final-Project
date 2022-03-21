package views.panels;

import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;

public class TopGamePanel extends JPanel {

    private static final String SCORE = "Score: ";

    private JLabel score, scorePoints;

    public TopGamePanel() {
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.initComponents();
    }

    private void initComponents() {
        this.score = new JLabel(SCORE);
        SettingsComponents.setCharacteristicsLabel(score, 50);
        this.scorePoints = new JLabel("0");
        SettingsComponents.setCharacteristicsLabel(this.scorePoints, 50);
        this.add(this.score);
        this.add(this.scorePoints);
    }

    public void updateScorePlayer(int scorePlayer) {
        this.scorePoints.setText(String.valueOf(scorePlayer));
    }
}
