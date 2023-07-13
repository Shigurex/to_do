import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

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

		ArrayList<ArrayList<String>> info = SQL.select("select name from member", 1);
		int panel_size = info.size();
		if (0.3 + panel_size * 0.05 > 1)
			panel.setPreferredSize(new Dimension(900, (int)(this._frame.getWinHeight() * (0.3 + panel_size * 0.05))));
		for (int i = 0; i < info.size(); i++) {
			ArrayList<String> str_list = info.get(i);
			String username = str_list.get(0);
			JLabel label = panel.createLabel(username, 0.45, 0.2 + i*0.05, 0.3, 0.05);
			panel.add(label);
			System.out.println(username);
		}

		JLabel label = panel.createLabel("Users", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		return (panel);
	}
}
