import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MyInfoEdit extends BasePage {
	private JTextField email_field;
	private JPasswordField password_field;
	private JLabel username_error;
	private JLabel email_error;
	private JLabel password_error;
	private JLabel flash_message;
	private String username;
	private String email;

	public MyInfoEdit(BasePage page) { super(page); }
	public MyInfoEdit(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Complete Editing"))
				page = checkEdit();
			else if (cmd.equals("Back to MyInfo"))
				page = new MyInfo(MyInfoEdit.this);
			else
				page = new Error(MyInfoEdit.this);

			if (page != null)
				MyInfoEdit.this._frame.changePanel(page.createPage());
		}

		public BasePage checkEdit() {
			String email = email_field.getText();
			String password = new String(password_field.getPassword());
			resetAllField();

			if (!isValid(email, password))
				return (null);
			if (!checkDuplication(email))
				return (null);
			if (!checkPass(password))
				return (null);
			else {
				String id = MyInfoEdit.this._frame.getLoginId();
				updateEmail(email, id);
				return (new MyInfo(MyInfoEdit.this, "User update!"));
			}
		}


		public static void updateEmail(String email, String id) {
			SQL.update("update member set email = ? where id = ?", email, id);
		}

		public boolean checkPass(String password) {
			String id = MyInfoEdit.this._frame.getLoginId();
			ArrayList<ArrayList<String>> info = SQL.select("SELECT password FROM member WHERE id=?", 1, id);
			if (info.size() == 0)
				return (false);
			ArrayList<String> str_list = info.get(0);
			if (password.equals(str_list.get(0)))
				return (true);
			else
				return (false);
		}

		public boolean checkDuplication(String email) {
			boolean check = true;

			ArrayList<ArrayList<String>> info = SQL.select("SELECT * FROM member WHERE email=?", 1, email);
			if (info.size() == 0)
				check = true;
			else {
				email_error.setText("This email has already used");
				check = false;
			}
			return (check);
		}

		public boolean isValid(String email, String password) {
			boolean is_valid = true;
			if (email.equals("")) {
				email_error.setText("Please input email");
				is_valid = false;
			}
			else
				email_error.setText("");
			if (password.equals("")) {
				password_error.setText("Please input password");
				is_valid = false;
			}
			else
				password_error.setText("");
			return (is_valid);
		}

		public void resetAllField() {
			flash_message.setText("");
			email_field.setText("");
			password_field.setText("");
		}
	}

	public void setMyInfo()
	{
		String id = MyInfoEdit.this._frame.getLoginId();
		ArrayList<ArrayList<String>> info = SQL.select("select name, email from member where id=?", 2, id);
		ArrayList<String> str_list = info.get(0);
		this.username = str_list.get(0);
		this.email = str_list.get(1);
	}

	public BasePanel createPage() {
		BasePanel panel = new BasePanel(this._frame);
		panel.is_menu = true;
		panel.setLayout(null);
		this.setMyInfo();

		flash_message = panel.createLabel("",0.45, 0.05, 0.2, 0.05);
		flash_message.setForeground(Color.GREEN);
		JLabel label = panel.createLabel("My Information Edit", 0.45, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		JLabel username_label2 = panel.createLabel(username, 0.2, 0.2, 0.15, 0.05);

		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		email_field = panel.createTextField(email, 0.2, 0.3, 0.6, 0.05);
		email_error = panel.createLabel("", 0.2, 0.35, 0.5, 0.05);
		email_error.setForeground(Color.RED);

		JLabel password_label = panel.createLabel("password: ", 0.05, 0.4, 0.15, 0.05);
		password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);
		password_error = panel.createLabel("", 0.2, 0.45, 0.5, 0.05);
		password_error.setForeground(Color.RED);

		panel.add(label);
		panel.add(flash_message);
		panel.add(username_label);
		panel.add(username_label2);
		panel.add(email_label);
		panel.add(email_error);
		panel.add(email_field);
		panel.add(password_label);
		panel.add(password_error);
		panel.add(password_field);

		Action action = new Action();

		JButton button = panel.createButton("Back to MyInfo", 0.2, 0.7, 0.2, 0.1);
		button.addActionListener(action);
		panel.add(button);

		JButton button2 = panel.createButton("Complete Editing", 0.5, 0.7, 0.2, 0.1);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
