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
	
	@Test
	public void updateTable() throws SQLException {
		Connection jdbcCon = new JDBCconnection().getDBConnection();
		addrbook.updateData("meghana", 104);
		jdbcCon.close();
	}
	
	@Test
	public void givenDate_ShouldReturnContact() throws SQLException {
		Connection jdbcCon = new JDBCconnection().getDBConnection();
		addrbook.getContactsWithParticularPeriod("2018-01-01");
		jdbcCon.close();
	}
	
	@Test
	public void givenCityOrState_ShouldReturnContact() throws SQLException {
		Connection jdbcCon = new JDBCconnection().getDBConnection();
		addrbook.getContactByCityorState();
		jdbcCon.close();
	}
	
	@Test
	public void abilityToAddNewContact() throws SQLException{
		Connection jdbcCon = new JDBCconnection().getDBConnection();
		addrbook.addNewContact(106, "john", "cena", "967878767","c@gmail" , 55, "leh", "ladhak", "11", 6);
		jdbcCon.close();
	}
}
