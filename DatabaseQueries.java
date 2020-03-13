package messagesStudy;

import java.sql.*;

import messagesStudy.Utilities;

public class DatabaseQueries {

//	Vulnerable to sql injection. Not sanitising the inputs.
	public void action(String data) throws Throwable {

		Connection dbConnection = null;
		Statement sqlStatement = null;

		try {
			dbConnection = Utilities.getDBConnection();
			sqlStatement = dbConnection.createStatement();

			String query = "insert into users (status) values ('updated') where name='" + data + "'";
			sqlStatement = dbConnection.createStatement();

			Boolean result = sqlStatement.execute(query);

			if (result) {
				System.out.println("Name, " + data + ", updated successfully");
			} else {
				System.out.println("Unable to update records for user");
			}
		} catch (SQLException exceptSql) {
			System.out.println("Error getting database connection");
		} finally {
			try {
				if (sqlStatement != null) {
					sqlStatement.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing PreparedStatement");
			}

			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing Connection");
			}
		}
	}

//	Vulnerable to sql injection. Not sanitising the inputs. Not using prepareStatement.
	public void action_bad_asnwer_1(String data) throws Throwable {

		Connection dbConnection = null;
		Statement sqlStatement = null;

		try {
			dbConnection = Utilities.getDBConnection();
			sqlStatement = dbConnection.createStatement();

			Boolean result = sqlStatement
					.execute("insert into users (status) values ('updated') where name='" + data + "'");

			if (result) {
				System.out.println("Name, " + data + ", updated successfully");
			} else {
				System.out.println("Unable to update records for user");
			}
		} catch (SQLException exceptSql) {
			System.out.println("Error getting database connection");
		} finally {
			try {
				if (sqlStatement != null) {
					sqlStatement.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing PreparedStatement");
			}

			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing Connection");
			}
		}
	}

//	Vulnerable to sql injection. Not sanitising the inputs. It uses prepareStatement but still uses a string instead of setting parameters.
	public void action_bad_asnwer_2(String data) throws Throwable {

		Connection dbConnection = null;
		Statement sqlStatement = null;

		try {
			dbConnection = Utilities.getDBConnection();
			sqlStatement = dbConnection.createStatement();

			String query = "insert into users (status) values ('updated') where name='" + data + "'";
			sqlStatement = dbConnection.prepareStatement(query);

			Boolean result = sqlStatement.execute(query);

			if (result) {
				System.out.println("Name, " + data + ", updated successfully");
			} else {
				System.out.println("Unable to update records for user");
			}
		} catch (SQLException exceptSql) {
			System.out.println("Error getting database connection");
		} finally {
			try {
				if (sqlStatement != null) {
					sqlStatement.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing PreparedStatement");
			}

			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing Connection");
			}
		}
	}

//	Uses prepareStatement and sets the parameter using setString method.
	public void action_right_answer(String data) throws Throwable {

		Connection dbConnection = null;
		PreparedStatement sqlStatement = null;

		try {
			dbConnection = Utilities.getDBConnection();

			sqlStatement = dbConnection.prepareStatement("insert into users (status) values ('updated') where name=?");
			sqlStatement.setString(1, data);

			Boolean result = sqlStatement.execute();

			if (result) {
				System.out.println("Name, " + data + ", updated successfully");
			} else {
				System.out.println("Unable to update records for user");
			}
		} catch (SQLException exceptSql) {
			System.out.println("Error getting database connection");
		} finally {
			try {
				if (sqlStatement != null) {
					sqlStatement.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing PreparedStatement");
			}

			try {
				if (dbConnection != null) {
					dbConnection.close();
				}
			} catch (SQLException exceptSql) {
				System.out.println("Error closing Connection");
			}
		}
	}
}
