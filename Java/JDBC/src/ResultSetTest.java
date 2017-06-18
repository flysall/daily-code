import java.util.*;

import com.mysql.jdbc.*;

import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ResultSetTest {
	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String paramFile) throws Exception {
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}

	public void query(String sql) throws Exception {
		Class.forName(driver);
		try (Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
				// create a PrepareStatement Object
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = pstmt.executeQuery()) {
			rs.last();
			int rowCount = rs.getRow();
			for (int i = rowCount; i > 0; i--) {
				rs.absolute(i);
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
				rs.updateString(2, " student name " + i);
				rs.updateRow();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ResultSetTest rt = new ResultSetTest();
		rt.initParam("mysql.ini");
		rt.query("select * from student_table");
	}
}
