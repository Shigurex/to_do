import java.sql.*;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SQL {
	private static String db_dir = "./database/";
	private static String db_log_dir = "./database/log/";
	private static String db_name = "test.db";

	public static void getLog() {
		LocalDateTime currentLocalTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String time_log = currentLocalTime.format(formatter);

		Path file_from = Paths.get(SQL.db_dir + SQL.db_name);
		Path file_to = Paths.get(SQL.db_log_dir + time_log);

		try {
			Files.copy(file_from, file_to);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void insertUser(String name, String email, String password) {
		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + SQL.db_dir + SQL.db_name);

			String sql = "insert into user(name, email, password) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
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
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean checkUser(String username, String input_password) {
		Connection conn = null;
		boolean check = false;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + SQL.db_dir + SQL.db_name);

			String sql = "SELECT password FROM user WHERE name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
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
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return (check);
		}
	}
}