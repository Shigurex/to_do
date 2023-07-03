import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class List extends BaseComponent{
	public List(BaseFrame frame) {
		super(frame);
	}

	public Component createList() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("List", 0.45, 0.1, 0.3, 0.05);

		panel.add(label);

		return (panel);
	}
}