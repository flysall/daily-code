import java.awt.BorderLayout;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginFrame {
	private final String PROP_FILE = "mysql.ini";
	private String driver;
	// url是数据库的服务地址
	private String url;
	private String user;
	private String pass;
	// The GUI for login
	private JFrame jf = new JFrame("Login");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("Login");

	public void init() throws Exception {
		Properties connProp = new Properties();
		connProp.load(new FileInputStream(PROP_FILE));
		driver = connProp.getProperty("driver");
		url = connProp.getProperty("url");
		user = connProp.getProperty("user");
		pass = connProp.getProperty("pass");
		// Load the driver
		Class.forName(driver);
		// add a listener for login button
		loginButton.addActionListener(e -> {
			// show "success" if login successfully
			if (validate(userField.getText(), passField.getText())) {
				JOptionPane.showMessageDialog(jf, "login success");
			} else {
				JOptionPane.showMessageDialog(jf, "login failure");
			}
		});
		jf.add(userField, BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton, BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}

	private boolean validate(String userName, String userPass) {
		String sql = "select * from jdbc_test " + "where jdbc_name='" + userName + "' and jdbc_desc='" + userPass + "'";
		System.out.println(sql);
		try (Connection conn = (Connection) DriverManager.getConnection(url, user, pass);
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		new LoginFrame().init();
	}
}
