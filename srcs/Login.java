import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends BasePage {
	public Login(BasePage page) { super(page); }
	public Login(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("aaa");
		}
	}

	public Component createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Login", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));

		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		JTextField _username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		JLabel password_label = panel.createLabel("password: ", 0.05, 0.3, 0.15, 0.05);
		JTextField _password_field = panel.createPasswordField("", 0.2, 0.3, 0.6, 0.05);

		panel.add(label);
		panel.add(username_label);
		panel.add(_username_field);
		panel.add(password_label);
		panel.add(_password_field);

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
