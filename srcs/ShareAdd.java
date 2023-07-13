import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ShareAdd extends BasePage {
	private static ArrayList<ArrayList<String>> search_list = null;
	private int task_id;
	private JTextField username_field;
	private JLabel username_error;

	public ShareAdd(BasePage page) { super(page); }
	public ShareAdd(BaseFrame frame) { super(frame); }
	public ShareAdd(BasePage page,int task_id) {
		super(page);
		this.task_id = task_id;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Back to Share"))
				page = new ToDo(ShareAdd.this, task_id);
			else if (cmd.startsWith("User_")) {
				String member_name = cmd.substring(5);
				//insert;
				page = new ShareAdd(ShareAdd.this, ShareAdd.this.task_id);
			}
			else if (cmd.equals("Search"))
				page = searchUser();
			else
				page = new Error(ShareAdd.this);

			if (page != null)
				ShareAdd.this._frame.changePanel(page.createPage());
		}

		public BasePage searchUser() {
			String username = username_field.getText();
			username_field.setText("");
			boolean is_valid = true;
			if (username.equals("")) {
				username_error.setText("Please input username");
				search_list = null;
				return (new ShareAdd(ShareAdd.this, task_id));
			}
			else {
				search_list = SQL.select_like("SELECT name FROM member WHERE is_public=1 and name LIKE ?", 1, username);
				if (search_list.size() == 0) {
					search_list = null;
					return (new ShareAdd(ShareAdd.this, task_id));
				}
				else
					return (new ShareAdd(ShareAdd.this, task_id));
			}
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		JLabel label = panel.createLabel("Share Add", 0.35, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);

		JLabel username_label = panel.createLabel("Username Search: ", 0.05, 0.2, 0.15, 0.05);
		username_field = panel.createTextField("", 0.2, 0.2, 0.5, 0.05);
		username_error = panel.createLabel("",0.2, 0.25, 0.6, 0.05);
		username_error.setForeground(Color.RED);

		panel.add(username_field);
		panel.add(username_error);

		Action action = new Action();

		JButton button = panel.createButton("Search", 0.75, 0.2, 0.1, 0.05);
		button.addActionListener(action);
		panel.add(button);

		double panel_height = 0.3;
		if (search_list != null) {
			for (int i = 0; i < search_list.size(); i++) {
				ArrayList<String> str_list = search_list.get(i);
				String username = str_list.get(0);
				JLabel search_label = panel.createLabel(username, 0.3, panel_height, 0.2, 0.05);
				JButton search_ans = panel.createButton("set Viewable", 0.55, panel_height, 0.15, 0.05);
				search_ans.setActionCommand("User_" + username);
				search_ans.addActionListener(action);
				panel.add(search_label);
				panel.add(search_ans);

				panel_height = panel_height + 0.06;
				if (panel_height > 0.8)
					panel.setPreferredSize(new Dimension(900, (int)(ShareAdd.this._frame.getWinHeight() * (panel_height + 0.2))));
			}

		}

		JButton button2 = panel.createButton("Back to Share", 0.4, panel_height + 0.05, 0.2, 0.05);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
