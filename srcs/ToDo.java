import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

public class ToDo extends BasePage {
	private int task_id;
	private JTable table;
	ArrayList<ArrayList<String>> info;

	public ToDo(BasePage page) { super(page); }
	public ToDo(BaseFrame frame) { super(frame); }
	public ToDo(BasePage page, int task_id) {
		super(page);
		this.task_id = task_id;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Add ToDo"))
				page = new ToDoAdd(ToDo.this, task_id);
			else if (cmd.equals("Edit ToDo"))
				page = getSelectedToDo();
			else if (cmd.equals("Share"))
				page = new Error(ToDo.this);
			else
				page = new Error(ToDo.this);

			if (page != null)
				ToDo.this._frame.changePanel(page.createPage());
		}

		public BasePage getSelectedToDo() {
			int selected_row = table.getSelectedRow();
			if (selected_row == -1)
				return (null);
			ArrayList<String> str_list = info.get(selected_row);
			int todo_id = Integer.valueOf(str_list.get(6));
			return (new ToDoEdit(ToDo.this, task_id, todo_id));
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(new BorderLayout());

		ArrayList<ArrayList<String>> name_info = SQL.select("select name from task where id=?;", 1, String.valueOf(this.task_id));
		String name = name_info.get(0).get(0);

		JLabel label = panel.createLabel(name, 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.NORTH);

		String[] columns = {"Title", "Deadline", "Create Time", "Update Time", "Priority", "Done"};
		TaskTableModel model = new TaskTableModel(null, columns);
		table = panel.createTable(model, 0, 0.2, 1, 0.5);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		double[] columns_width = {0.2, 0.2, 0.2, 0.2, 0.1, 0.1};

		TableColumn column = null;
		for (int i = 0 ; i < table.getColumnCount() ; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int)(this._frame.getWinWidth() * columns_width[i]));
		}

		JScrollPane scrollpane = new JScrollPane();
		JViewport view = scrollpane.getViewport();
		view.setView(table);

		panel.add(scrollpane, BorderLayout.CENTER);

		info = SQL.select("select td.title, td.deadline, td.create_time, td.update_time, td.priority, td.is_done, td.id from task ta, todo td where td.task=ta.id and ta.id=? order by td.is_done asc, td.deadline asc;", 7, String.valueOf(this.task_id));
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

		JPanel button_panel = new JPanel();

		JButton todo_add_button = panel.createButton("Add ToDo", 0.2, 0.75, 0.2, 0.1);
		todo_add_button.addActionListener(action);
		button_panel.add(todo_add_button);

		JButton todo_edit_button = panel.createButton("Edit ToDo", 0.2, 0.75, 0.2, 0.1);
		todo_edit_button.addActionListener(action);
		button_panel.add(todo_edit_button);

		JButton share_button = panel.createButton("Share", 0.7, 0.1, 0.1, 0.05);
		share_button.addActionListener(action);
		button_panel.add(share_button);

		panel.add(button_panel, BorderLayout.SOUTH);

		return (panel);
	}
}
