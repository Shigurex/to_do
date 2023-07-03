import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MyInfoEdit extends BaseComponent{
	public MyInfoEdit(BaseFrame frame) {
		super(frame);
	}

	public Component createMyInfoEdit() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("MyInfoEdit", 0.45, 0.1, 0.3, 0.05);

		panel.add(label);

		return (panel);
	}

}