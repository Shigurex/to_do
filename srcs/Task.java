import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Task extends BasePage {
	public Task(BasePage page) { super(page); }
	public Task(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.startsWith("Task_")) {
				int task_id = Integer.valueOf(cmd.substring(5));
				page = new ToDo(Task.this, task_id);
			} else if (cmd.equals("Task Add"))
				page = new TaskAdd(Task.this);
			else
				page = new Error(Task.this);

			if (page != null)
				Task.this._frame.changePanel(page.createPage());
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		JLabel label = panel.createLabel("Task", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		Action action = new Action();

		JButton task_add_button = panel.createButton("Task Add", 0.65, 0.1, 0.1, 0.05);
		task_add_button.addActionListener(action);
		panel.add(task_add_button);

		ArrayList<ArrayList<String>> info = SQL.select("select ta.id, ta.name from member m, task ta where ta.owner=m.id and m.id=?;", 2, String.valueOf(this._frame.getLoginId()));
		for (int i = 0; i < info.size(); i++) {
			ArrayList<String> str_list = info.get(i);
			String task_id = str_list.get(0);
			String task_name = str_list.get(1);
			JButton task_button = panel.createButton(task_name, 0.2, 0.2 + i * 0.05, 0.6, 0.05);
			task_button.setActionCommand("Task_" + task_id);
			task_button.addActionListener(action);
			panel.add(task_button);
		}

		return (panel);
	}
}