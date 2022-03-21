package views.panels;

import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TutorialPanel extends JPanel {

    private static final String TUTORIAL = "Tutorial";
    private static final String INDIVIDUAL_MODE = "Individual Mode";
    private static final String MULTIPLAYER_MODE = "Multiplayer Mode";
    private static final String BACK = "> Back";

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
        this.titleTutorial= new JLabel(TUTORIAL);
        SettingsComponents.setCharacteristicsLabel(this.titleTutorial, 190);

        this.singlePLayer= new JLabel(INDIVIDUAL_MODE);
        SettingsComponents.setCharacteristicsLabel(this.singlePLayer, 130);

        this.twoPlayers= new JLabel(MULTIPLAYER_MODE);
        SettingsComponents.setCharacteristicsLabel(this.twoPlayers, 130);

        this.backButton = new JButton(BACK);
        this.backButton.addActionListener(actionListener);
        this.backButton.setActionCommand("Back");
        SettingsComponents.setCharacteristicsButton(this.backButton, 60);

        this.instructionsOnePlayer = new JLabel();
        this.instructionsTwoPlayersPartOne = new JLabel();
        this.instructionsTwoPlayersPartTwo = new JLabel();
        this.instructionsTwoPlayersPartThree = new JLabel();
        this.iconPlayer = new JLabel();

        this.loadText();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(-350,0,0,580);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(this.backButton, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(-170,0,40,0);
        this.add(this.titleTutorial, gbc);

        gbc.insets = new Insets(-60,0,20,0);
        this.add(this.singlePLayer, gbc);

        gbc.insets = new Insets(-30, 0 , 40 , 0);
        this.add(this.instructionsOnePlayer, gbc);

        gbc.insets = new Insets(-20, 0, 20, 0);
        this.add(this.twoPlayers, gbc);

        gbc.insets = new Insets(-10, 0, 10, 0);
        this.add(this.instructionsTwoPlayersPartOne, gbc);
        this.add(this.instructionsTwoPlayersPartTwo, gbc);
        this.add(this.instructionsTwoPlayersPartThree, gbc);
        gbc.insets = new Insets(0, 0, -150, 0);
        this.add(this.iconPlayer, gbc);

    }

    private void loadText(){
        this.instructionsOnePlayer.setText("A and D to move. \n Spacebar to shoot");
        SettingsComponents.setCharacteristicsLabel(instructionsOnePlayer, 80);
        this.instructionsTwoPlayersPartOne.setText("Option 1 to one Player");
        SettingsComponents.setCharacteristicsLabel(instructionsTwoPlayersPartOne, 80);
        this.instructionsTwoPlayersPartTwo.setText("\n arrow keys and enter");
        SettingsComponents.setCharacteristicsLabel(instructionsTwoPlayersPartTwo, 80);
        this.instructionsTwoPlayersPartThree.setText("\n to second Player");
        SettingsComponents.setCharacteristicsLabel(instructionsTwoPlayersPartThree, 80);
        this.iconPlayer.setIcon(new ImageIcon("src/rsc/player.png"));
    }
    @Override
    public void paint(Graphics g){
        SettingsComponents.setBackground(this, g);
        super.paint(g);
    }

}
