import java.awt.*;

public class List extends BaseComponent {
	public List(BaseFrame frame) {
		super(frame);
	}

	public Component create() {
		//_username = username;
		BasePanel panel = new BasePanel(_frame);
		panel.setLayout(null);

		//JLabel label = panel.createLabel((_username + " List"), 0.45, 0.1, 0.3, 0.05);

		//panel.add(label);

		return (panel);
	}
}