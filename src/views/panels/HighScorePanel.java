package views.panels;

import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HighScorePanel extends JPanel {

    private static final String BACK_MESSAGE = "> Back";
    private static final String HIGH_SCORES = "High Scores";

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
        this.backButton = new JButton(BACK_MESSAGE);
        this.backButton.addActionListener(actionListener);
        this.backButton.setActionCommand("Back");
        SettingsComponents.setCharacteristicsButton(this.backButton, 60);

        this.title = new JLabel(HIGH_SCORES);
        SettingsComponents.setCharacteristicsLabel(this.title, 200);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(-300, -230, 0, 350);
        this.add(this.backButton, gbc);
        gbc.insets = new Insets(-150, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(this.title, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        int i = 0;
        for (String score : highScoreList) {
            if (!(i % 2 == 0)) {
                gbc.gridwidth = GridBagConstraints.REMAINDER;
            } else {
                gbc.gridwidth = GridBagConstraints.RELATIVE;
            }
            JLabel aux = new JLabel(score);
            SettingsComponents.setCharacteristicsLabel(aux, 90);
            this.scoresList.add(aux);
            this.add(aux, gbc);
            i++;
        }
    }

    @Override
    public void paint(Graphics g){
        SettingsComponents.setBackground(this, g);
        super.paint(g);
    }

    public void updateLabels(ArrayList<String> highScoreList) {
        for (int i = 0; i < highScoreList.size(); i++) {
            this.scoresList.get(i).setText(highScoreList.get(i));
        }
    }
}
