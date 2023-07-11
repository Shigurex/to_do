import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends BasePage {
	public SignUp(BasePage page) { super(page); }
	public SignUp(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;
			
			if (cmd.equals("Register"))
				page = new Login(SignUp.this);
			else if (cmd.equals("Already Registered"))
				page = new Login(SignUp.this);
			else
				page = new Error(SignUp.this);

			if (page != null)
				SignUp.this._frame.changePanel(page.createPage());
		}
	}

	public Component createPage() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		//JLabel welcome_label = panel.createLabel(message, 0.45, 0.05, 0.3, 0.05);
		JLabel label = panel.createLabel("SignUp", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		//JLabel name_err_label = panel.createLabel(name_err, 0.2, 0.25, 0.5,0.05);
		JTextField username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);

		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		//JLabel email_err_label = panel.createLabel(email_err, 0.2, 0.35, 0.5, 0.05);
		JTextField email_field = panel.createTextField("", 0.2, 0.3, 0.6, 0.05);

		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		//JLabel password_err_label = panel.createLabel(password_err, 0.2, 0.45, 0.5, 0.05);
		JPasswordField password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);

		panel.add(label);
		panel.add(username_label);
		//panel.add(name_err_label);
		panel.add(username_field);
		panel.add(email_label);
		//panel.add(email_err_label);
		panel.add(email_field);
		panel.add(password_label);
		//panel.add(password_err_label);
		panel.add(password_field);

		Action action = new Action();

		JButton button = panel.createButton("Register", 0.2, 0.8, 0.2, 0.1);
		button.addActionListener(action);
		panel.add(button);

		JButton button2 = panel.createButton("Already Registered", 0.5, 0.8, 0.2, 0.1);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
