import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Share extends BasePage {
	private int task_id;

	public Share(BasePage page) { super(page); }
	public Share(BaseFrame frame) { super(frame); }
	public Share(BasePage page, int task_id) {
		super(page);
		this.task_id = task_id;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Share"))
				page = new Login(Share.this);
			else if (cmd.equals("Back to ToDo"))
				page = new ToDo(Share.this, task_id);
			else
				page = new Error(Share.this);

			if (page != null)
				Share.this._frame.changePanel(page.createPage());
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Share", 0.35, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);
		Action action = new Action();

		boolean is_editable = true;
		ArrayList<ArrayList<String>> info = SQL.select("select s.is_editable, m.name from member m, share s where s.task=? and s.member=m.id;", 2, String.valueOf(this.task_id));
		for (int i = 0; i < info.size(); i++) {
			ArrayList<String> str_list = info.get(i);
			System.out.println(str_list);
			String editable = str_list.get(0);
			String member_name = str_list.get(1);
			if (editable.equals("1"))
				is_editable = true;
			// JButton task_button = panel.createButton(task_name, 0.2, 0.25 + i * 0.06, 0.6, 0.05);
			JLabel member_label = panel.createLabel(member_name, 0.25, 0.2 + i * 0.06, 0.5, 0.05);
			JRadioButton radio1 = panel.createRadioButton("Editable", is_editable, 0.55, 0.2 + i * 0.06, 0.1, 0.05);
			JRadioButton radio2 = panel.createRadioButton("Viewable", !is_editable, 0.7, 0.2 + i * 0.06, 0.1, 0.05);
			ButtonGroup bgroup = new ButtonGroup();
			bgroup.add(radio1);
			bgroup.add(radio2);
			panel.add(radio1);
			panel.add(radio2);
			// task_button.setActionCommand("Task_" + task_id);
			// task_button.addActionListener(action);
			panel.add(member_label);
		}

		JButton button = panel.createButton("Back to ToDo", 0.4, 0.5, 0.2, 0.05);
		button.addActionListener(action);
		panel.add(button);

		return (panel);
	}
}