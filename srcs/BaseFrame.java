import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


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
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}


	public String getTitle() {
		return (this._title);
	}

	public int getWinWidth() {
		return (this._win_width);
	}

	public int getWinHeight() {
		return (this._win_height);
	}

	public void changePanel(Component content) {
		getContentPane().removeAll();
		super.add(content);
		validate();
		repaint();
	}
}