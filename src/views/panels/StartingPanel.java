package views.panels;

import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartingPanel extends JPanel {

    private static final String PLAY_BUTTON = "Play";
    private static final String HIGH_SCORE_BUTTON = "High Score";

    private JButton playBtn;
    private JButton highScoreBtn;

    public StartingPanel(ActionListener actionListener) {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.playBtn = new JButton(PLAY_BUTTON);
        this.playBtn.setPreferredSize(new Dimension(60, 40));
        this.highScoreBtn = new JButton(HIGH_SCORE_BUTTON);

        this.playBtn.addActionListener(actionListener);
        this.playBtn.setActionCommand("Play");
        this.highScoreBtn.addActionListener(actionListener);
        this.highScoreBtn.setActionCommand("HighScore");

        SettingsComponents.setCharacteristicsButton(this.playBtn, 75);
        SettingsComponents.setCharacteristicsButton(this.highScoreBtn, 75);
        this.setPositions();
    }

    private void setPositions() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 10, 0);
        this.add(this.playBtn, gbc);

        this.add(this.highScoreBtn, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
    }

}
