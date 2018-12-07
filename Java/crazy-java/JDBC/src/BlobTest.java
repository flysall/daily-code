
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.ArrayList;
import java.io.*;
import javax.swing.filechooser.FileFilter;

public class BlobTest {
	JFrame jf = new JFrame("picture Programmer");
	private static Connection conn;
	private static PreparedStatement insert;
	private static PreparedStatement query;
	private static PreparedStatement queryAll;
	// define a DefaulltListModel Object
	private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
	private JList<ImageHolder> imageList = new JList<>(imageModel);
	private JTextField filePath = new JTextField(26);
	private JButton browserBn = new JButton("...");
	private JButton uploadBn = new JButton("upload");
	private JLabel imageLabel = new JLabel();
	// create a file filter in current path
	JFileChooser chooser = new JFileChooser(".");
	// create file filter
	ExtensionFileFilter filter = new ExtensionFileFilter();
	static {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("mysql.ini"));
			String driver = props.getProperty("driver");
			String url = props.getProperty("url");
			String user = props.getProperty("user");
			String pass = props.getProperty("pass");
			Class.forName(driver);
			// get connection
			conn = (Connection) DriverManager.getConnection(url, user, pass);
			insert = (PreparedStatement) conn.prepareStatement("insert into img_tables" + "values(null, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			query = (PreparedStatement) conn.prepareStatement("select img_data from img_tablle" + "where img_id = ?");
			queryAll = (PreparedStatement) conn.prepareStatement("select img_id," + "img_name from img_table");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws SQLException {
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("picture file(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		// initial the GUI
		fillListModel();
		filePath.setEditable(false);
		// only single choose
		imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel jp = new JPanel();
		jp.add(filePath);
		jp.add(browserBn);
		browserBn.addActionListener(event -> {
			// show dialogs
			int result = chooser.showDialog(jf, "���ͼƬ�ϴ�");
			if (result == JFileChooser.APPROVE_OPTION) {
				filePath.setText(chooser.getSelectedFile().getPath());
			}
		});
		jp.add(uploadBn);
		uploadBn.addActionListener(avt -> {
			if (filePath.getText().trim().length() > 0) {
				upload(filePath.getText());
				filePath.setText("");
			}
		});
		JPanel left = new JPanel();
		left.setLayout(new BorderLayout());
		left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
		left.add(jp, BorderLayout.SOUTH);
		jf.add(left);
		imageList.setFixedCellWidth(160);
		jf.add(new JScrollPane(imageList), BorderLayout.EAST);
		imageList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					ImageHolder cur = (ImageHolder) imageList.getSelectedValue();
					try {
						showImage(cur.getId());
					} catch (SQLException sqle) {
						sqle.printStackTrace();
					}
				}
			}
		});
		jf.setSize(620, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	public void fillListModel() throws SQLException {
		try (ResultSet rs = queryAll.executeQuery()) {
			imageModel.clear();
			while (rs.next()) {
				imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
			}
		}
	}

	public void upload(String fileName) {
		// ��ȡ�ļ���
		String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.lastIndexOf('.'));
		File f = new File(fileName);
		try (InputStream is = new FileInputStream(f)) {
			// ����ͼƬ������
			insert.setString(1, imageName);
			// ���ö�����������
			insert.setBinaryStream(2, is, (int) f.length());
			int affect = insert.executeUpdate();
			if (affect == 1) {
				// ���¸���ListModel��������JList��ʾ���µ�ͼƬ�б�
				fillListModel();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// show image by ID
	public void showImage(int id) throws SQLException {
		query.setInt(1, id);
		try (ResultSet rs = query.executeQuery()) {
			if (rs.next()) {
				Blob imgBlob = rs.getBlob(1);
				ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
				imageLabel.setIcon(icon);
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		new BlobTest().init();
	}

	class ExtensionFileFilter extends FileFilter {
		private String description = "";
		private ArrayList<String> extensions = new ArrayList<>();

		public void addExtension(String extension) {
			if (!extension.startsWith(".")) {
				extension = "." + extension;
				extensions.add(extension.toLowerCase());
			}
		}

		public void setDescription(String aDescription) {
			description = aDescription;
		}

		public String getDescription() {
			return description;
		}

		public boolean accept(File f) {
			if (f.isDirectory())
				return true;
			String name = f.getName().toLowerCase();
			for (String extension : extensions) {
				if (name.endsWith(extension)) {
					return true;
				}
			}
			return false;
		}
	}

	class ImageHolder {
		// ��װͼƬ��ID
		private int id;
		// ��װͼƬ��ͼƬ����
		private String name;

		public ImageHolder() {
		}

		public ImageHolder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		// id��setter��getter����
		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return this.id;
		}

		// name��setter��getter����
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		// ��дtoString����������ͼƬ��
		public String toString() {
			return name;
		}
	}

}
