package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TutorialPanel extends JPanel {
    private JLabel titleTutorial;
    private JLabel singlePLayer;
    private JLabel twoPlayers;
    private JButton backButton;

    public TutorialPanel(ActionListener actionListener) {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        titleTutorial= new JLabel("Tutorial");
        SettingsComponents.setCharacteristicsLabel(titleTutorial, 60);

        singlePLayer= new JLabel("Modo Individual");
        SettingsComponents.setCharacteristicsLabel(singlePLayer, 20);

        twoPlayers= new JLabel("Modo Multijugador - Local");
        SettingsComponents.setCharacteristicsLabel(twoPlayers, 20);

        backButton = new JButton("< Back");
        backButton.setVisible(true);
        backButton.addActionListener(actionListener);
        backButton.setActionCommand("Back");
        SettingsComponents.setCharacteristicsButton(backButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,0,570);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(backButton, gbc);
        gbc.insets = new Insets(0,0,0,570);
        this.add(titleTutorial);
        this.add(singlePLayer);
        this.add(twoPlayers);

    }

}
