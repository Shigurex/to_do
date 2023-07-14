import javax.swing.table.DefaultTableModel;

public class ToDoTableModel extends DefaultTableModel {
	ToDoTableModel(Object[][] data, Object[] columnNames){ super(data, columnNames); }

	public Class getColumnClass(int col) {
		return (getValueAt(0, col).getClass());
	}

	public boolean isCellEditable(int row, int column) {
		if (column == 5)
			return (true);
		return (false);
	}
}