import javax.swing.*;

public class BasePanel extends JPanel {
	private BaseFrame _frame;
	protected String _title;
	protected int _win_width;
	protected int _win_height;
	public boolean is_menu;

	public BasePanel(BaseFrame frame) {
		this._frame = frame;
		this._title = frame.getTitle();
		this._win_width = frame.getWinWidth();
		this._win_height = frame.getWinHeight();
		this.is_menu = false;
	}

	public BaseFrame getFrame() { return (this._frame); }

	public int convertAbsToRelValue(int abs_value, double rate) {
		int rel_value = (int)(abs_value * rate);
		return (rel_value);
	}

	public JButton createButton(String name, double x, double y, double width, double height) {
		JButton button = new JButton(name);
		button.setBounds(convertAbsToRelValue(this._win_width, x),
			convertAbsToRelValue(this._win_height, y),
			convertAbsToRelValue(this._win_width, width),
			convertAbsToRelValue(this._win_height, height));
		button.setActionCommand(name);
		return (button);
	}

	public JTextField createTextField(String name, double x, double y, double width, double height) {
		JTextField text_field = new JTextField(name);
		text_field.setBounds(convertAbsToRelValue(this._win_width, x),
			convertAbsToRelValue(this._win_height, y),
			convertAbsToRelValue(this._win_width, width),
			convertAbsToRelValue(this._win_height, height));
		return (text_field);
	}

	public JLabel createLabel(String name, double x, double y, double width, double height) {
		JLabel label = new JLabel(name);
		label.setBounds(convertAbsToRelValue(this._win_width, x),
			convertAbsToRelValue(this._win_height, y),
			convertAbsToRelValue(this._win_width, width),
			convertAbsToRelValue(this._win_height, height));
		return (label);
	}

	public JPasswordField createPasswordField(String name, double x, double y, double width, double height) {
		JPasswordField password_field = new JPasswordField(name);
		password_field.setBounds(convertAbsToRelValue(this._win_width, x),
			convertAbsToRelValue(this._win_height, y),
			convertAbsToRelValue(this._win_width, width),
			convertAbsToRelValue(this._win_height, height));
		return (password_field);
	}

	public JRadioButton createRadioButton(String name, boolean selected, double x, double y, double width, double height) {
		JRadioButton radio = new JRadioButton(name, selected);
		radio.setBounds(convertAbsToRelValue(this._win_width, x),
			convertAbsToRelValue(this._win_height, y),
			convertAbsToRelValue(this._win_width, width),
			convertAbsToRelValue(this._win_height, height));
		radio.setActionCommand(name);
		return (radio);
	}
}