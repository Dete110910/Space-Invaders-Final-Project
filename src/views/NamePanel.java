package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NamePanel extends JPanel {
    private JLabel name;
    private JButton backButton;
    private JLabel iconEnemies;
    public NamePanel(ActionListener actionListener){
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener){
        iconEnemies = new JLabel();
        iconEnemies.setIcon(new ImageIcon("src/rsc/enemies.png"));
        name = new JLabel("Space Invaders");
        name.setFont(new Font("Lucida Console", Font.PLAIN, 60));
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        backButton = new JButton("< Back");
        backButton.setVisible(false);
        backButton.addActionListener(actionListener);
        backButton.setActionCommand("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,0,570);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(backButton, gbc);

        gbc.insets= new Insets(200, 280, 0, 300);
        this.add(iconEnemies, gbc);

        gbc.insets = new Insets(20,0,0,0);
        this.add(name, gbc);
    }

    public void makeVisibleBackButton(boolean isVisible){
        SettingsComponents.setCharacteristicsButton(backButton);
        this.backButton.setVisible(isVisible);
    }



}
