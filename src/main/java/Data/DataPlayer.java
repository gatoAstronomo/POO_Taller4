package Data;

import Model.Player;
import Model.Position;
import Model.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataPlayer {
    public static ArrayList<Player> loadPlayers(String pathTeam) {
        ArrayList<Player> players = new ArrayList<>();

        try {
            File doc = new File(pathTeam);
            Scanner obj = new Scanner(doc);
            while (obj.hasNextLine()) {
                String line = obj.nextLine();
                Player player = extractPlayer(line);
                players.add(player);
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }

        return players;
    }

    public static Player extractPlayer(String line) {
        String[] data = line.split(";");
        String number = data[0];
        String name = data[1];
        Position position = Position.valueOf(data[2]);
        return new Player(number, name, position);
    }

    public static void savePlayers(String filePath, ArrayList<Player> players) throws IOException{
        try (FileWriter fileWriter = new FileWriter(filePath); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Player player : players){
                printWriter.println(player.getNumber() + ";" + player.getName() + ";" + player.getPosition());
            }
        }
    }

}
