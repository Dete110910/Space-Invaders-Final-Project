package views;


import javafx.scene.control.TextFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HighScorePanel extends JPanel {
    private JButton backButton;
    private JLabel title;
    private ArrayList<JLabel> scoresList;

    public HighScorePanel(ActionListener actionListener, ArrayList<String> highScoreList) {
        this.setVisible(true);
        this.scoresList = new ArrayList<>();
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener, highScoreList);
    }

    private void initComponents(ActionListener actionListener, ArrayList<String> highScoreList) {
        backButton = new JButton("> Back");
        backButton.addActionListener(actionListener);
        backButton.setActionCommand("Back");
        SettingsComponents.setCharacteristicsButton(backButton, 60);

        title = new JLabel("High Scores");
        SettingsComponents.setCharacteristicsLabel(title, 200);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(-300, -230, 0, 350);
        this.add(backButton, gbc);
        gbc.insets = new Insets(-150, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(title, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        int i = 0;
        for (String score : highScoreList) {
            if(!(i % 2 == 0)){
                gbc.gridwidth = GridBagConstraints.REMAINDER;
            }
            else{
                gbc.gridwidth = GridBagConstraints.RELATIVE;
            }
            JLabel aux = new JLabel(score);
            SettingsComponents.setCharacteristicsLabel(aux, 90);
            scoresList.add(aux);
            this.add(aux, gbc);
            i++;
        }
    }
    public  void updateLabels(ArrayList<String> highScoreList){
        for (int i = 0; i < highScoreList.size(); i++) {
            scoresList.get(i).setText(highScoreList.get(i));
        }
    }
}
