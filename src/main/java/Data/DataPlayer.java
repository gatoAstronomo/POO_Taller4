package Data;

import Model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataPlayer {
    public ArrayList<Player> loadPlayers(String pathTeam) throws FileNotFoundException {
        ArrayList<Player> players = new ArrayList<>();
        File doc = new File(pathTeam);
        Scanner obj = new Scanner(doc);
        while (obj.hasNextLine()) System.out.println(obj.nextLine());
        return players;
    }
}
