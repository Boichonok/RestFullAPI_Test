package dataBase;
import java.sql.*;


public class JDBCConnection {

	public JDBCConnection() {
		
	}
	
	private Connection getConnection(String nameDatabse) {
		Connection connection = null;
		try {
			String connectionURL = "jdbc:mysql://localhost:8080/MyFirstRESTfulAPI/" + nameDatabse;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "root");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.getLocalizedMessage();
		}
		return connection;
	}
	
	public boolean creatDataBase(String nameDatabase) {
		Statement statement = null;
		Connection connection = getConnection("");
		try {
		statement = connection.createStatement();
		statement.executeUpdate("CREATE DATABASE " + nameDatabase);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(statement!=null)
		            statement.close();
		      }catch(SQLException se2){
		    	  se2.printStackTrace();
		      }// nothing we can do
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		return true;
	}
	
	private Connection selectDataBase(String nameDatabase) {
			return getConnection(nameDatabase);
	}
	
	public void deleatDataBase(String nameDatabase) {
		Statement statement = null;
		Connection conn = null;
		try {
			conn = getConnection("");
			statement = conn.createStatement();
			statement.executeUpdate("DROP DATABASE " + nameDatabase);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
		         if(statement!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
	}

	public void createTabelProduct(String nameDatabase) {
		Statement statement = null;
		Connection connection = selectDataBase(nameDatabase);
		try {
			statement = connection.createStatement();
			String sql = "CREATE TABLE PRODUCT " +
	                   "(id INTEGER not NULL, " +
	                   " name VARCHAR(255), " + 
	                   " price INTEGER, " + 
	                   " PRIMARY KEY ( id ))";
			statement.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(statement!=null)
		            connection.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
	}
	
	
}
