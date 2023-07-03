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

		JLabel label = panel.createLabel("MyInfo", 0.45, 0.1, 0.3, 0.05);

		panel.add(label);

		JButton button = panel.createButton("My Info Edit", 0.1, 0.8, 0.1, 0.1);
		ButtonAction buttonlistener = new ButtonAction();
		button.addActionListener(buttonlistener);
		button.setActionCommand("My Info Edit");
		panel.add(button);

		return (panel);
	}

}