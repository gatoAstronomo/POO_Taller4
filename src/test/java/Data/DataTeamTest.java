import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import Model.Team;
import Data.DataTeam;
import Data.DataPlayer;
import Model.Player;

class DataTeamTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ValidTeamSize() {
        ArrayList<Team> teams = DataTeam.loadTeams("src/main/java/Data/datos/teams.txt");
        assertEquals(4, teams.size());
    }

    @Test
    void InvalidTeamSize() {
        ArrayList<Team> teams = DataTeam.loadTeams("src/main/java/Data/datos/teams.txt");
        assertNotEquals(7, teams.size());
    }

    // test con Australia que tiene 23 jugadores
    @Test
    void testPlayerCountInTeam() {
        ArrayList<Team> teams = DataTeam.loadTeams("src/main/java/Data/datos/teams.txt");
        assertNotEquals(11, teams.get(0).getPlayers().size());
    }

    @Test
    void getTeams() {
        ArrayList<Team> teams = DataTeam.getTeams();
        assertEquals(4, teams.size());
    }

    @Test
    void testNoDuplicatePlayersInTeam() {
        ArrayList<Team> teams = DataTeam.loadTeams("src/main/java/Data/datos/teams.txt");
        Team team = teams.get(0);
        ArrayList<Player> players = team.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                assertNotEquals(players.get(i), players.get(j));
            }
        }
    }

}
