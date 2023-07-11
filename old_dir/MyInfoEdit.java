import java.awt.*;
import javax.swing.*;

public class MyInfoEdit extends BaseComponent{
	public MyInfoEdit(BaseFrame frame) {
		super(frame);
	}

	public Component create() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		//createTextFieldに過去の情報を埋め込む
		JLabel label = panel.createLabel("My Information Edit", 0.4, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		_username_field = panel.createTextField("", 0.2, 0.2, 0.6, 0.05);
		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		_email_field = panel.createTextField("", 0.2, 0.3, 0.6, 0.05);
		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		_password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);

		panel.add(label);
		panel.add(username_label);
		panel.add(_username_field);
		panel.add(email_label);
		panel.add(_email_field);
		panel.add(password_label);
		panel.add(_password_field);

		JButton button = panel.createButton("Complete Editing", 0.4, 0.7, 0.2, 0.1);
		ButtonAction buttonlistener = new ButtonAction();
		button.addActionListener(buttonlistener);
		panel.add(button);

		return (panel);
	}

}