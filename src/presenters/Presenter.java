package presenters;

import models.ManagerGame;
import views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Presenter implements ActionListener, KeyListener, Runnable {
    private MainFrame mainFrame;
    private ManagerGame managerGame;

    public Presenter(){
        mainFrame = new MainFrame(this, this);
        managerGame= new ManagerGame(mainFrame.getWidth(), mainFrame.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case "Play":
                mainFrame.changeToSelectPlayersPanel();
                break;
            case "HighScore":

                break;
            case "Back":
                mainFrame.changeToMainPanel();
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
            case "Tutorial":
                mainFrame.changeToTutorialPanel();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a'){
            mainFrame.setXPosition(managerGame.getManagerPlayer().getPlayer().getShipPlayer().move(-2));
            //creo que no es necesario
        }
        else if(e.getKeyChar() == 'd'){
            mainFrame.setXPosition(managerGame.getManagerPlayer().getPlayer().getShipPlayer().move(2));

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    private void initComponents(){

        Thread thread= new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
           mainFrame.setPosition(managerGame.getManagerEnemies().getShipSingle().move());
            System.out.println(managerGame.getManagerEnemies().getShipSingle().move());


        }
    }
}
