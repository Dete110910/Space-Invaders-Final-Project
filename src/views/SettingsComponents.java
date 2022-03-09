package views;

import javax.swing.*;
import java.awt.*;

public class SettingsComponents {

    public static void setCharacteristicsButton(JButton button, int size){
        button.setFont(ChangeFont.changeFont(size));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(null);
    }

    public static void setCharacteristicsLabel(JLabel label, int size){
        label.setFont(ChangeFont.changeFont(size));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBorder(null);
    }
}
