import java.io.*;
import java.sql.*;
import java.util.*;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class CallableStatementTest {
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

	public void callProcudure() throws Exception {
		Class.forName(driver);
		try (Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
				CallableStatement cstmt = (CallableStatement) conn.prepareCall("{call add_pro(?,?,?)}")) {
			cstmt.setInt(1, 4);
			cstmt.setInt(2, 5);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			System.out.println("the result is: " + cstmt.getInt(3));
		}
	}

	public static void main(String[] args) throws Exception {
		CallableStatementTest ct = new CallableStatementTest();
		ct.initParam("mysql.ini");
		ct.callProcudure();
	}
}
