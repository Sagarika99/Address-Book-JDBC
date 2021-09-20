package Address.Book.JDBC;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class AddressBookJDBCTest {

	public AddressBookJDBC addrbook = new AddressBookJDBC();
	
	@Test
	public void checkConnection() throws SQLException {
		Connection jdbcCon = new JDBCconnection().getDBConnection();
		addrbook.getTableData();
		jdbcCon.close();
	}
	
}
