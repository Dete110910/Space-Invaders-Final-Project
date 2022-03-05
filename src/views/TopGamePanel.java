package views;

import javax.swing.*;
import java.awt.*;

public class TopGamePanel extends JPanel {

    private JLabel score, scorePoints, lives, livesIcon;

    public TopGamePanel(){
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        this.initComponents();
    }

    private void initComponents(){
        score = new JLabel("Score: ");
        score.setForeground(Color.white);
        scorePoints = new JLabel("0");
        scorePoints.setForeground(Color.white);
        lives = new JLabel("Lives: ");
        lives.setForeground(Color.white);
        livesIcon = new JLabel();
        livesIcon.setIcon(new ImageIcon("src/rsc/player.png"));

        GridBagConstraints gbc = new GridBagConstraints();
        this.add(score);
        this.add(scorePoints);
        gbc.insets = new Insets(0,500,0,0);
        this.add(lives, gbc);
        this.add(livesIcon);


    }


}
