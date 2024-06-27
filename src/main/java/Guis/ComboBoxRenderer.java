package Guis;

import Model.Position;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ComboBoxRenderer extends JComboBox<Position> implements TableCellRenderer {
    public ComboBoxRenderer() {
        super(Position.values());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setSelectedItem(value);
        return this;
    }
}

