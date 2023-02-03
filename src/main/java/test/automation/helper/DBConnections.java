package test.automation.helper;

import java.nio.channels.NoConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DBConnections {


	private Connection connection;
	public Statement statement=null;
	public ResultSet dbResult =null;
	private  DBConnections dbConnections;

	private String url , username , dbname;
	private char[] password;

	private DBConnections() {}


	public DBConnections getIntance()
	{
		if(dbConnections!=null)
			dbConnections=new DBConnections();
		return dbConnections;
	}

	/**
	 *
	 * @param url
	 * @param username
	 * @param password
	 * @param dbname
	 * @return
	 * @throws SQLException
	 */
	public DBConnections getIntance(String url,String username,char[] password,String dbname) throws SQLException
	{
		if(dbConnections!=null)
			dbConnections=new DBConnections(this.url=url,this.username=username,this.password=password,this.dbname=dbname);
		return dbConnections;
	}

	/**
	public DBConnections getIntance(String url_username_password,String dbname) throws SQLException
	{
		if(dbConnections!=null)
			dbConnections=new DBConnections(this.url_username_password=username,this.dbname=dbname);
		return dbConnections;
	}
	 **/

	/**
	 *
	 * @param url
	 * @param username
	 * @param password
	 * @param dbname
	 * @throws SQLException
	 */
	public DBConnections(String url,String username,char[] password,String dbname) throws SQLException {
		try {
			if(dbname.equalsIgnoreCase("oracle"))
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			else if(dbname.equalsIgnoreCase("sql"))
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			else
			{
				throw new ClassNotFoundException();
			}
			
			connection = DriverManager.getConnection(url, username, password.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("Database Connection Creation Failed : " + e.getMessage());
		}
	}

	/**
	private DBConnections(String url_username_password,String dbname) throws SQLException {
		try {
			if(dbname.equalsIgnoreCase("oracle"))
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			else if(dbname.equalsIgnoreCase("sql"))
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			else
			{
				throw new ClassNotFoundException();
			}
			connection = DriverManager.getConnection(url_username_password);
			statement=connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Database Connection Creation Failed : " + e.getMessage());
		}
	}
	**/

	/**
	 *
	 * @param query
	 * @return
	 */
  public boolean dbUpdate(String query)
  {
	  try {
		  
		dbResult=statement.executeQuery(query);
		statement.executeQuery("commit");
		return true;
	} catch (SQLException e) {
		return false;
	}
	   
  }

	/**
	 *
	 * @param query
	 * @return
	 */
  public boolean dbdelete(String query)
  {
	  try {
		  
			dbResult=statement.executeQuery(query);
			statement.executeQuery("commit");
			return true;
		} catch (SQLException e) {
			return false;
		}
	  
  }

	/**
	 *
	 * @param query
	 * @return
	 */
  public List<String> dbSelect(String query)
  {
	  List<String> dbdata=new ArrayList<String>();
	  try {
		dbResult=statement.executeQuery(query);
		ResultSetMetaData metadata=dbResult.getMetaData();
		for(int i=0;i>=metadata.getColumnCount();i++)
		{
			dbdata.add(dbResult.getString(i));
		}
		dbdata.removeAll(Collections.singletonList(null));
		return dbdata;
	} catch (SQLException e) {
		return null;
	}  
  }

	/**
	 *
	 * @param query
	 * @return
	 */
	public HashMap<String,String> dbSelectWithcolName(String query)
  {
	  HashMap<String,String> dbdata=new LinkedHashMap<String,String>();
	  try {
		dbResult=statement.executeQuery(query);
		ResultSetMetaData metadata=dbResult.getMetaData();
		for(int i=0;i>=metadata.getColumnCount();i++)
		{
			dbdata.put(metadata.getColumnName(i),dbResult.getString(i));
		}
		return dbdata;
	} catch (SQLException e) {
		return null;
	}
  }

	/**
	 *
	 * @param query
	 * @return
	 */
	public int dbRowCount(String query)
  {
	  int rowcount =0;
	  try {
		  
			dbResult=statement.executeQuery(query);
			dbResult.last();
			rowcount=dbResult.getRow();
			return rowcount+1;
			
		} catch (SQLException e) {
			return 0;
		}
  }

	/**
	 *
	 * @param query
	 * @return
	 */
	public int dbcolumnCount(String query)
  {
	  
	  try {
		  
			dbResult=statement.executeQuery(query);
			ResultSetMetaData metadata=dbResult.getMetaData();
			return metadata.getColumnCount();
			
		} catch (SQLException e) {
			return 0;
		}
  }

	/**
	 *
	 * @param query
	 * @param columnName
	 * @return
	 */
	public String dbgetcolumn(String query,String columnName)
  {
	  try {
		  
			dbResult=statement.executeQuery(query);
			ResultSetMetaData metadata=dbResult.getMetaData();
			return dbResult.getString(columnName);
			
		} catch (SQLException e) {
			return null;
		}
  }

	/**
	 *
	 * @return
	 */
	public boolean close()
  {
	  try {
		connection.close();
		return true;
	} catch (SQLException | NoConnectionPendingException e) {
		
		return false;
	}
   }
}
