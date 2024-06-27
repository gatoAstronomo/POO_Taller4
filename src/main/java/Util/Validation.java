package Util;

import Model.Player;
import Model.Position;
import Model.Team;

import java.util.ArrayList;

public class Validation {
    public static boolean isDuplicatedPlayerNumber(Team team, String number) {
        ArrayList<Player> players = team.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            return number.equals(players.get(i).getNumber());
        }
        return false;
    }

    public static boolean isValidNumber(Team team, String number) {
        return 1 <= Integer.parseInt(number) && Integer.parseInt(number) <= 23;
    }

    public static boolean isValidPosition(Team team, Position position) {
        int count = 0;
        ArrayList<Player> players = team.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPosition().equals(position)) {
                count++;
            }
        }
        return count == 3;
    }
}
