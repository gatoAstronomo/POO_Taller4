package Main;

import Data.DataTeam;
import Guis.GuiPlayers;
import Model.Team;

import java.util.ArrayList;

public class Launcher {
    public static void main(String[] args) {
        ArrayList<Team> teams = DataTeam.loadTeams("src/main/java/Data/datos/teams.txt");
        GuiPlayers gui = new GuiPlayers(teams.get(0));
    }
}