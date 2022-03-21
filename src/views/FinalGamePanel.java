package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FinalGamePanel extends JPanel {
    private JLabel title, scoreTxt, score, nameTxt, warning;
    private JButton doneButton;
    private JTextField namePlayer;

    public FinalGamePanel(ActionListener actionListener, boolean isWin){
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.initComponents(actionListener, isWin);
    }

    private void initComponents(ActionListener actionListener, boolean isWin) {
        GridBagConstraints gbc = new GridBagConstraints();
        title = new JLabel((isWin)?"YOU WIN!!":"GAME OVER");
        SettingsComponents.setCharacteristicsLabel(title,250);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0,0,100, 0);
        this.add(title,gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(0,0,50, 0);
        scoreTxt = new JLabel("SCORE: ");
        SettingsComponents.setCharacteristicsLabel(scoreTxt,100);
        this.add(scoreTxt,gbc);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        score = new JLabel("");
        SettingsComponents.setCharacteristicsLabel(score,100);
        this.add(score,gbc);

        gbc.gridwidth = 1;
        nameTxt = new JLabel("NAME:");
        SettingsComponents.setCharacteristicsLabel(nameTxt,70);
        this.add(nameTxt,gbc);

           gbc.gridwidth = GridBagConstraints.REMAINDER;
           gbc.fill = GridBagConstraints.HORIZONTAL;
           namePlayer = new JTextField(4);
           SettingsComponents.setCharacteristicsJTextField(namePlayer,70);
           this.add(namePlayer,gbc);

        gbc.gridx = 1;
        gbc.insets = new Insets(0,0,0, 0);
        warning = new JLabel("*FOUR LETTER LIMIT");
        SettingsComponents.setCharacteristicsLabel(warning,35);
        warning.setForeground(Color.RED);
        this.add(warning,gbc);

        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0,0,50, 0);
        doneButton = new JButton("DONE");
        doneButton.addActionListener(actionListener);
        doneButton.setActionCommand("Done");
        SettingsComponents.setCharacteristicsButton(doneButton,70);
        this.add(doneButton,gbc);

    }
    public void setScore(String score){
        this.score.setText(score);
    }

    public String getNamePlayer() {
        return  this.namePlayer.getText();
    }
}
