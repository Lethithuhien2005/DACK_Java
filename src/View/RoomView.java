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

import Controller.DBConnection;

public class RoomView extends JFrame {

	private JButton jButton_back;
	public RoomView() {
		this.setTitle("List room");
		this.setSize(250, 300);
		this.setLocation(334, 160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(RoomView.class.getResource("Room.png")));

		//Load data from database to jTable:
		Vector vRow = null, vColumn = null;

		try {
			ResultSet rs = new DBConnection().queryDB("SELECT * FROM room");
			ResultSetMetaData rsm = rs.getMetaData();
			int numCol = rsm.getColumnCount();
			vColumn = new Vector(numCol);
			for (int i = 1; i <= numCol; i++) {
				vColumn.add(rsm.getColumnLabel(i));
			}
			vRow = new Vector(50,50);
			while (rs.next()) {
				Vector row = new Vector(numCol);
				for (int i = 1; i <= numCol; i++) {
					row.add(rs.getString(i));
				}
				vRow.add(row);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		JTable jTable_room = new JTable(vRow, vColumn);
		JScrollPane jScrollPane = new JScrollPane(jTable_room, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		

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
}
