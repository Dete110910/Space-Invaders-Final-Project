package views.panels;

import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChooseGameModePanel extends JPanel {

    private JButton onePlayer, twoPlayersLAN, twoPlayers;

    public ChooseGameModePanel(ActionListener actionListener) {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.onePlayer = new JButton("One Player");
        this.twoPlayers = new JButton("Two Players");
        this.twoPlayersLAN = new JButton("Two Players LAN");

        this.onePlayer.addActionListener(actionListener);
        this.onePlayer.setActionCommand("PlayOnePlayer");

        this.twoPlayers.addActionListener(actionListener);
        this.twoPlayers.setActionCommand("PlayTwoPlayers");

        this.twoPlayersLAN.addActionListener(actionListener);
        this.twoPlayersLAN.setActionCommand("PlayTwoPlayersLAN");

        SettingsComponents.setCharacteristicsButton(this.onePlayer, 90);
        SettingsComponents.setCharacteristicsButton(this.twoPlayers, 90);
        SettingsComponents.setCharacteristicsButton(this.twoPlayersLAN, 90);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 20, 0, 20);
        this.add(onePlayer, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(twoPlayers, gbc);
        this.add(twoPlayersLAN, gbc);
    }

    @Override
    public void paint(Graphics g){
        SettingsComponents.setBackground(this, g);
        super.paint(g);
    }
}
