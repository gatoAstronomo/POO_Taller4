package Main;

import Data.DataPlayer;
import Model.Player;
import Model.Team;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {
        // System.out.println("Hi");
        ArrayList<Team> data = DataPlayer.getTeams();
        data.stream().forEach(team ->System.out.println(team.getName()));
    }
}