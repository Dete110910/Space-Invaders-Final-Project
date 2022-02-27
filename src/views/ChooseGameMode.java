package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChooseGameMode extends JPanel {

    private JButton onePlayer, twoPlayersLAN, twoPlayers;

    public ChooseGameMode(ActionListener actionListener){
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener){
        onePlayer = new JButton("One Player");
        twoPlayers = new JButton("Two Players");
        twoPlayersLAN = new JButton("Two Players LAN");

        onePlayer.setPreferredSize(new Dimension(120,60));
        onePlayer.addActionListener(actionListener);
        onePlayer.setActionCommand("PlayOnePlayer");

        twoPlayers.setPreferredSize(new Dimension(150,70));
        twoPlayers.addActionListener(actionListener);
        twoPlayers.setActionCommand("PlayOnePlayer");

        twoPlayersLAN.setPreferredSize(new Dimension(200,80));
        twoPlayersLAN.addActionListener(actionListener);
        twoPlayersLAN.setActionCommand("PlayOnePlayer");

        SettingsComponents.setCharacteristicsButton(onePlayer);
        SettingsComponents.setCharacteristicsButton(twoPlayers);
        SettingsComponents.setCharacteristicsButton(twoPlayersLAN);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,20,0,20);
        this.add(onePlayer, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(twoPlayers, gbc);
        this.add(twoPlayersLAN, gbc);
    }
}
