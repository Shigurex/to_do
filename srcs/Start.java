import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Start extends BaseComponent {

	public Start(BaseFrame frame) {
		super(frame);
	}

	public Component createStart()  {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("To Do", 0.45, 0.2, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		JButton button = panel.createButton("Start", 0.4, 0.5, 0.2, 0.1);
		ButtonAction buttonlistener = new ButtonAction();
		button.addActionListener(buttonlistener);
		button.setActionCommand("Start");
		panel.add(button);

		return (panel);
	}
}