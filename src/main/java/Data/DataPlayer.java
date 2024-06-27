package Data;

import Model.Player;
import Model.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataPlayer {
    public static ArrayList<Player> loadPlayers(String pathTeam) throws FileNotFoundException {
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
        }

        return players;
    }

    public static Player extractPlayer(String linea) {
        String[] data = linea.split(";");
        String number = data[0];
        String name = data[1];
        Position position = Position.valueOf(data[2]);
        return new Player(number, name, position);
    }

}
