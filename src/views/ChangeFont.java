package views;

import java.awt.*;
import java.io.*;

public class ChangeFont {

    public static Font changeFont(int size){
        Font font = null;
        InputStream myFont = null;
        try{
            myFont = new BufferedInputStream(new FileInputStream("src/rsc/fonts/game_over.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, myFont);
            font = font.deriveFont(Font.PLAIN, size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        return font;
    }

}
