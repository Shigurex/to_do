public class GUI {
	private static final String _title = "ToDo";
	private static final int _win_width = 900;
	private static final int _win_height = 600;

	public static void main(String[] args) {
		//SQL.insert("INSERT INTO share (task, member, is_editable) VALUES (?, ?, ?);", String.valueOf(2), String.valueOf(2), String.valueOf(true ? 1 : 0));
		//SQL.insert("INSERT INTO todo (task, title, deadline, create_time, update_time) VALUES (?, ?, ?, ?, ?);", String.valueOf(1), "java final report", "2023/07/23 23:50:00", "2023/07/23 23:50:00", "2023/07/23 23:50:00");
		SQL.getLog();
		BaseFrame frame = new BaseFrame(GUI._title, GUI._win_width, GUI._win_height);
		BasePage page = new Start(frame);
		BasePanel component = page.createPage();
		frame.changePanel(component);
		frame.setVisible(true);
	}
}
