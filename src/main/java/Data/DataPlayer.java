package Data;

import Model.Player;
import Model.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataPlayer {
    public ArrayList<Player> loadPlayers(String pathTeam) throws FileNotFoundException {
        ArrayList<Player> players = new ArrayList<>();
        File doc = new File(pathTeam);
        Scanner obj = new Scanner(doc);

        while (obj.hasNextLine()) {
            String line = obj.nextLine();
            String[] data = line.split(";");
            if (data.length == 3) {
                Player player = new Player();
                player.setNumber(data[0].trim());
                player.setName(data[1].trim());
                try {
                    player.setPosition(Position.valueOf(data[2].trim()));
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                players.add(player);
            }
        }
        obj.close();
        return players;
    }

    public void savePlayers(String pathTeam, ArrayList<Player> players) throws IOException {
        FileWriter fileWriter = new FileWriter(pathTeam);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Player player : players) {
            String line = String.format("%s;%s;%s", player.getNumber(), player.getName(), player.getPosition().name());
            printWriter.println(line);
        }

        printWriter.close();
    }
}
