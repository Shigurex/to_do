import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ToDoAdd extends BasePage {
	private int _task_id;
	private JTextField _title_field;
	private JLabel _title_error;
	private JTextField _deadline_field;
	private JLabel _description_error;

	public ToDoAdd(BasePage page) { super(page); }
	public ToDoAdd(BaseFrame frame) { super(frame); }
	public ToDoAdd(BasePage page, int task_id) {
		super(page);
		this._task_id = task_id;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Create Button"))
				page = checkField();
			else
				page = new Error(ToDoAdd.this);

			if (page != null)
				ToDoAdd.this._frame.changePanel(page.createPage());
		}

		public BasePage checkField() {
			String title = _title_field.getText();
			String deadline = _deadline_field.getText();
			if (!isValid(title, deadline))
				return (null);
			addToDo(title, deadline, 5);
			return (new ToDo(ToDoAdd.this, _task_id));
		}

		public void addToDo(String title, String deadline, int priority) {
			LocalDateTime time_now = LocalDateTime.now();
			DateTimeFormatter time_format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String create_time = time_format.format(time_now);
			String update_time = time_format.format(time_now);
			SQL.insert("insert into todo (task, title, deadline, create_time, update_time, priority, is_done) VALUES(?, ?, ?, ?, ?, ?, ?)", String.valueOf(_task_id), title, deadline, create_time, update_time, String.valueOf(priority), "0");
		}

		public boolean isValid(String name, String description) {
			boolean is_valid = true;
			if (name.equals("")) {
				_title_error.setText("Please input task name");
				is_valid = false;
			}
			else
				_title_error.setText("");
			if (description.equals("")) {
				_description_error.setText("Please input description");
				is_valid = false;
			}
			else
				_description_error.setText("");
			return (is_valid);
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		JLabel label = panel.createLabel("ToDoAdd", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		JLabel title_label = panel.createLabel("Title: ", 0.05, 0.2, 0.15, 0.05);
		this._title_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		this._title_error = panel.createLabel("",0.2, 0.25, 0.6, 0.05);
		this._title_error.setForeground(Color.RED);
		JLabel deadline_label = panel.createLabel("Deadline: ", 0.05, 0.3, 0.15, 0.05);
		this._deadline_field = panel.createTextField("", 0.2, 0.3, 0.6, 0.05);
		this._description_error = panel.createLabel("",0.2, 0.35, 0.6, 0.05);
		this._description_error.setForeground(Color.RED);

		panel.add(title_label);
		panel.add(this._title_field);
		panel.add(this._title_error);
		panel.add(deadline_label);
		panel.add(this._deadline_field);
		panel.add(this._description_error);

		Action action = new Action();

		JButton button = panel.createButton("Create Button", 0.2, 0.8, 0.2, 0.1);
		button.addActionListener(action);
		panel.add(button);
	
		return (panel);
	}
}
