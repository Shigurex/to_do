import java.awt.*;
import javax.swing.*;

public class Users extends BaseComponent{
	public Users(BaseFrame frame) {
		super(frame);
	}

	public Component create() {
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		JLabel label = panel.createLabel("Users", 0.45, 0.1, 0.3, 0.05);

		panel.add(label);

		return (panel);
	}
}