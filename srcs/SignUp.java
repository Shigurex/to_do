import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends BasePage {
	private JTextField username_field;
	private JTextField email_field;
	private JPasswordField password_field;
	private JLabel username_error;
	private JLabel email_error;
	private JLabel password_error;

	public SignUp(BasePage page) { super(page); }
	public SignUp(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Register"))
				page = checkSignUp();
			else if (cmd.equals("Back to Login"))
				page = new Login(SignUp.this);
			else
				page = new Error(SignUp.this);

			if (page != null)
				SignUp.this._frame.changePanel(page.createPage());
		}

		public BasePage checkSignUp() {
			String username = username_field.getText();
			String email = email_field.getText();
			String password = new String(password_field.getPassword());
			resetAllField();

			if (!isValid(username, email, password))
				return (null);
			else
			{
				SQL.insertUser(username, email, password);
				return (new Login(SignUp.this));
			}
		}

		public boolean isValid(String username, String email, String password) {
			boolean is_valid = true;
			if (username.equals(""))
			{
				username_error.setText("Please input username");
				is_valid = false;
			}
			else
				username_error.setText("");
			if (email.equals(""))
			{
				email_error.setText("Please input username");
				is_valid = false;
			}
			else
				email_error.setText("");
			if (password.equals(""))
			{
				password_error.setText("Please input password");
				is_valid = false;
			}
			else
				password_error.setText("");
			return (is_valid);
		}

		public void resetAllField() {
			username_field.setText("");
			email_field.setText("");
			password_field.setText("");
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("SignUp", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		username_error = panel.createLabel("", 0.2, 0.25, 0.5,0.05);
		username_error.setForeground(Color.RED);

		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		email_field = panel.createTextField("", 0.2, 0.3, 0.6, 0.05);
		email_error = panel.createLabel("", 0.2, 0.35, 0.5, 0.05);
		email_error.setForeground(Color.RED);

		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);
		password_error = panel.createLabel("", 0.2, 0.45, 0.5, 0.05);
		password_error.setForeground(Color.RED);

		panel.add(label);
		panel.add(username_label);
		panel.add(username_error);
		panel.add(username_field);
		panel.add(email_label);
		panel.add(email_error);
		panel.add(email_field);
		panel.add(password_label);
		panel.add(password_error);
		panel.add(password_field);

		Action action = new Action();

		JButton button = panel.createButton("Back to Login", 0.2, 0.8, 0.2, 0.1);
		button.addActionListener(action);
		panel.add(button);

		JButton button2 = panel.createButton("Register", 0.5, 0.8, 0.2, 0.1);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
