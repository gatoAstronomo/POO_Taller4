package Model;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players = new ArrayList<>();
    private String name;
    private int ranking;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
