package views.utilities;

import views.utilities.ChangeFont;

import javax.swing.*;
import java.awt.*;

public class SettingsComponents {

    public static void setCharacteristicsButton(JButton button, int size){
        button.setFont(ChangeFont.changeFont(size));
        button.setForeground(Color.WHITE);
        button.setBackground(null);
        button.setContentAreaFilled (false);
        button.setFocusPainted(false);
        button.setBorder(null);
    }

    public static void setCharacteristicsLabel(JLabel label, int size){
        label.setFont(ChangeFont.changeFont(size));
        label.setForeground(Color.WHITE);
        label.setBorder(null);
    }
    public static void setCharacteristicsJTextField(JTextField textField, int size){
        textField.setFont(ChangeFont.changeFont(size));
        textField.setForeground(Color.BLACK);
    }

    public static void setBackground(JPanel jPanel, Graphics graphics){
        ImageIcon imageIcon = new ImageIcon("src/rsc/img/background.png");
        Image imageBackground = imageIcon.getImage();
        graphics.drawImage(imageBackground, 0, 0, jPanel);
        jPanel.setOpaque(false);
    }
}
