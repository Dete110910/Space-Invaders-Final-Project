package views.panels;

import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FinalGamePanel extends JPanel {

    private static final String YOU_WIN_MESSAGE = "YOU WIN!!";
    private static final String GAME_OVER_MESSAGE = "GAME OVER";
    private static final String SCORE = "SCORE: ";
    private static final String NAME = "NAME: ";
    private static final String WARNING = "*FOUR LETTER LIMIT";
    private static final String DONE = "DONE";

    private JLabel title, scoreTxt, score, nameTxt, warning;
    private JButton doneButton;
    private JTextField namePlayer;

    public FinalGamePanel(ActionListener actionListener, boolean isWin) {
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.initComponents(actionListener, isWin);
    }

    private void initComponents(ActionListener actionListener, boolean isWin) {
        GridBagConstraints gbc = new GridBagConstraints();
        this.title = new JLabel((isWin) ? YOU_WIN_MESSAGE : GAME_OVER_MESSAGE);
        SettingsComponents.setCharacteristicsLabel(this.title, 250);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 100, 0);
        this.add(this.title, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 50, 0);
        this.scoreTxt = new JLabel(SCORE);
        SettingsComponents.setCharacteristicsLabel(this.scoreTxt, 100);
        this.add(this.scoreTxt, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.score = new JLabel("");
        SettingsComponents.setCharacteristicsLabel(this.score, 100);
        this.add(this.score, gbc);

        gbc.gridwidth = 1;
        this.nameTxt = new JLabel(NAME);
        SettingsComponents.setCharacteristicsLabel(this.nameTxt, 70);
        this.add(this.nameTxt, gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.namePlayer = new JTextField(4);
        SettingsComponents.setCharacteristicsJTextField(this.namePlayer, 70);
        this.add(this.namePlayer, gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.warning = new JLabel(WARNING);
        SettingsComponents.setCharacteristicsLabel(this.warning, 35);
        this.warning.setForeground(Color.RED);
        this.add(this.warning, gbc);

        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 50, 0);
        this.doneButton = new JButton(DONE);
        this.doneButton.addActionListener(actionListener);
        this.doneButton.setActionCommand("Done");
        SettingsComponents.setCharacteristicsButton(this.doneButton, 70);
        this.add(this.doneButton, gbc);
    }

    public void setScore(String score) {
        this.score.setText(score);
    }

    public String getNamePlayer() {
        return this.namePlayer.getText();
    }
}
