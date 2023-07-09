import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BaseComponent {
	protected JTextField _username_field;
	protected JTextField _email_field;
	protected JPasswordField _password_field;
	protected static String _username;
	protected BaseFrame _frame;

	public BaseComponent(BaseFrame frame) {_frame = frame;}

	//ログイン後の画面　panelとsqlの操作が混ざっているため検討中
	//public Component createList(String message, String username) {
	//	BasePanel panel = new BasePanel(_frame);
	//	panel.setLayout(null);

	//	try {
	//		Class.forName("org.sqlite.JDBC");
	//		_conn = DriverManager.getConnection("jdbc:sqlite:" + _dbname);
	//		_stmt = _conn.createStatement();
	//		ResultSet rs = _stmt.executeQuery("SELECT * FROM user WHERE name='" + username + "'");

	//		JLabel flash_label = panel.createLabel(message, 0.45, 0.05, 0.3, 0.05);
	//		flash_label.setForeground(Color.GREEN);
	//		panel.add(flash_label);
	//		int i = 1;
	//		while (rs.next()) {
	//			JLabel name_label = panel.createLabel(rs.getString("name"), 0.2, 0.2*i, 0.6, 0.05);
	//			JLabel email_label = panel.createLabel(rs.getString("email"), 0.2, 0.2*i + 0.1, 0.6, 0.05);

	//			panel.add(name_label);
	//			panel.add(email_label);
	//			i++;
	//		}
	//		rs.close();
	//		return (panel);
	//	} catch (Exception e) {
	//			e.printStackTrace();
	//	} finally {
	//		try {
	//			if (_stmt != null) {
	//				_stmt.close();
	//			}
	//			if (_conn != null) {
	//				_conn.close();
	//			}
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}
	//		return (panel);
	//	}
	//}

	public void resetAllField() {
		_username_field.setText("");
		_email_field.setText("");
		_password_field.setText("");
	}

	public void resetNamePass() {
		_username_field.setText("");
		_password_field.setText("");
	}

	public void checkLogin(SignUp signup, Login login) {
		_username = _username_field.getText();
		String password = new String(_password_field.getPassword());
		resetNamePass();

		if (_username.equals("") || password.equals(""))
			_frame.changePanel(login.createLogin("Please input all information!"));
		else if (SQL.checkUser(_username, password) == true)
		{
			List list = new List(_frame);
			Menu menu = new Menu(_frame);
			_frame.changePanel_Menu(list.createList(_username), menu.createMenu());
		}
		else
			_frame.changePanel(login.createLogin("Wrong username or password"));
	}

	public void checkSignUp(SignUp signup, Login login) {
		_username = _username_field.getText();
		String email = _email_field.getText();
		String password = new String(_password_field.getPassword());
		resetAllField();

		
		if (_username.equals("") || email.equals("") || password.equals(""))
			_frame.changePanel(signup.createSignUp("Please input all information!"));
		else {
			SQL.insertUser(_username, email, password);
			_frame.changePanel(login.createLogin("Create User!"));
		}
	}

	protected class ButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			SignUp signup = new SignUp(_frame);
			Login login = new Login(_frame);
			Users users = new Users(_frame);
			MyInfo myinfo = new MyInfo(_frame);
			MyInfoEdit myinfo_edit = new MyInfoEdit(_frame);
			List list = new List(_frame);
			Menu menu = new Menu(_frame);

			if (cmd.equals("Register")) {
				checkSignUp(signup, login);
			}
			else if (cmd.equals("Login")) {
				checkLogin(signup, login);
			}
			else if (cmd.equals("Start"))
				_frame.changePanel(signup.createSignUp(""));
			else if (cmd.equals("Already Registered"))
				_frame.changePanel(login.createLogin(""));
			else if (cmd.equals("Back SignUp"))
				_frame.changePanel(signup.createSignUp(""));
			else if (cmd.equals("My Info"))
				_frame.changePanel_Menu(myinfo.createMyInfo(), menu.createMenu());
			else if (cmd.equals("Go to Edit"))
				_frame.changePanel_Menu(myinfo_edit.createMyInfoEdit(), menu.createMenu());
			else if (cmd.equals("Complete Editing"))
				_frame.changePanel_Menu(myinfo_edit.createMyInfoEdit(), menu.createMenu());
			else if (cmd.equals("My List"))
				_frame.changePanel_Menu(list.createList(_username), menu.createMenu());
			else if (cmd.equals("Users"))
				_frame.changePanel_Menu(users.createUsers(), menu.createMenu());
			else if (cmd.equals("Logout"))
				_frame.changePanel(login.createLogin("Logout succesfully!"));
			else if (cmd.equals("Exit"))
				System.exit(0);
		}
	}
}
