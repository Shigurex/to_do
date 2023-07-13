import javax.swing.table.DefaultTableModel;

public class TaskTableModel extends DefaultTableModel {
	TaskTableModel(Object[][] data, Object[] columnNames){ super(data, columnNames); }

	public Class getColumnClass(int col) {
		return (getValueAt(0, col).getClass());
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
