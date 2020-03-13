package messagesStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This is just a file to help the code compile & is not included in the questions/experiment. 
public class Utilities {

	private static final String dbUrl = "";
	private static final String dbUsername = "";
	private static final String dbPassword = "";

	public static Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}

	public static String toString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02X ", b));
		}
		return sb.toString();
	}
}
