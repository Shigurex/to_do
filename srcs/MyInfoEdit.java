import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MyInfoEdit extends BasePage {
	private JTextField email_field;
	private JPasswordField password_field;
	private JPasswordField confirm_field;
	private JPasswordField old_password_field;
	private JLabel email_error;
	private JLabel password_error;
	private JLabel confirm_error;
	private JLabel old_password_error;
	private JLabel flash_message;
	private String username;
	private String email;
	ButtonGroup bgroup;

	public MyInfoEdit(BasePage page) { super(page); }
	public MyInfoEdit(BaseFrame frame) { super(frame); }

	public class Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			BasePage page = null;

			if (cmd.equals("Complete Editing")) {
				int option = JOptionPane.showConfirmDialog(MyInfoEdit.this._frame, "本当に更新しますか？","confirm", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION)
					page = checkEdit();
				else if (option == JOptionPane.NO_OPTION)
					page = null;
			}
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
			String confirm = new String(confirm_field.getPassword());
			String old_password = new String(old_password_field.getPassword());
			String is_public = bgroup.getSelection().getActionCommand();
			resetAllField(email);
			String id = MyInfoEdit.this._frame.getLoginId();

			if (!isValid(email))
				return (null);
			if (!checkDuplication(email))
				return (null);
			if (!checkUser(old_password, id))
				return (null);
			if (!confirm.equals(password)) {
				confirm_error.setText("Confirm password is not equal to password!");
				return (null) ;
			}
			else {
				if (checkPass(password, confirm))
					updatePassword(password, id);
				updateEmail(email, id);
				updateIsPublic(is_public, id);
				return (new MyInfo(MyInfoEdit.this, "User update!"));
			}
		}


		public static void updateEmail(String email, String id) {
			SQL.update("update member set email = ? where id = ?", email, id);
		}

		public static void updateIsPublic(String is_public, String id) {
			if (is_public.equals("Public"))
				SQL.update("update member set is_public = ? where id = ?", "1", id);
			else
				SQL.update("update member set is_public = ? where id = ?", "0", id);
		}

		public static void updatePassword(String password, String id) {
				SQL.update("update member set password = ? where id = ?", password, id);
		}

		public boolean checkPass(String password, String confirm) {
			if (password.equals("") && confirm.equals(""))
				return (false);
			else
				return (true);
		}

		public boolean checkUser(String old_password, String id) {
			ArrayList<ArrayList<String>> info = SQL.select("SELECT password FROM member WHERE id=?", 1, id);
			if (info.size() == 0)
				return (false);
			ArrayList<String> str_list = info.get(0);
			if (old_password.equals(str_list.get(0)))
				return (true);
			else {
				old_password_error.setText("Wrong Password!");
				return (false);
			}
		}

		public boolean checkDuplication(String email) {
			String id;
			boolean check_mail = true;

			ArrayList<ArrayList<String>> info = SQL.select("SELECT id FROM member WHERE email=?", 1, email);
			if (info.size() == 0)
				check_mail = true;
			else {
				ArrayList<String> str_list = info.get(0);
				id = str_list.get(0);
				if (id.equals(MyInfoEdit.this._frame.getLoginId()))
					check_mail = true;
				else {
					email_error.setText("This email has already used");
					check_mail = false;
				}
			}
			return (check_mail);
		}

		public boolean isValid(String email) {
			boolean is_valid = true;
			if (email.equals("")) {
				email_error.setText("Please input email");
				is_valid = false;
			}
			else
				email_error.setText("");
			return (is_valid);
		}

		public void resetAllField(String email) {
			flash_message.setText("");
			email_field.setText(email);
			password_field.setText("");
			confirm_field.setText("");
			old_password_field.setText("");
			old_password_error.setText("");
		}
	}

	public void setMyInfo() {
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

		flash_message = panel.createLabel("",0.4, 0.05, 0.2, 0.05);
		flash_message.setForeground(Color.GREEN);
		flash_message.setHorizontalAlignment(JLabel.CENTER);
		JLabel label = panel.createLabel("My Information Edit", 0.35, 0.1, 0.3, 0.05);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		JLabel username_label = panel.createLabel("Username: ", 0.05, 0.2, 0.15, 0.05);
		JLabel username_label2 = panel.createLabel(username, 0.2, 0.2, 0.15, 0.05);

		JLabel email_label = panel.createLabel("email: ", 0.05, 0.3, 0.15, 0.05);
		email_field = panel.createTextField(email, 0.2, 0.3, 0.6, 0.05);
		email_error = panel.createLabel("", 0.2, 0.35, 0.5, 0.05);
		email_error.setForeground(Color.RED);

		JLabel password_label = panel.createLabel("New Password: ", 0.05, 0.4, 0.15, 0.05);
		password_field = panel.createPasswordField("", 0.2, 0.4, 0.6, 0.05);
		password_error = panel.createLabel("", 0.2, 0.45, 0.5, 0.05);
		password_error.setForeground(Color.RED);

		JLabel confirm_label = panel.createLabel("Confirm Password: ", 0.05, 0.5, 0.15, 0.05);
		confirm_field = panel.createPasswordField("", 0.2, 0.5, 0.6, 0.05);
		confirm_error = panel.createLabel("", 0.2, 0.55, 0.5, 0.025);
		confirm_error.setForeground(Color.RED);

		JRadioButton radio1 = panel.createRadioButton("Public", true, 0.2, 0.575, 0.15, 0.05);
		JRadioButton radio2 = panel.createRadioButton("Private", false, 0.4, 0.575, 0.2, 0.05);

		JLabel old_password_label = panel.createLabel("Old Password: ", 0.05, 0.65, 0.15, 0.05);
		old_password_field = panel.createPasswordField("", 0.2, 0.65, 0.6, 0.05);
		old_password_error = panel.createLabel("", 0.2, 0.7, 0.5, 0.05);
		old_password_error.setForeground(Color.RED);

		bgroup = new ButtonGroup();
		bgroup.add(radio1);
		bgroup.add(radio2);

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
		panel.add(confirm_label);
		panel.add(confirm_error);
		panel.add(confirm_field);
		panel.add(old_password_label);
		panel.add(old_password_field);
		panel.add(old_password_error);
		panel.add(radio1);
		panel.add(radio2);

		Action action = new Action();

		JButton button = panel.createButton("Back to MyInfo", 0.2, 0.75, 0.2, 0.05);
		button.addActionListener(action);
		panel.add(button);

		JButton button2 = panel.createButton("Complete Editing", 0.5, 0.75, 0.2, 0.05);
		button2.addActionListener(action);
		panel.add(button2);

		return (panel);
	}
}
