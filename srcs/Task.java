import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Task extends BasePage {
	public Task(BasePage page) { super(page); }
	public Task(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);

		JLabel label = panel.createLabel("Task", 0.45, 0.1, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		return (panel);
	}
}