import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

public class ToDo extends BasePage {
	private int _task_id;

	public ToDo(BasePage page) { super(page); }
	public ToDo(BaseFrame frame) { super(frame); }
	public ToDo(BasePage page, int task_id) {
		super(page);
		this._task_id = task_id;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Add ToDo"))
				page = new ToDoAdd(ToDo.this, _task_id);
			else if (cmd.equals("Share"))
				page = new Share(ToDo.this, _task_id);
			else
				page = new Error(ToDo.this);

			if (page != null)
				ToDo.this._frame.changePanel(page.createPage());
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		ArrayList<ArrayList<String>> name_info = SQL.select("select name from task where id=?;", 1, String.valueOf(this._task_id));
		String name = name_info.get(0).get(0);

		JLabel label = panel.createLabel(name, 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);

		String[] columns = {"Title", "Deadline", "Create Time", "Update Time", "Priority", "Done"};
		TaskTableModel model = new TaskTableModel(null, columns);
		double table_width = 0.9;
		double table_height = 0.5;
		JTable table = panel.createTable(model, 0.05, 0.2, table_width, table_height);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		double[] columns_width = {0.2, 0.2, 0.2, 0.2, 0.1, 0.1};

		TableColumn column = null;
		for (int i = 0 ; i < table.getColumnCount() ; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int)(this._frame.getWinWidth() * table_width * columns_width[i]));
		}

		panel.add(table);

		ArrayList<ArrayList<String>> info = SQL.select("select td.title, td.deadline, td.create_time, td.update_time, td.priority, td.is_done from task ta, todo td where td.task=ta.id and ta.id=? order by td.is_done asc, td.deadline asc;", 6, String.valueOf(this._task_id));
		for (int i = 0; i < info.size(); i++) {
			ArrayList<String> str_list = info.get(i);
			String todo_title = str_list.get(0);
			String todo_deadline = str_list.get(1);
			String todo_create_time = str_list.get(2);
			String todo_update_time = str_list.get(3);
			String todo_priority = str_list.get(4);
			boolean todo_is_done = str_list.get(5).equals("1") ? true : false;
			Object[] content = {todo_title, todo_deadline, todo_create_time, todo_update_time, todo_priority, todo_is_done};
			model.addRow(content);
		}

		Action action = new Action();

		JButton todo_add_button = panel.createButton("Add ToDo", 0.2, 0.75, 0.2, 0.1);
		todo_add_button.addActionListener(action);
		panel.add(todo_add_button);

		JButton share_button = panel.createButton("Share", 0.7, 0.1, 0.1, 0.05);
		share_button.addActionListener(action);
		panel.add(share_button);

		return (panel);
	}
}
