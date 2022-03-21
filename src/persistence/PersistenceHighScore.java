package persistence;

import models.ManagerHighScore;
import com.google.gson.Gson;

import java.io.*;

public class PersistenceHighScore {
    private static final String SOURCE =  "src/rsc/persistence/HighScores.json";


    public static void writeHighScores(ManagerHighScore managerHighScore) {
        Gson gson = new Gson();
        String json = gson.toJson(managerHighScore);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SOURCE))) {
            bw.write(json);
        } catch (IOException ex) {
        }
    }
    public static String plainReader() {
        StringBuffer response = null;
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(SOURCE)));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return response.toString();
    }

    public  static ManagerHighScore getManagerHighScore() {
        String string = PersistenceHighScore.plainReader();
        ManagerHighScore managerHighScore = new Gson().fromJson(string, ManagerHighScore.class);
        return managerHighScore;
    }

}
