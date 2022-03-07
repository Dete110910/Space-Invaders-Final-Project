package views;

import javax.swing.*;
import java.awt.*;

public class DecorateLabels extends JPanel {

    public static void  decorateLabels(JLabel jLabel, int size ){

        jLabel.setFont(new Font("Lucida Console", Font.PLAIN, size));
        jLabel.setForeground(Color.WHITE);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
