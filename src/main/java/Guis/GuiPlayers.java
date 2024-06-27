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
    private RoundButton editButton;
    private RoundButton saveButton;
    private RoundButton backButton;
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
        editButton = new RoundButton("Edit player");
        editButton.addActionListener(this);
        saveButton = new RoundButton("Save changes");
        saveButton.addActionListener(_ -> saveChanges());
        backButton = new RoundButton("Back");
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

    private static class RoundButton extends JButton {
        public RoundButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setOpaque(true);
            setFocusPainted(false);
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajustar el padding del botón
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(UIManager.getColor("Button.background").darker()); // Color cuando se presiona el botón
            } else {
                g.setColor(getBackground());
            }
            g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Radio de 20 para bordes redondeados
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Radio de 20 para bordes redondeados
        }
    }

}
