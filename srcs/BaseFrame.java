import java.awt.*;
import javax.swing.*;

public class BaseFrame extends JFrame {
	private String _title;
	private int _win_width;
	private int _win_height;

	public BaseFrame(String title, int width, int height) {
		super(title);

		this._title = title;
		this._win_width = width;
		this._win_height = height;

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(this._win_width, this._win_height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public String getTitle() { return (this._title); }
	public int getWinWidth() { return (this._win_width); }
	public int getWinHeight() { return (this._win_height); }

	public void changePanel(BasePanel content) {
		getContentPane().removeAll();
		super.add(content);
		if (content.is_menu) {
			BasePage menu = new Menu(content.getFrame());
			super.add(menu.createPage(), BorderLayout.PAGE_START);
		}
		validate();
		repaint();
	}

	//public void changePanelMenu(Component content, Component menu) {
	//	getContentPane().removeAll();
	//	super.add(content);
	//	//super.add(menu, BorderLayout.PAGE_START);
	//	super.add(menu);
	//	validate();
	//	repaint();
	//}
}