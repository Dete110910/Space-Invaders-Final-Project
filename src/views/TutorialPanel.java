package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class TutorialPanel extends JPanel {
    private JLabel titleTutorial,singlePLayer, twoPlayers, instructionsOnePlayer, instructionsTwoPlayersPartOne, instructionsTwoPlayersPartTwo,
    instructionsTwoPlayersPartThree, iconPlayer;
    private JButton backButton;

    public TutorialPanel(ActionListener actionListener) {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        titleTutorial= new JLabel("Tutorial");
        SettingsComponents.setCharacteristicsLabel(titleTutorial, 190);

        singlePLayer= new JLabel("Individual Mode");
        SettingsComponents.setCharacteristicsLabel(singlePLayer, 130);

        twoPlayers= new JLabel("Multiplayer Mode");
        SettingsComponents.setCharacteristicsLabel(twoPlayers, 130);

        backButton = new JButton("> Back");
        backButton.addActionListener(actionListener);
        backButton.setActionCommand("Back");
        SettingsComponents.setCharacteristicsButton(backButton, 60);

        instructionsOnePlayer = new JLabel();
        instructionsTwoPlayersPartOne = new JLabel();
        instructionsTwoPlayersPartTwo = new JLabel();
        instructionsTwoPlayersPartThree = new JLabel();
        iconPlayer = new JLabel();

        this.loadText();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(-350,0,0,580);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(backButton, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-170,0,40,0);
        this.add(titleTutorial, gbc);

        gbc.insets = new Insets(-60,0,20,0);
        this.add(singlePLayer, gbc);

        gbc.insets = new Insets(-30, 0 , 40 , 0);
        this.add(instructionsOnePlayer, gbc);

        gbc.insets = new Insets(-20, 0, 20, 0);
        this.add(twoPlayers, gbc);

        gbc.insets = new Insets(-10, 0, 10, 0);
        this.add(instructionsTwoPlayersPartOne, gbc);
        this.add(instructionsTwoPlayersPartTwo, gbc);
        this.add(instructionsTwoPlayersPartThree, gbc);
        gbc.insets = new Insets(0, 0, -150, 0);
        this.add(iconPlayer, gbc);

    }

    private void loadText(){
        instructionsOnePlayer.setText("A and D to move. \n Spacebar to shoot");
        SettingsComponents.setCharacteristicsLabel(instructionsOnePlayer, 80);
        instructionsTwoPlayersPartOne.setText("Option 1 to one Player");
        SettingsComponents.setCharacteristicsLabel(instructionsTwoPlayersPartOne, 80);
        instructionsTwoPlayersPartTwo.setText("\n arrow keys and enter");
        SettingsComponents.setCharacteristicsLabel(instructionsTwoPlayersPartTwo, 80);
        instructionsTwoPlayersPartThree.setText("\n to second Player");
        SettingsComponents.setCharacteristicsLabel(instructionsTwoPlayersPartThree, 80);
        iconPlayer.setIcon(new ImageIcon("src/rsc/player.png"));
    }

}
