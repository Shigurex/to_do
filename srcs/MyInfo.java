import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyInfo extends BasePage {
	private static String username;

	public MyInfo(BasePage page) { super(page); }
	public MyInfo(BasePage page, String username) {
		super(page);
		this.username = username;
	}
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

	public Component createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("My Information", 0.4, 0.1, 0.2, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: " + this.username, 0.3, 0.2, 0.15, 0.05);
		JLabel email_label = panel.createLabel("email: ", 0.3, 0.3, 0.15, 0.05);
		JLabel password_label = panel.createLabel("password: ", 0.3, 0.4, 0.15, 0.05);

		panel.add(label);
		panel.add(username_label);
		panel.add(email_label);
		panel.add(password_label);

		JButton button = panel.createButton("Go to Edit", 0.4, 0.7, 0.2, 0.1);
		Action action = new Action();
		button.addActionListener(action);
		panel.add(button);

		return (panel);
	}
}
