import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MyInfo extends BasePage {
	private String username;
	private String email;

	public MyInfo(BasePage page) { super(page); }
	public MyInfo(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Go to Edit"))
				page = new MyInfoEdit(MyInfo.this);
			else
				page = new Error(MyInfo.this);

			if (page != null)
				MyInfo.this._frame.changePanel(page.createPage());
		}
	}

	public void setMyInfo()
	{
		String id = MyInfo.this._frame.getLoginId();
		ArrayList<ArrayList<String>> info = SQL.select("select name, email from member where id=?", 2, id);
		ArrayList<String> str_list = info.get(0);
		this.username = str_list.get(0);
		this.email = str_list.get(1);
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);
		this.setMyInfo();
		
		JLabel label = panel.createLabel("My Information", 0.4, 0.1, 0.2, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: " + this.username, 0.3, 0.2, 0.15, 0.05);
		JLabel email_label = panel.createLabel("email: " + this.email, 0.3, 0.3, 0.15, 0.05);

		panel.add(label);
		panel.add(username_label);
		panel.add(email_label);

		JButton button = panel.createButton("Go to Edit", 0.4, 0.6, 0.1, 0.05);
		Action action = new Action();
		button.addActionListener(action);
		panel.add(button);

		return (panel);
	}
}
