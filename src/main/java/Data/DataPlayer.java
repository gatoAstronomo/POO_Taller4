package Data;

import Model.Player;
import Model.Position;
import Model.Team;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataPlayer {

    public static Player extractPlayer(String linea) {
        String[] data = linea.split(";");
        String number = data[0];
        String name = data[1];
        Position position = Position.valueOf(data[2]);
        return new Player(number, name, position);
    }
    public static List<Team> loadTeams(String filePath) {
        List<Team> teams = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            teams = lines.map(line -> {
                String[] data = line.split(";");
                String name = data[1];
                String ranking = data[2];
                String imagePath = data[3];
                List<Player> players = new ArrayList<>();
                return new Team(name, ranking, imagePath, (ArrayList<Player>) players);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teams;
    }
    public static ArrayList<Player> loadPlayers(String pathTeam) throws FileNotFoundException {
        ArrayList<Player> players = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(pathTeam))) {
            players = lines.map(DataPlayer::extractPlayer)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return players;
    }
    public static ArrayList<Team> getTeams(){
        String pathTeams = "src/main/java/Data/datos/teams.txt";
        return (ArrayList<Team>) loadTeams(pathTeams);
    }
}
