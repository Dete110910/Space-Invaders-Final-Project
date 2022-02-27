package views;

import javax.swing.*;
import java.awt.*;

public class SettingsComponents {

    public static void setCharacteristicsButton(JButton button){
        button.setFont(new Font("Lucida Console", 0, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(null);
    }

    public static void setCharacteristicsLabel(JLabel label){
        label.setFont(new Font("Lucida Console", 0, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(null);
    }
}
