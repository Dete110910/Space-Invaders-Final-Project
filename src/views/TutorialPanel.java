package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TutorialPanel extends JPanel {
    private JLabel titleTutorial,singlePLayer, twoPlayers;
    private JButton backButton;

    public TutorialPanel(ActionListener actionListener) {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLUE);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        titleTutorial= new JLabel("Tutorial");
        SettingsComponents.setCharacteristicsLabel(titleTutorial, 60);

        singlePLayer= new JLabel("Individual Mode");
        SettingsComponents.setCharacteristicsLabel(singlePLayer, 60);

        twoPlayers= new JLabel("Multiplayer Mode");
        SettingsComponents.setCharacteristicsLabel(twoPlayers, 60);

        backButton = new JButton("> Back");
        backButton.addActionListener(actionListener);
        backButton.setActionCommand("Back");
        SettingsComponents.setCharacteristicsButton(backButton, 60);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(-520,0,0,570);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(backButton, gbc);

        gbc.insets = new Insets(-100,0,10,100);

        this.add(titleTutorial, gbc);
        gbc.insets = new Insets(-50,0,20,100);
        this.add(singlePLayer, gbc);
        gbc.insets = new Insets(0,0,30,100);
        this.add(twoPlayers, gbc);

    }

}
