package views;

import javax.swing.*;
import java.awt.*;

public class NamePanel extends JPanel {
    private JLabel name;

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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(250,0,0,0);

        this.add(name, gbc);
    }

}
