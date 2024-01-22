package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.mysql.cj.xdevapi.Result;

import Controller.DBConnection;

public class DoctorView extends JFrame {

	private JButton jButton_back;

	public DoctorView() {
		this.setTitle("List doctor");
		this.setSize(615, 300);
		this.setLocation(334, 160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(DoctorView.class.getResource("IconDoctor.png")));;
		
		//Load data from database to jTable:
		Vector vData = null, vTitle = null;
		try {
			ResultSet rs = new DBConnection().queryDB("SELECT * FROM doctor");
			ResultSetMetaData rsm = rs.getMetaData();
			int num_col = rsm.getColumnCount();
			vTitle = new Vector(num_col);
			for (int i=1; i<=num_col; i++) {
				vTitle.add(rsm.getColumnLabel(i));
			}
			vData = new Vector(50,50);
			while (rs.next()) {
				Vector row = new Vector(num_col);
				for (int i=1; i<=num_col; i++) {
					row.add(rs.getString(i));
				}
				vData.add(row);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		JTable jTable = new JTable(vData, vTitle);
		JScrollPane jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		jButton_back = new JButton("Back");
		jButton_back.setFont(new Font("Arial", Font.BOLD, 15));
		jButton_back.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DoctorView.class.getResource("Back.png"))));
		jButton_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Back")) {
					new HomePageView();
				}
				
			}
		});
		
		JPanel jPanel_button = new JPanel()	;
		jPanel_button.setLayout(new FlowLayout());
		jPanel_button.add(jButton_back);
		
		this.setLayout(new BorderLayout());
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel_button, BorderLayout.SOUTH);
		
		this.setVisible(true);

	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
			new DoctorView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
