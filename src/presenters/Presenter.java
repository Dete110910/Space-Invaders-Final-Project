package presenters;

import views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Presenter implements ActionListener, KeyListener {
    private MainFrame mainFrame;

    public Presenter(){
        mainFrame = new MainFrame(this, this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case "Play":
                mainFrame.changeToSelectPlayersPanel();
                break;
            case "HighScore":

                break;
            case "PlayOnePlayer":
                mainFrame.changeToOnePlayerPanel();

                break;
            case "PlayTwoPlayers":
                System.out.println("To implement");
                break;
            case "PlayTwoPlayersLAN":
                System.out.println("To implement");
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
            mainFrame.setXPosition(-2);
            mainFrame.repaint();//creo que no es necesario
        }
        else if(e.getKeyChar() == 'd'){
            mainFrame.setXPosition(2);
            mainFrame.repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
