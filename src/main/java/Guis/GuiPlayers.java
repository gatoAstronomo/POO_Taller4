package Guis;

import Data.DataPlayer;
import Model.Player;
import Model.Position;
import Model.Team;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiPlayers extends JFrame implements ActionListener {
    private final JTable playerTable;
    private final DefaultTableModel tableModel;
    private JButton editButton;
    private JButton saveButton;
    private JButton backButton;
    private Team team;

    public GuiPlayers(Team team) {
        this.team = team;
        setTitle("Players");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = {"Number", "Name", "Position"};
        tableModel = new DefaultTableModel(columnNames, 0);
        playerTable = new JTable(tableModel);

        loadPlayers();

        JScrollPane scrollPane = new JScrollPane(playerTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        editButton = new JButton("Edit player");
        editButton.addActionListener(this);
        saveButton = new JButton("Save changes");
        saveButton.addActionListener(_ -> saveChanges());
        backButton = new JButton("Back");
        backButton.addActionListener(_ -> dispose());

        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        setVisible(true);
    }

    private void loadPlayers() {
        for (Player player : team.getPlayers()) {
            Object[] row = {player.getNumber(), player.getName(), player.getPosition().name()};
            tableModel.addRow(row);
        }
    }

    private void saveChanges() {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Player player = team.getPlayers().get(i);
            player.setNumber((String) tableModel.getValueAt(i, 0));
            player.setName((String) tableModel.getValueAt(i, 1));
            player.setPosition(Position.valueOf((String) tableModel.getValueAt(i, 2)));
        }

        try {
            DataPlayer.savePlayers("src/main/java/Data/datos/chi.txt", team.getPlayers());
            JOptionPane.showMessageDialog(this, "Changes saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save changes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = playerTable.getSelectedRow();
        if (selectedRow != -1) {
            Player player = team.getPlayers().get(selectedRow);
            String newName = JOptionPane.showInputDialog("Enter new name:", player.getName());
            if (newName != null && !newName.trim().isEmpty()) {
                tableModel.setValueAt(newName, selectedRow, 1);
            }

            String newNumber = JOptionPane.showInputDialog("Enter new number:", player.getNumber());
            if (newNumber != null && !newNumber.trim().isEmpty()) {
                tableModel.setValueAt(newNumber, selectedRow, 0);
                player.setNumber(newNumber); // Actualizar el número en el objeto Player
            }

            String newPosition = JOptionPane.showInputDialog("Enter new position (GK, DF, MF, FW):", player.getPosition().name());
            if (newPosition != null && !newPosition.trim().isEmpty()) {
                try {
                    Position position = Position.valueOf(newPosition.trim());
                    tableModel.setValueAt(position.name(), selectedRow, 2);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid position. Please enter one of the following: GK, DF, MF, FW.");
                }
            }
        }
    }
}
