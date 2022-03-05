package views;

import javax.swing.*;
import java.awt.*;

public class NamePanel extends JPanel {
    private JLabel name;
    private JButton backButton;

    public NamePanel(){
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents();
    }

    private void initComponents(){
        name = new JLabel("Space Invaders");
        name.setFont(new Font("Lucida Console", Font.PLAIN, 60));
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(SwingConstants.CENTER);

        backButton = new JButton("< Back");
        backButton.setVisible(false);
        backButton.setFocusPainted(false);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,0,0,570);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(backButton, gbc);

        gbc.insets = new Insets(220,0,0,0);
        this.add(name, gbc);
    }

    public void makeVisibleBackButton(boolean isVisible){
        SettingsComponents.setCharacteristicsButton(backButton);
        this.backButton.setVisible(isVisible);
    }

}
