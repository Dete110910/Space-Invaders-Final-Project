package persistence;

import models.managers.ManagerHighScore;
import com.google.gson.Gson;

import java.io.*;

public class PersistenceHighScore {

    private static final String SOURCE = "src/rsc/persistence/HighScores.json";


    public static void writeHighScores(ManagerHighScore managerHighScore) {
        Gson gson = new Gson();
        String json = gson.toJson(managerHighScore);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SOURCE))) {
            bw.write(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String plainReader() {
        StringBuilder response = null;
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(SOURCE)));
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response != null ? response.toString() : "";
    }

    public static ManagerHighScore getManagerHighScore() {
        String string = PersistenceHighScore.plainReader();
        return new Gson().fromJson(string, ManagerHighScore.class);
    }

}
