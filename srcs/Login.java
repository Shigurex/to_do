import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;

public class Login extends BasePage {
	public Login(BasePage page) { super(page); }
	public Login(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("aaa");
		}
	}

	public Component createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Login", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));

		panel.add(label);

		return (panel);
	}
}
