import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BasePanel extends JPanel{
	protected String _title;
	protected int _win_width;
	protected int _win_height;

	public BasePanel(BaseFrame frame) {
		this._title = frame.getTitle();
		this._win_width = frame.getWinWidth();
		this._win_height = frame.getWinHeight();
	}

	public JButton createButton(String name, double x, double y, double width, double height) {
		int x_abs = (int)(this._win_width * x);
		int y_abs = (int)(this._win_height * y);
		int width_abs = (int)(this._win_width * width);
		int height_abs = (int)(this._win_height * height);

		JButton button = new JButton(name);
		button.setBounds(x_abs, y_abs, width_abs, height_abs);

		return (button);
	}

	public JTextField createTextField(String name, double x, double y, double width, double height) {
		int x_abs = (int)(this._win_width * x);
		int y_abs = (int)(this._win_height * y);
		int width_abs = (int)(this._win_width * width);
		int height_abs = (int)(this._win_height * height);

		JTextField text_field = new JTextField(name);
		text_field.setBounds(x_abs, y_abs, width_abs, height_abs);

		return (text_field);
	}

	public JLabel createLabel(String name, double x, double y, double width, double height) {
		int x_abs = (int)(this._win_width * x);
		int y_abs = (int)(this._win_height * y);
		int width_abs = (int)(this._win_width * width);
		int height_abs = (int)(this._win_height * height);

		JLabel label = new JLabel(name);
		label.setBounds(x_abs, y_abs, width_abs, height_abs);

		return (label);
	}

	public JPasswordField createPasswordField(String name, double x, double y, double width, double height) {
		int x_abs = (int)(this._win_width * x);
		int y_abs = (int)(this._win_height * y);
		int width_abs = (int)(this._win_width * width);
		int height_abs = (int)(this._win_height * height);

		JPasswordField password_field = new JPasswordField(name);
		password_field.setBounds(x_abs, y_abs, width_abs, height_abs);

		return (password_field);
	}
}