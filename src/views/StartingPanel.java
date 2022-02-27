package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartingPanel extends JPanel {


    private JButton playBtn;
    private JButton highScoreBtn;

    public StartingPanel(ActionListener actionListener){
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.BLACK);
        this.initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener){


        playBtn = new JButton("Play");
        playBtn.setPreferredSize(new Dimension(60,40));
        highScoreBtn = new JButton("High Score");

        playBtn.addActionListener(actionListener);
        playBtn.setActionCommand("Play");
        highScoreBtn.addActionListener(actionListener);
        highScoreBtn.setActionCommand("HighScore");

        SettingsComponents.setCharacteristicsButton(playBtn);
        SettingsComponents.setCharacteristicsButton(highScoreBtn);
        this.setPositions();
    }

    private void setPositions(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0,0,10,0);
        this.add(playBtn,gbc);
        this.add(highScoreBtn, gbc);

    }




}
