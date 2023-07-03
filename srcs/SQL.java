import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class SQL {
	private Statement _stmt;
	private Connection _conn;
	private String _dbname = "./database/test.db";

	public SQL(Statement _stmt, Connection _conn, String _dbname) {
		this._stmt = _stmt;
		this._conn = _conn;
		this._dbname = _dbname;
	}

	public void insertUser(String name, String email, String password) {
		try {
			Class.forName("org.sqlite.JDBC");
			_conn = DriverManager.getConnection("jdbc:sqlite:" + _dbname);

			String sql = "insert into user(name,email, password) VALUES(?,?,?)";
			PreparedStatement ps = _conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.executeUpdate();
			ps.close();
			System.out.println("Insert " + name + " " + email + " " + password);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (_stmt != null) {
					_stmt.close();
				}
				if (_conn != null) {
					_conn.close();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}



	public boolean checkUser(String username, String input_password) {
		boolean check = false;
		try {
				Class.forName("org.sqlite.JDBC");
				_conn = DriverManager.getConnection("jdbc:sqlite:" + _dbname);

				String sql = "SELECT password FROM user WHERE name=?";
				PreparedStatement ps = _conn.prepareStatement(sql);
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String password = rs.getString("password");
					if (password.equals(input_password)) {
						check = true;
						break ;
					}
					else
						check = false;
				}
				ps.close();
				rs.close();
				return(check);

			} catch (Exception e) {
				e.printStackTrace();
				return (check);
			} finally {
				try {
					if (_stmt != null) {
						_stmt.close();
					}
					if (_conn != null) {
						_conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return (check);
			}
	}
}