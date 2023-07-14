import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

public class SharedTask extends BasePage {
	private JTable table;
	ToDoTableModel model;
	ArrayList<ArrayList<String>> info_total;

	public SharedTask(BasePage page) { super(page); }
	public SharedTask(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Add Task"))
				page = new TaskAdd(SharedTask.this);
			else if (cmd.equals("Back to Task"))
				page = new Task(SharedTask.this);
			else if (cmd.equals("Get ToDo"))
				page = getSelectedTask();
			else
				page = new Error(SharedTask.this);

			if (page != null)
				SharedTask.this._frame.changePanel(page.createPage());
		}

		public BasePage getSelectedTask() {
			int selected_row = table.getSelectedRow();
			if (selected_row == -1)
				return (null);
			ArrayList<String> str_list = info_total.get(selected_row);
			int task_id = Integer.valueOf(str_list.get(0));
			return (new ToDo(SharedTask.this, task_id, "SharedTask"));
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(new BorderLayout());

		JLabel label = panel.createLabel("Shared Task", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.NORTH);

		String[] columns = {"Name", "Description", "Total", "Completed", "Uncompleted"};

		model = new ToDoTableModel(null, columns);

		info_total = SQL.select("select ta.id, ta.name, ta.description from member m, task ta where ta.owner=m.id and m.id = ? group by ta.id;", 3, String.valueOf(SharedTask.this._frame.getLoginId()));
		ArrayList<ArrayList<String>> info_selected = SQL.select("select ta.id, ta.name, ta.description, count(td.id), sum(td.is_done), count(td.id) - sum(td.is_done) from member m, task ta, todo td where ta.owner=m.id and ta.id=td.task and m.id = ? group by ta.id;", 6, String.valueOf(SharedTask.this._frame.getLoginId()));
		int index = 0;
		String selected_list_id = null;
		if (index != info_selected.size())
			selected_list_id = info_selected.get(index).get(0);
		String todo_id, todo_name, todo_description, todo_total, todo_completed, todo_uncompleted;
		for (int i = 0; i < info_total.size(); i++) {
			ArrayList<String> str_list = info_total.get(i);

			todo_id = str_list.get(0);
			if (index < info_selected.size() && todo_id.equals(selected_list_id)) {
				str_list = info_selected.get(index);
				todo_name = str_list.get(1);
				todo_description = str_list.get(2);
				todo_total = str_list.get(3);
				todo_completed = str_list.get(4);
				todo_uncompleted = str_list.get(5);
				index++;
				if (index != info_selected.size())
					selected_list_id = info_selected.get(index).get(0);
			} else {
				todo_name = str_list.get(1);
				todo_description = str_list.get(2);
				todo_total = "0";
				todo_completed = "0";
				todo_uncompleted = "0";
			}
			Object[] content = {todo_name, todo_description, todo_total, todo_completed, todo_uncompleted};
			model.addRow(content);
		}

		table = panel.createTable(model, 0, 0.2, 1, 0.5);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		double[] columns_width = {0.2, 0.5, 0.1, 0.1, 0.1};

		TableColumn column = null;
		for (int i = 0 ; i < table.getColumnCount() ; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth((int)(this._frame.getWinWidth() * columns_width[i]));
		}

		JScrollPane scrollpane = new JScrollPane();
		JViewport view = scrollpane.getViewport();
		view.setView(table);

		panel.add(scrollpane, BorderLayout.CENTER);

		Action action = new Action();

		JPanel button_panel = new JPanel();

		JButton task_button = panel.createButton("Back to Task", 0.7, 0.1, 0.1, 0.05);
		task_button.addActionListener(action);
		button_panel.add(task_button);

		JButton todo_button = panel.createButton("Get ToDo", 0.7, 0.1, 0.1, 0.05);
		todo_button.addActionListener(action);
		button_panel.add(todo_button);

		panel.add(button_panel, BorderLayout.SOUTH);

		return (panel);
	}
}