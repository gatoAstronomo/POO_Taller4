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

    public GuiTeams() {
        super("Soccer Teams");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        setup();
        SwingUtilities.invokeLater(GuiTeams::new);
    }

    private void setup() {
        buildComponents();
        buildListeners();
        addToGUI();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playersButton) {
            Team teamSel = (Team) teamSelector.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Players for " + teamSel.getName() + " would be shown here.");
            // Aquí iría la lógica para mostrar los jugadores
            //GuiPlayers players = new GuiPlayers(teamSel);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void updateTeamInfo() {
        Team selectedTeam = (Team) teamSelector.getSelectedItem();
        if (selectedTeam != null) {
            rankingValue.setText(selectedTeam.getRanking());
            ImageIcon icon = new ImageIcon("src/main/java/Data/datos/" + selectedTeam.getImagePath());
            Image img = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
            flagLabel.setIcon(new ImageIcon(img));
        }
    }

    private void buildComponents() {
        teamLabel = new JLabel("Choose team:");
        DefaultComboBoxModel<Team> model = new DefaultComboBoxModel<>();

        ArrayList<Team> teams = DataTeam.getTeams();
        for (Team team : teams) {
            model.addElement(team);
        }
        teamSelector = new JComboBox<>(model);
        teamSelector.addActionListener(e -> updateTeamInfo());

        rankingLabel = new JLabel("FIFA Ranking:");
        rankingValue = new JLabel("48");
        ImageIcon icon = new ImageIcon("src/main/java/Data/datos/aus.png");
        Image img = icon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        flagLabel = new JLabel(icon);
        flagLabel.setPreferredSize(new Dimension(200, 120));

        playersButton = new JButton("View Players");
        exitButton = new JButton("Exit");
    }

    private void buildListeners() {
        playersButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    private void addToGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel teamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        teamPanel.add(teamLabel);
        teamPanel.add(teamSelector);

        JPanel rankingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rankingPanel.add(rankingLabel);
        rankingPanel.add(rankingValue);

        JPanel flagPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        flagPanel.add(flagLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(playersButton);
        buttonPanel.add(exitButton);

        mainPanel.add(teamPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(rankingPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(flagPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(buttonPanel);

        add(mainPanel, BorderLayout.CENTER);
    }
}