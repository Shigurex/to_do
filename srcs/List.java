import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class List extends BaseComponent{
	public List(BaseFrame frame) {
		super(frame);
	}

	public Component createList(String username) {
		_username = username;
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel((_username + " List"), 0.45, 0.1, 0.3, 0.05);

		panel.add(label);

		return (panel);
	}
}