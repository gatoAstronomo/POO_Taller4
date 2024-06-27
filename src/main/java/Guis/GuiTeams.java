package Guis;

import Data.DataTeam;
import Model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            GuiPlayers playersGui = new GuiPlayers(teamSel);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    private void buildComponents(){
        teamLabel = new JLabel("Choose team:");
        teamSelector = new JComboBox<Team> ((ComboBoxModel<Team>) DataTeam.getTeams());
        rankingLabel = new JLabel("Ranking FIFA:");
        rankingValue = new JLabel("1");
        flagLabel = new JLabel(new ImageIcon("DataPlayer.getPathFlag()"));
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
