package views;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class Button extends BasicButtonUI {
    private String name;
    public Button(String name){
        this.name = name;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont(new Font("Lucian Console", 0, 20));
        g2d.setPaint(Color.RED);
        c.getX();
        g2d.drawString(name, ((c.getWidth() - name.length()*20)/ 2) , c.getHeight() / 2);
        super.paint(g2d, c);
    }
}
