import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Share extends BasePage {
	private int task_id;

	public Share(BasePage page) { super(page); }
	public Share(BaseFrame frame) { super(frame); }
	public Share(BasePage page, int task_id) {
		super(page);
		this.task_id = task_id;
	}

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Share"))
				page = new Login(Share.this);
			else
				page = new Error(Share.this);

			if (page != null)
				Share.this._frame.changePanel(page.createPage());
		}
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Share", 0.35, 0.2, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label);

		JButton button = panel.createButton("Start", 0.4, 0.5, 0.2, 0.1);
		Action action = new Action();
		button.addActionListener(action);
		panel.add(button);

		return (panel);
	}
}