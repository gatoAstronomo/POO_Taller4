package Model;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players = new ArrayList<>();
    final private String name;
    final private String ranking;
    final private String imagePath;

    public Team(String name, String ranking, String imagePath, ArrayList<Player> players) {
        this.name = name;
        this.ranking = ranking;
        this.imagePath = imagePath;
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
}
