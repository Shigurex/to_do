import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JLabel;

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
			//String cmd = e.getActionCommand();
			//BasePage page = null;

			//if (cmd.startsWith("task_"))
			//	page = new ToDo(Task.this);
			//else
			//	page = new Error(Task.this);

			//if (page != null)
			//	Task.this._frame.changePanel(page.createPage());
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		JLabel label = panel.createLabel("ToDo", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		//Action action = new Action();

		ArrayList<ArrayList<String>> info = SQL.select("select td.title, td.deadline from task ta, todo td where td.task=ta.id and ta.id=?;", 2, String.valueOf(this._task_id));
		for (int i = 0; i < info.size(); i++) {
			ArrayList<String> str_list = info.get(i);
			String todo_title = str_list.get(0);
			String todo_deadline = str_list.get(1);
			JLabel todo_title_label = panel.createLabel(todo_title, 0.2, 0.2 + i * 0.05, 0.5, 0.05);
			JLabel todo_deadline_label = panel.createLabel(todo_deadline, 0.6, 0.2 + i * 0.05, 0.2, 0.05);
			panel.add(todo_title_label);
			panel.add(todo_deadline_label);
		}

		return (panel);
	}
}
