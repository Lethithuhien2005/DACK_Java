package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


import Controller.DBConnection;
import Model.PatientModel;

public class SearchPatient extends JFrame {
	
	private JLabel jLabel_img;
	public JTextField jTextField_id;
	private JLabel jLabel_name;
	public JTextField jTextField_name;
	private JButton jButton_search;
	private JTable jTable_patient;
	private ResultSet rs;
	private JScrollPane jsp;
	
	ArrayList<PatientModel> arr = new ArrayList<PatientModel>();
	private DefaultTableModel model;
	
	public SearchPatient() {
		this.setTitle("Search Patient");
		this.setSize(1200, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial", Font.BOLD, 15);

		jTable_patient = new JTable();
		jsp = new JScrollPane(jTable_patient, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Add name's columns to model:
		try {
			model = (DefaultTableModel) jTable_patient.getModel();
			ResultSet rs = new DBConnection().queryDB("SELECT * FROM patientfile");
			ResultSetMetaData rsm = rs.getMetaData();
			int col_num = rsm.getColumnCount();
			for (int i = 1; i <= col_num; i++) {
				model.addColumn(rsm.getColumnLabel(i));
			}
		}
		catch (Exception exct) {
			exct.printStackTrace();
		}
		
		jLabel_img = new JLabel();
		jLabel_img.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SearchPatient.class.getResource("SearchPeople.png"))));
	
		JPanel jPanel_input = new JPanel();
		jPanel_input.setLayout(new GridLayout(1,2, 10, 10));
	
		jLabel_name = new JLabel("Name patient", jLabel_name.RIGHT);
		jLabel_name.setFont(font);
		jTextField_name = new JTextField(8);
		jTextField_name.setFont(font);
		jTextField_name.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				arr.clear();
				//Display patient when a char has been released:
				try {
					String sql = "SELECT * FROM patientfile WHERE Name like N'%" + jTextField_name.getText() + "%' ";
					rs = new DBConnection().queryDB(sql);
					System.out.println(sql);
					
					// Get information in columns:
					while (rs.next()) {
						String idPatient = rs.getString(1);
						String namePt = rs.getNString(2);
						String gender = rs.getString(3);
						String date_of_birth = rs.getString(4);
						String address = rs.getNString(5);
						String phone = rs.getString(6);
						String idRoom = rs.getString(7);
						String numBed = rs.getString(8);
						String idDisease = rs.getString(9);
						String idDoctor = rs.getString(10);
						String dayIn = rs.getString(11);
						String dayOut = rs.getString(12);
						
						PatientModel ptModel = new PatientModel(idPatient, namePt, gender, date_of_birth, address, phone, idRoom, numBed, idDisease, idDoctor, dayIn, dayOut);
						
						arr.add(ptModel);
					}
					new DBConnection().close();
					
					loadArraylistToTable();
				}
				catch (Exception exct) {
					exct.printStackTrace();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		jPanel_input.add(jLabel_name);
		jPanel_input.add(jTextField_name);
		
		JPanel jPanel_search = new JPanel();
		jPanel_search.setLayout(new FlowLayout());
		jPanel_search.add(jLabel_img);
		jPanel_search.add(jPanel_input);
		

		jButton_search = new JButton("Search");
		jButton_search.setFont(font);
		jButton_search.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SearchPatient.class.getResource("Search.png"))));
		
		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new FlowLayout());
		jPanel_button.add(jButton_search);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jPanel_search,BorderLayout.CENTER);
		jPanel.add(jPanel_button, BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(jsp, BorderLayout.CENTER);
		this.add(jPanel, BorderLayout.NORTH);
		
		loadDataToArraylist();
		loadArraylistToTable();
		
		
		this.setVisible(true);
	}

	public void loadDataToArraylist() {
		arr.clear();
		try {
			ResultSet rs = new DBConnection().queryDB("SELECT * FROM patientfile");
			while (rs.next()) {
				String idPatient = rs.getString(1);
				String namePt = rs.getNString(2);
				String gender = rs.getString(3);
				String date_of_birth = rs.getString(4);
				String address = rs.getNString(5);
				String phone = rs.getString(6);
				String idRoom = rs.getString(7);
				String numBed = rs.getString(8);
				String idDisease = rs.getString(9);
				String idDoctor = rs.getString(10);
				String dayIn = rs.getString(11);
				String dayOut = rs.getString(12);
				
				PatientModel ptModel = new PatientModel(idPatient, namePt, gender, date_of_birth, address, phone, idRoom, numBed, idDisease, idDoctor, dayIn, dayOut);
				
				arr.add(ptModel);
			}
			System.out.println(arr.size());
			new DBConnection().close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadArraylistToTable() {
		try {
			model = (DefaultTableModel) jTable_patient.getModel();
			model.setRowCount(0);	
			for (PatientModel ptModel : arr) {
				model.addRow(new Object[] { ptModel.getID_patient(), ptModel.getName_patient(), ptModel.getGender(), ptModel.getDate(), ptModel.getAddress(), ptModel.getPhone(), ptModel.getID_room(), ptModel.getNumber_bed(), ptModel.getID_disease(), ptModel.getID_doctor(), ptModel.getDay_in(), ptModel.getDay_out() });
				
			}
			System.out.println(" number of collumn: " + model.getColumnCount());
			System.out.println(" number of row: " + model.getRowCount());
		} 
		catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new SearchPatient();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
