package Data;

import Model.Player;
import Model.Position;
import Model.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataTeam {
    public static ArrayList<Team> loadTeams(String pathTeams){
        ArrayList<Team> teams = new ArrayList<>();

        try {
            File doc = new File(pathTeams);
            Scanner obj = new Scanner(doc);
            while (obj.hasNextLine()) {
                String line = obj.nextLine();
                Team team = extractTeam(line);
                teams.add(team);
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return teams;
    }

    public static Team extractTeam(String line) {
        String[] data = line.split(";");
        String id = data[0];
        String name = data[1];
        String ranking = data[2];
        String imagePath = data[3];
        String playersPath = String.format("src/main/java/Data/datos/%s", data[4]);

        return new Team(name, ranking, imagePath, playersPath, DataPlayer.loadPlayers(playersPath));
    }
    public static ArrayList<Team> getTeams(){
        ArrayList<Team> teams = loadTeams("src/main/java/Data/datos/teams.txt");
        return teams;
    }

}
