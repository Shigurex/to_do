import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends BaseComponent {

	public SignUp(BaseFrame frame) {
		super(frame);
	}

	public Component createSignUp(String message)  {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel welcome_label = panel.createLabel(message, 0.45, 0.05, 0.3, 0.05);
		JLabel label = panel.createLabel("SignUp", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		_username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		_email_field = panel.createTextField("", 0.2, 0.3, 0.6, 0.05);
		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		_password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);

		panel.add(welcome_label);
		panel.add(label);
		panel.add(username_label);
		panel.add(_username_field);
		panel.add(email_label);
		panel.add(_email_field);
		panel.add(password_label);
		panel.add(_password_field);

		JButton button = panel.createButton("Register", 0.2, 0.8, 0.2, 0.1);
		ButtonAction buttonlistener = new ButtonAction();
		button.addActionListener(buttonlistener);
		button.setActionCommand("Register");
		panel.add(button);

		JButton button2 = panel.createButton("Already Registered", 0.5, 0.8, 0.2, 0.1);
		ButtonAction buttonlistener2 = new ButtonAction();
		button2.addActionListener(buttonlistener2);
		button2.setActionCommand("Already Registered");
		panel.add(button2);

		return (panel);
	}
}