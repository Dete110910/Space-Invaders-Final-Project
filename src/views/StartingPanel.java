package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class StartingPanel extends JPanel {


    private JButton playBtn;
    private JButton highScoreBtn;
    private JButton tutorialBtn;

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
        tutorialBtn= new JButton("Tutorial");

        playBtn.addActionListener(actionListener);
        playBtn.setActionCommand("Play");
        highScoreBtn.addActionListener(actionListener);
        highScoreBtn.setActionCommand("HighScore");
        tutorialBtn.addActionListener(actionListener);
        tutorialBtn.setActionCommand("Tutorial");

        SettingsComponents.setCharacteristicsButton(playBtn);
        SettingsComponents.setCharacteristicsButton(highScoreBtn);
        SettingsComponents.setCharacteristicsButton(tutorialBtn);
        this.setPositions();
    }

    private void setPositions(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0,0,10,0);
        this.add(playBtn,gbc);

        this.add(highScoreBtn, gbc);
        gbc.insets = new Insets(10,0,0,0);
        this.add(tutorialBtn, gbc);

    }




}
