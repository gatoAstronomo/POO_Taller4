package Model;

import java.util.ArrayList;

public class Team {
    final private String name;
    final private String ranking;
    final private String imagePath;
    private String playersPath;
    private ArrayList<Player> players;

    public Team(String name, String ranking, String imagePath, String playersPath, ArrayList<Player> players) {
        this.name = name;
        this.ranking = ranking;
        this.imagePath = imagePath;
        this.playersPath = playersPath;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public String getRanking() {
        return ranking;
    }

    public String getImagePath() {
        return imagePath;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getPlayersPath() {
        return playersPath;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
