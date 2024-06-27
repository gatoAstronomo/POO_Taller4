package Main;

import Guis.GuiPlayers;
import Guis.GuiTeams;
import Model.Player;
import Model.Position;
import Model.Team;

import javax.swing.*;
import java.util.ArrayList;


public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiTeams::new);
    }
}
