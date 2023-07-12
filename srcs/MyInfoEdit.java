import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyInfoEdit extends BasePage {
	private JTextField username_field;
	private JTextField email_field;
	private JPasswordField password_field;

	public MyInfoEdit(BasePage page) { super(page); }
	public MyInfoEdit(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Complete Editing"))
				page = new MyInfo(MyInfoEdit.this);
			else if (cmd.equals("Back to MyInfo"))
				page = new MyInfo(MyInfoEdit.this);
			else
				page = new Error(MyInfoEdit.this);

			if (page != null)
				MyInfoEdit.this._frame.changePanel(page.createPage());
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("My Information Edit", 0.4, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		email_field = panel.createTextField("", 0.2, 0.3, 0.6, 0.05);
		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);

		panel.add(label);
		panel.add(username_label);
		panel.add(username_field);
		panel.add(email_label);
		panel.add(email_field);
		panel.add(password_label);
		panel.add(password_field);

		Action action = new Action();

		JButton button = panel.createButton("Back to MyInfo", 0.2, 0.7, 0.2, 0.1);
		button.addActionListener(action);
		panel.add(button);

		JButton button2 = panel.createButton("Complete Editing", 0.5, 0.7, 0.2, 0.1);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
