import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Users extends BasePage {
	public Users(BasePage page) { super(page); }
	public Users(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		List<UserData> all_user = new ArrayList<UserData>();
		all_user = SQL.getAllUser();
		System.out.println(all_user);
		for (int i = 0; i < all_user.size(); i++) {
			UserData user = all_user.get(i);
			String username = user.getUsername();
			JLabel label = panel.createLabel(username, 0.45, 0.2 + i*0.1, 0.3, 0.05);
			panel.add(label);
			System.out.println(username);
		}
		JLabel label = panel.createLabel("Users", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		return (panel);
	}
}
