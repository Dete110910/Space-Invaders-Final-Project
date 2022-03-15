package views;


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
        GridBagConstraints gbc = new GridBagConstraints();

        this.add(backButton, gbc);
        for (String score : highScoreList) {
            JLabel aux = new JLabel(score);
            aux.setFont(ChangeFont.changeFont(70));
            scoresList.add(aux);
        }
    }
}
