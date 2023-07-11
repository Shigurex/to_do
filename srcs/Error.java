import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Error extends BasePage {
	public Error(BasePage page) { super(page); }
	public Error(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) { return ;}
	}

	public Component createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Error", 0.45, 0.2, 0.1, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(label);

		return (panel);
	}
}
