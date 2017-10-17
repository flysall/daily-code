import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import com.mysql.jdbc.*;

public class QueryExecutor {
	JFrame jf = new JFrame("执行查询器");
	private JScrollPane scrollPane;
	private JButton execBn = new JButton("query");
	// the text field for input
	private JTextField sqlField = new JTextField(45);
	private static Connection conn;
	private static Statement stmt;
	static {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String drivers = props.getProperty("driver");
			String url = props.getProperty("url");
			String username = props.getProperty("user");
			String password = props.getProperty("pass");
			// 加载数据库驱动
			Class.forName(drivers);
			// 取得数据库连接
			conn = (Connection) DriverManager.getConnection(url, username, password);
			stmt = (Statement) conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {
		JPanel top = new JPanel();
		top.add(new JLabel("Please input sql: "));
		top.add(sqlField);
		top.add(execBn);
		execBn.addActionListener(new ExceListener());
		sqlField.addActionListener(new ExceListener());
		jf.add(top, BorderLayout.NORTH);
		jf.setSize(680, 480);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	class ExceListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if (scrollPane != null)
				jf.remove(scrollPane);
			try (ResultSet rs = (ResultSet) stmt.executeQuery(sqlField.getText())) {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				Vector<String> columnNames = new Vector<>();
				Vector<Vector<String>> data = new Vector<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					columnNames.add(rsmd.getColumnName(i + 1));
				}
				while (rs.next()) {
					Vector<String> v = new Vector<>();
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						v.add(rs.getString(i + 1));
					}
					data.add(v);
				}
				JTable table = new JTable(data, columnNames);
				scrollPane = new JScrollPane(table);
				jf.add(scrollPane);
				jf.validate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new QueryExecutor().init();
	}

}
