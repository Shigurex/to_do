import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class GUI {
	public static void main(String[] args) {
		SQL.getLog();
		BaseFrame frame = new BaseFrame("ToDo", 900, 600);
		// BaseComponent component = new BaseComponent(frame);
		SignUp signup = new SignUp(frame);
		Component content = signup.createSignUp("Welcome");
		frame.getContentPane().add(content);
		frame.setVisible(true);
	}
}