import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends BasePage {
	private JTextField username_field;
	private JPasswordField password_field;
	private JLabel username_error;
	private JLabel password_error;

	public Login(BasePage page) { super(page); }
	public Login(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Back SignUp"))
				page = new SignUp(Login.this);
			else if (cmd.equals("Login"))
				page = checkLogin();
			else
				page = new Error(Login.this);

			if (page != null)
				Login.this._frame.changePanel(page.createPage());
		}

		public BasePage checkLogin() {
			String username = username_field.getText();
			String password = new String(password_field.getPassword());
			resetNamePass();

			if (!isValid(username, password))
				return (null);
			else if (SQL.checkUser(username, password) == true)
				return (new SignUp(Login.this));
			else
				return (new Error(Login.this));
		}

		public boolean isValid(String username, String password) {
			boolean is_valid = true;
			if (username.equals(""))
			{
				username_error.setText("Please input username");
				is_valid = false;
			}
			if (password.equals(""))
			{
				password_error.setText("Please input password");
				is_valid = false;
			}
			return (is_valid);
		}

		public void resetNamePass() {
			username_field.setText("");
			password_field.setText("");
		}
	}

	public Component createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Login", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		username_error = panel.createLabel("",0.2, 0.25, 0.6, 0.05);
		username_error.setForeground(Color.RED);
		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);
		password_error = panel.createLabel("",0.2, 0.45, 0.6, 0.05);
		password_error.setForeground(Color.RED);

		panel.add(label);
		panel.add(username_label);
		panel.add(username_field);
		panel.add(username_error);
		panel.add(password_label);
		panel.add(password_field);
		panel.add(password_error);

		Action action = new Action();

		JButton button = panel.createButton("Back SignUp", 0.2, 0.8, 0.2, 0.1);
		button.addActionListener(action);
		panel.add(button);

		JButton button2 = panel.createButton("Login", 0.5, 0.8, 0.2, 0.1);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
