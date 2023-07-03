import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Menu extends BaseComponent {
	public Menu(BaseFrame frame) {
		super(frame);
	}

	public Component createMenu() {
		BasePanel panel = new BasePanel(_frame);
		// panel.setLayout(null);

		// JButton button = panel.createButton("test1", 0.1, 0.8, 0.1, 0.1);
		JButton button = new JButton("My Info");
		ButtonAction buttonlistener = new ButtonAction();
		button.addActionListener(buttonlistener);
		button.setActionCommand("My Info");
		panel.add(button);

		// JButton button2 = panel.createButton("test2", 0.2, 0.8, 0.1, 0.1);
		JButton button2 = new JButton("My List");
		ButtonAction buttonlistener2 = new ButtonAction();
		button2.addActionListener(buttonlistener2);
		button2.setActionCommand("My List");
		panel.add(button2);

		JButton button3 = new JButton("Users");
		ButtonAction buttonlistener3 = new ButtonAction();
		button3.addActionListener(buttonlistener3);
		button3.setActionCommand("Users");
		panel.add(button3);

		JButton button4 = new JButton("Logout");
		ButtonAction buttonlistener4 = new ButtonAction();
		button4.addActionListener(buttonlistener4);
		button4.setActionCommand("Logout");
		panel.add(button4);

		JButton button5 = new JButton("Exit");
		ButtonAction buttonlistener5 = new ButtonAction();
		button5.addActionListener(buttonlistener5);
		button5.setActionCommand("Exit");
		panel.add(button5);

		return (panel);
	}
}