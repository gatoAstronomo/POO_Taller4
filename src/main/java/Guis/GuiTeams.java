package Guis;

import Data.DataTeam;
import Model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiTeams extends JFrame implements ActionListener {
    private JLabel teamLabel;
    private JComboBox<Team> teamSelector;
    private JLabel rankingLabel;
    private JLabel rankingValue;
    private JLabel flagLabel;
    private JButton playersButton;
    private JButton exitButton;
    public GuiTeams(){
        super("Teams");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 400);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        setup();
        //invoke();
    }
    private void setup(){
        buildComponents();
        buildListeners();
        addToGUi();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playersButton) {
            Team teamSel = (Team) teamSelector.getSelectedItem();
            //GuiPlayers playersGui = new GuiPlayers(teamSel);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void updateTeamInfo() {
        Team selectedTeam = (Team) teamSelector.getSelectedItem();
        if (selectedTeam != null) {
            rankingValue.setText(selectedTeam.getRanking());
            flagLabel.setIcon(new ImageIcon("src/main/java/Data/datos/" + selectedTeam.getImagePath()));
        }
    }
    private void buildComponents(){
        teamLabel = new JLabel("Choose team:");
        DefaultComboBoxModel<Team> model = new DefaultComboBoxModel<>();

        ArrayList<Team> teams = DataTeam.getTeams();
        for (Team team : teams) {
            model.addElement(team);
        }
        teamSelector = new JComboBox<>(model);
        teamSelector.addActionListener(e -> updateTeamInfo());
        rankingLabel = new JLabel("Ranking FIFA:");
        rankingValue = new JLabel("48");
        flagLabel = new JLabel(new ImageIcon("src/main/java/Data/datos/aus.png"));
        playersButton = new JButton("Players");
        exitButton = new JButton("Exit");
    }
    private void buildListeners(){
        playersButton.addActionListener(this);
        exitButton.addActionListener(this);
        playersButton.addActionListener(this);
        exitButton.addActionListener(this);
    }
    private void addToGUi(){
        JPanel teamPanel = new JPanel();
        teamPanel.setLayout(new GridLayout(4, 2));
        teamPanel.add(teamLabel);
        teamPanel.add(teamSelector);
        teamPanel.add(rankingLabel);
        teamPanel.add(rankingValue);
        teamPanel.add(new JLabel()); // Agregar un espacio en blanco
        teamPanel.add(flagLabel);
        teamPanel.add(playersButton);
        teamPanel.add(exitButton);
        add(teamPanel, BorderLayout.CENTER);
    }
    private static void invoke(){
        SwingUtilities.invokeLater(GuiTeams::new);
    }
    public static void main(String[] args) {
        invoke();
    }
}
