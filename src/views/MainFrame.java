package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private StartingPanel startingPanel;
    private NamePanel namePanel;
    private ChooseGameMode chooseGameMode;
    private MainGamePanel mainGamePanel;
    private TopGamePanel topGamePanel;


    public MainFrame(ActionListener actionListener){
        super("Space Invaders");
        this.setResizable(false);
        this.setSize(700,700);
        this.initComponents(actionListener);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void changeToSelectPlayersPanel(){
        this.remove(startingPanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(chooseGameMode);
    }

    public void changeToOnePlayerPanel(){
        this.remove(chooseGameMode);
        this.remove(namePanel);
        SwingUtilities.updateComponentTreeUI(this);
        this.add(mainGamePanel);
        this.add(topGamePanel, BorderLayout.NORTH);

    }

    private void initComponents(ActionListener actionListener){
        startingPanel = new StartingPanel(actionListener);
        namePanel = new NamePanel();
        chooseGameMode = new ChooseGameMode(actionListener);
        mainGamePanel = new MainGamePanel();
        topGamePanel = new TopGamePanel();
        this.add(namePanel, BorderLayout.NORTH);
        this.add(startingPanel);
    }

}
