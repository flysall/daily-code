
import java.util.*;
import java.io.*;
import java.sql.*;

public class ExecuteSQL
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	/**
	 * A function to import *.ini file
	 * @param paramFile
	 * @throws Exception
	 */
	public void initParam(String paramFile)throws Exception
	{
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	/**
	 * A function to execute in java
	 * @param the syntax
	 * @throws Exception
	 */
	public void executeSql(String sql)throws Exception{
		Class.forName(driver);
		try(
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement())
		{
			boolean hasResultSet = stmt.execute(sql);
			if(hasResultSet){
				try(
						ResultSet rs = stmt.getResultSet())
				{
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					while(rs.next()){
						for(int i = 0; i < columnCount; i++)
							System.out.print(rs.getString(i+1) + "\t");
						System.out.print("\n");
					}
				}
			}
			else{
				System.out.println("the record influence by this sql syntax are " 
						+ stmt.getUpdateCount());
			}
		}
	}
	public static void main(String[] args) throws Exception
	{
		ExecuteSQL es = new ExecuteSQL();
		es.initParam("mysql.ini");
		System.out.println("------the DDL syntax for deleting the table------");
		es.executeSql("drop table if exists my_test");
		System.out.println("------the DLL syntax for creating table------");
		es.executeSql("create table my_test"
				+ "(test_id int auto_increment primary key,"
				+ "test_name varchar(255))");
		System.out.println("------the DML syntax for inserting data------");
		es.executeSql("insert into my_test(test_name)"
				+ "select student_name from student_table");
		System.out.println("------the syntax for executing querying------");
		es.executeSql("select * from my_test");
	}
}