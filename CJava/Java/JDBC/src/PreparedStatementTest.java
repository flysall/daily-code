import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class PreparedStatementTest {
	private String driver;
	private String url;
	private String user;
	private String pass;

	/**
	 * A function to import *.ini file
	 * 
	 * @param paramFile
	 * @throws Exception
	 */
	public void initParam(String paramFile) throws Exception {
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
		// load the drive
		Class.forName(driver);
	}

	public void insertUseStatement() throws Exception {
		long start = System.currentTimeMillis();
		try (Connection conn = DriverManager.getConnection(url, user, pass); Statement stmt = conn.createStatement()) {
			for (int i = 0; i < 100; i++) {
				stmt.executeUpdate("insert into student_table values (" + " null, '姓名" + i + "', 1)");
			}
			System.out.println("the time for Statement is: " + (System.currentTimeMillis() - start));
		}
	}

	public void insertUsePrepare() throws Exception {
		long start = System.currentTimeMillis();
		try (Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement pstmt = conn.prepareStatement("insert into student_table values(null, ?, 1)")) {
			for (int i = 0; i < 100; i++) {
				pstmt.setString(1, "name" + i);
				pstmt.executeUpdate();
			}
			System.out.println("the time for preparedStatement is: " + (System.currentTimeMillis() - start));
		}
	}

	public static void main(String[] args) throws Exception {
		PreparedStatementTest pt = new PreparedStatementTest();
		pt.initParam("mysql.ini");
		pt.insertUseStatement();
		pt.insertUsePrepare();
	}
}
