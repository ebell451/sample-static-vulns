package messagesStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class LoginAPI {

//	This is what they see in the question.
	public final Connection action() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/dbName", "admin", "admin");
	}

//	These will be only included in the relevant options where there are constants in the parameters. 
	private static final String MYSQL_USERNAME = "admin";
	private static final String MYSQL_PASSWORD = "=)E:fG-LJs!yw+2-";

//	Still hard coded, just in constants.
	public final Connection action_bad_option_1() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/dbName", MYSQL_USERNAME, MYSQL_PASSWORD);
	}

//	Still password is hard coded.
	public final Connection action_bad_option_2(Properties p) throws SQLException {

		String username = p.getProperty("username");
		String password = p.getProperty("password", "=)E:fG-LJs!yw+2-");

		return DriverManager.getConnection("jdbc:mysql://localhost/dbName", username, password);
	}

//	Uses a separate file for storing username and password.
	public final Connection action_right_answer(Properties p) throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/dbName", p.getProperty("username"),
				p.getProperty("password"));
	}
}
