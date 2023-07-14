import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;

public class TaskEdit extends BasePage {
	private static String page_from = "MyTask";
	private JTextField _name_field;
	private JLabel _name_error;
	private JTextField _description_field;
	private JLabel _description_error;
	private String _name = "";
	private String _description = "";
	private int _task_id;

	public TaskEdit(BasePage page) { super(page); }
	public TaskEdit(BaseFrame frame) { super(frame); }
	public TaskEdit(BasePage page, String page_from) {
		super(page);
		TaskEdit.page_from = page_from;
	}
	public TaskEdit(BasePage page, int task_id, String page_from) {
		super(page);
		this._task_id = task_id;
		TaskEdit.page_from = page_from;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Edit"))
				page = checkField();
			else if (cmd.equals("Back to Task"))
				page = getPreviousPage();
			else
				page = new Error(TaskEdit.this);

			if (page != null)
				TaskEdit.this._frame.changePanel(page.createPage());
		}

		public BasePage getPreviousPage() {
			if (page_from.equals("MyTask"))
				return (new MyTask(TaskEdit.this));
			else if (page_from.equals("ArchivedTask"))
				return (new ArchivedTask(TaskEdit.this));
			else if (page_from.equals("SharedTask"))
				return (new SharedTask(TaskEdit.this));
			return (null);
		}

		public BasePage checkField() {
			String name = _name_field.getText();
			String description = _description_field.getText();
			if (!isValid(name, description))
				return (null);
			updateTask(name, description);
			return (getPreviousPage());
		}

		public void updateTask(String name, String description) {
			SQL.update("update task set owner=?, name=?, description=? where id=?", String.valueOf(TaskEdit.this._frame.getLoginId()), name, description, String.valueOf(TaskEdit.this._task_id));
		}

		public boolean isValid(String name, String description) {
			boolean is_valid = true;
			if (name.equals("")) {
				_name_error.setText("Please input task name");
				is_valid = false;
			}
			else
				_name_error.setText("");
			if (description.equals("")) {
				_description_error.setText("Please input description");
				is_valid = false;
			}
			else
				_description_error.setText("");
			return (is_valid);
		}
	}

	public void setBeforeTask() {
		ArrayList<ArrayList<String>> info = SQL.select("select name, description from task where id=?", 2, String.valueOf(this._task_id));
		ArrayList<String> str_list = info.get(0);
		this._name = str_list.get(0);
		this._description = str_list.get(1);
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		setBeforeTask();

		JLabel label = panel.createLabel("TaskEdit", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		JLabel name_label = panel.createLabel("Name: ", 0.05, 0.2, 0.15, 0.05);
		this._name_field = panel.createTextField(this._name, 0.2, 0.2, 0.6, 0.05);
		this._name_error = panel.createLabel("",0.2, 0.25, 0.6, 0.05);
		this._name_error.setForeground(Color.RED);
		JLabel description_label = panel.createLabel("description: ", 0.05, 0.3, 0.15, 0.05);
		this._description_field = panel.createTextField(this._description, 0.2, 0.3, 0.6, 0.05);
		this._description_error = panel.createLabel("",0.2, 0.35, 0.6, 0.05);
		this._description_error.setForeground(Color.RED);

		panel.add(name_label);
		panel.add(this._name_field);
		panel.add(this._name_error);
		panel.add(description_label);
		panel.add(this._description_field);
		panel.add(this._description_error);

		Action action = new Action();

		JButton button = panel.createButton("Back to Task", 0.25, 0.5, 0.2, 0.1);
		button.addActionListener(action);

		JButton button2 = panel.createButton("Edit", 0.55, 0.5, 0.2, 0.1);
		button2.addActionListener(action);

		panel.add(button);
		panel.add(button2);

		return (panel);
	}
}

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

public class MyTask extends BasePage {
	private JTable table;
	ToDoTableModel model;
	ArrayList<ArrayList<String>> info_total;

	public MyTask(BasePage page) { super(page); }
	public MyTask(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Add Task"))
				page = new TaskAdd(MyTask.this, "MyTask");
			else if (cmd.equals("Back to Task"))
				page = new Task(MyTask.this);
			else if (cmd.equals("Get ToDo"))
				page = getSelectedTask();
			else if (cmd.equals("Edit Task"))
				page = getEditTask();
			else if (cmd.equals("Archive Task"))
				page = archiveTask();
			else
				page = new Error(MyTask.this);

			if (page != null)
				MyTask.this._frame.changePanel(page.createPage());
		}

		public BasePage archiveTask() {
			int selected_row = table.getSelectedRow();
			if (selected_row == -1)
				return (null);
			ArrayList<String> str_list = info_total.get(selected_row);
			int task_id = Integer.valueOf(str_list.get(0));
			SQL.update("update task set is_archive = ? where id = ?", "1", String.valueOf(task_id));
			return (new MyTask(MyTask.this));
		}

		public BasePage getSelectedTask() {
			int selected_row = table.getSelectedRow();
			if (selected_row == -1)
				return (null);
			ArrayList<String> str_list = info_total.get(selected_row);
			int task_id = Integer.valueOf(str_list.get(0));
			return (new ToDo(MyTask.this, task_id, "MyTask"));
		}

		public BasePage getEditTask() {
			int selected_row = table.getSelectedRow();
			if (selected_row == -1)
				return (null);
			ArrayList<String> str_list = info_total.get(selected_row);
			int task_id = Integer.valueOf(str_list.get(0));
			return (new TaskEdit(MyTask.this, task_id, "MyTask"));
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(new BorderLayout());

		JLabel label = panel.createLabel("My Task", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, BorderLayout.NORTH);

		String[] columns = {"Name", "Description", "Total", "Completed", "Uncompleted"};

		model = new ToDoTableModel(null, columns);

		info_total = SQL.select("select ta.id, ta.name, ta.description from member m, task ta where ta.owner=m.id and ta.is_archive = ? and m.id = ? group by ta.id;", 3, "0", String.valueOf(MyTask.this._frame.getLoginId()));
		ArrayList<ArrayList<String>> info_selected = SQL.select("select ta.id, ta.name, ta.description, count(td.id), sum(td.is_done), count(td.id) - sum(td.is_done) from member m, task ta, todo td where ta.owner=m.id and ta.id=td.task and ta.is_archive = ? and m.id = ? group by ta.id;", 6, "0", String.valueOf(MyTask.this._frame.getLoginId()));
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

		JButton add_button = panel.createButton("Add Task", 0.7, 0.1, 0.1, 0.05);
		add_button.addActionListener(action);
		button_panel.add(add_button);

		JButton edit_button = panel.createButton("Edit Task", 0.7, 0.1, 0.1, 0.05);
		edit_button.addActionListener(action);
		button_panel.add(edit_button);

		JButton todo_button = panel.createButton("Get ToDo", 0.7, 0.1, 0.1, 0.05);
		todo_button.addActionListener(action);
		button_panel.add(todo_button);

		JButton archive_button = panel.createButton("Archive Task", 0.7, 0.1, 0.1, 0.05);
		archive_button.addActionListener(action);
		button_panel.add(archive_button);

		panel.add(button_panel, BorderLayout.SOUTH);

		return (panel);
	}
}