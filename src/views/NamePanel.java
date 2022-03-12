package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NamePanel extends JPanel {
    private JLabel name, iconEnemies;
    private JButton backButton, tutorialButton;

    public NamePanel(ActionListener actionListener){
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener){
        iconEnemies = new JLabel();
        name = new JLabel("Space Invaders");
        backButton = new JButton("> Back");
        tutorialButton = new JButton();

        iconEnemies.setIcon(new ImageIcon("src/rsc/enemies.png"));
        iconEnemies.setPreferredSize(new Dimension(230,50));

        name.setFont(ChangeFont.changeFont(220));
        name.setForeground(Color.WHITE);
        name.setHorizontalAlignment(SwingConstants.CENTER);

        backButton.setVisible(false);
        backButton.addActionListener(actionListener);
        backButton.setActionCommand("Back");

        tutorialButton.setIcon(new ImageIcon("src/rsc/tutorialIcon.png"));
        tutorialButton.addActionListener(actionListener);
        tutorialButton.setActionCommand("Tutorial");
        tutorialButton.setPreferredSize(new Dimension(64,91));
        SettingsComponents.setCharacteristicsButton(tutorialButton, 10);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,570);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(backButton, gbc);

        gbc.insets = new Insets(0,510,0,0);
        this.add(tutorialButton, gbc);

        gbc.insets= new Insets(70, 280, -10, 300);
        this.add(iconEnemies, gbc);

        gbc.insets = new Insets(5,0,0,0);
        this.add(name, gbc);
    }


    public void makeVisibleBackButton(boolean isVisible){
        SettingsComponents.setCharacteristicsButton(backButton, 60);
        this.backButton.setVisible(isVisible);
    }

    public void makeInvisibleTutorialButton(boolean isInvisible){
        SettingsComponents.setCharacteristicsButton(tutorialButton, 10);
        this.tutorialButton .setHorizontalAlignment(SwingConstants.LEFT);
        this.tutorialButton.setVisible(isInvisible);
    }


}
