package Address.Book.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddressBookJDBC {

	Connection con;
	public void getTableData() throws SQLException{		
		try {
			JDBCconnection connection = new JDBCconnection();
			con = connection.getDBConnection();
			String query = "select * from contacts";
			Statement stmt =  con.createStatement();
		      ResultSet resultSet= stmt.executeQuery(query);
		        while (resultSet.next())
		        {
		            System.out.println(
		                    resultSet.getString(1)+" "+
		                            resultSet.getString(2)+ " "+
		                            resultSet.getString(3)+" "+
		                            resultSet.getString(4)+" "+
		                            resultSet.getString(5)+" "+
		                            resultSet.getString(6)
		            );
		        }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void updateData(String firstname, int contact_id) throws SQLException {
		try{
			JDBCconnection connection = new JDBCconnection();
			con = connection.getDBConnection();
			
			String query = "update contacts set firstname=? where contact_id=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, firstname);
			pstmt.setInt(2, contact_id);
			pstmt.executeUpdate();
			System.out.println("Done");			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void getContactsWithParticularPeriod(String startdate) throws SQLException {
		JDBCconnection connection = new JDBCconnection();
		con = connection.getDBConnection();
		try {
			String query ="select firstname from contacts where date_added between CAST(? AS DATE) AND DATE(NOW()) ";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, startdate);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) 
				System.out.println(rs.getString(1));
		}catch(SQLException e){
			e.printStackTrace();
		}
	} 
}
