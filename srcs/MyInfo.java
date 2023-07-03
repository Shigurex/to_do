import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MyInfo extends BaseComponent{
	public MyInfo(BaseFrame frame) {
		super(frame);
	}

	public Component createMyInfo() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		//email.passwordも保存しておくべきか、passwordはログイン時に取れるがemailはどうするか
		JLabel label = panel.createLabel("My Information", 0.4, 0.1, 0.2, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: " + _username, 0.3, 0.2, 0.15, 0.05);
		JLabel email_label = panel.createLabel("email: ", 0.3, 0.3, 0.15, 0.05);
		JLabel password_label = panel.createLabel("password: ", 0.3, 0.4, 0.15, 0.05);

		panel.add(label);
		panel.add(username_label);
		panel.add(email_label);
		panel.add(password_label);


		panel.add(label);

		JButton button = panel.createButton("Go to Edit", 0.4, 0.7, 0.2, 0.1);
		ButtonAction buttonlistener = new ButtonAction();
		button.addActionListener(buttonlistener);
		button.setActionCommand("Go to Edit");
		panel.add(button);

		return (panel);
	}

}