package Main;
import Guis.GuiTeams;
import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiTeams::new);
    }
}