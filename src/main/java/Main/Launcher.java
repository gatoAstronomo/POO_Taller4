package Main;

import Guis.GuiPlayers;
import Model.Player;
import Model.Position;
import Model.Team;
import java.util.ArrayList;


public class Launcher {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("1", "Claudio BRAVO", Position.GK));
        players.add(new Player("2", "Eugenio MENA", Position.DF));
        players.add(new Player("3", "Enzo ROCO", Position.DF));
        players.add(new Player("4", "Mauricio ISLA", Position.DF));
        players.add(new Player("5", "Francisco SILVA", Position.MF));
        players.add(new Player("6", "Jose FUENZALIDA", Position.MF));
        players.add(new Player("7", "Alexis SANCHEZ", Position.FW));
        players.add(new Player("8", "Arturo VIDAL", Position.MF));
        players.add(new Player("9", "Angelo SAGAL", Position.FW));
        players.add(new Player("10", "Pablo HERNANDEZ", Position.MF));
        players.add(new Player("11", "Eduardo VARGAS", Position.FW));
        players.add(new Player("12", "Cristopher TOSELLI", Position.GK));
        players.add(new Player("13", "Paulo DIAZ", Position.DF));
        players.add(new Player("14", "Felipe GUTIERREZ", Position.MF));
        players.add(new Player("15", "Jean BEAUSEJOUR", Position.DF));
        players.add(new Player("16", "Martin RODRIGUEZ", Position.FW));
        players.add(new Player("17", "Gary MEDEL", Position.DF));
        players.add(new Player("18", "Gonzalo JARA", Position.DF));
        players.add(new Player("19", "Leonardo VALENCIA", Position.FW));
        players.add(new Player("20", "Charles ARANGUIZ", Position.MF));
        players.add(new Player("21", "Marcelo DIAZ", Position.MF));
        players.add(new Player("22", "Edson PUCH", Position.FW));
        players.add(new Player("23", "Johnny HERRERA", Position.GK));

        Team team = new Team();
        team.setName("Chile");
        team.setPlayers(players);

        GuiPlayers gui = new GuiPlayers(team);
    }
}
