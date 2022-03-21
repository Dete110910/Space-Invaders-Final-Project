package views.panels;

import views.utilities.ChangeFont;
import views.utilities.SettingsComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NamePanel extends JPanel {

    private static final String TITLE = "Space Invaders";
    private static final String BACK = "> Back";
    private static final String ENEMIES_SOURCE = "src/rsc/img/enemies.png";
    private static final String TUTORIAL_SOURCE = "src/rsc/img/tutorialIcon.png";

    private JLabel name, iconEnemies;
    private JButton backButton, tutorialButton;

    public NamePanel(ActionListener actionListener) {
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        this.iconEnemies = new JLabel();
        this.name = new JLabel(TITLE);
        this.backButton = new JButton(BACK);
        this.tutorialButton = new JButton();

        this.iconEnemies.setIcon(new ImageIcon(ENEMIES_SOURCE));
        this.iconEnemies.setPreferredSize(new Dimension(230, 50));

        this.name.setFont(ChangeFont.changeFont(220));
        this.name.setForeground(Color.WHITE);
        this.name.setHorizontalAlignment(SwingConstants.CENTER);

        this.backButton.setVisible(false);
        this.backButton.addActionListener(actionListener);
        this.backButton.setActionCommand("Back");

        this.tutorialButton.setIcon(new ImageIcon(TUTORIAL_SOURCE));
        this.tutorialButton.addActionListener(actionListener);
        this.tutorialButton.setActionCommand("Tutorial");
        this.tutorialButton.setPreferredSize(new Dimension(64, 91));
        SettingsComponents.setCharacteristicsButton(this.tutorialButton, 10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 0, 570);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(this.backButton, gbc);

        gbc.insets = new Insets(0, 510, 0, 0);
        this.add(this.tutorialButton, gbc);

        gbc.insets = new Insets(70, 280, -10, 300);
        this.add(this.iconEnemies, gbc);

        gbc.insets = new Insets(5, 0, 0, 0);
        this.add(this.name, gbc);
    }

    @Override
    public void paint(Graphics g){
        SettingsComponents.setBackground(this, g);
        super.paint(g);
    }

    public void makeVisibleBackButton(boolean isVisible) {
        SettingsComponents.setCharacteristicsButton(this.backButton, 60);
        this.backButton.setVisible(isVisible);
    }

    public void makeInvisibleTutorialButton(boolean isInvisible) {
        SettingsComponents.setCharacteristicsButton(this.tutorialButton, 10);
        this.tutorialButton.setHorizontalAlignment(SwingConstants.LEFT);
        this.tutorialButton.setVisible(isInvisible);
    }
}
