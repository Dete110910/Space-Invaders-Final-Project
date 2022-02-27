package presenters;

import views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Presenter implements ActionListener, KeyListener {
    private MainFrame startingScreen;

    public Presenter(){
        startingScreen = new MainFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case "Play":
                startingScreen.changeToSelectPlayersPanel();
                break;
            case "HighScore":

                break;
            case "PlayOnePlayer":
                startingScreen.changeToOnePlayerPanel();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
