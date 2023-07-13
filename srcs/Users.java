import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Users extends BasePage {
	private static ArrayList<ArrayList<String>> search_list;
	private JTextField username_field;
	private JLabel username_error;

	public Users(BasePage page) { super(page); }
	public Users(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Search"))
				page = searchUser();
			else if (cmd.startsWith("User_"))
				page = new UserInfo(Users.this, cmd.substring(5));
			else
				page = new Error(Users.this);
			if (page != null)
				Users.this._frame.changePanel(page.createPage());
			else
				search_list = null;
		}

		public BasePage searchUser() {
			String username = username_field.getText();
			username_field.setText("");
			boolean is_valid = true;
			if (username.equals("")) {
				username_error.setText("Please input username");
				search_list = null;
				return (null);
			}
			else {
				search_list = SQL.select_like("SELECT name FROM member WHERE is_public=1 and name LIKE ?", 1, username);
				if (search_list.size() == 0) {
					search_list = null;
					return (null);
				}
				else
					return (new Users(Users.this));

			}
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		JLabel label = panel.createLabel("Users", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel username_label = panel.createLabel("Username Search: ", 0.05, 0.2, 0.15, 0.05);
		username_field = panel.createTextField("", 0.2, 0.2, 0.5, 0.05);
		username_error = panel.createLabel("",0.2, 0.25, 0.6, 0.05);
		username_error.setForeground(Color.RED);

		Action action = new Action();

		JButton button = panel.createButton("Search", 0.75, 0.2, 0.1, 0.05);
		button.addActionListener(action);
		panel.add(button);

		if (search_list != null) {
			for (int i = 0; i < search_list.size(); i++) {
				ArrayList<String> str_list = search_list.get(i);
				String username = str_list.get(0);
				JButton search_ans = panel.createButton(username, 0.35, 0.4 + i*0.06, 0.3, 0.05);
				search_ans.setActionCommand("User_" + username);
				search_ans.addActionListener(action);
				panel.add(search_ans);
			}
		}

		panel.add(label);
		panel.add(username_label);
		panel.add(username_field);
		panel.add(username_error);

		return (panel);
	}
}
