import java.awt.*;

public class GUI {
	public static void main(String[] args) {
		SQL.getLog();
		BaseFrame frame = new BaseFrame("ToDo", 900, 600);
		Start start = new Start(frame);
		Component content = start.create();
		frame.changePanel(content);
		frame.setVisible(true);
	}
}