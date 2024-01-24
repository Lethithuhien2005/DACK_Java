package View;

import java.sql.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.tools.Tool;

import Controller.AddPatientDAO;
import Controller.DBConnection;
import Model.PatientModel;

public class PatientManagementView extends JFrame {


	private JPanel jPanel_button;
	private JButton jButton_add;
	private JButton jButton_update;
	private JButton jButton_delete;
	private JButton jButton_search;
	private JButton jButton_back;
	public JTable jTable_patient;
	private DefaultTableModel model;
	private String id_patient, namePatient, gender, date_of_birth, address, phone, id_room, numbed, id_disease, id_doctor, dayIn, dayOut; 
	int selectedRow;
	public Vector vData;
	public Vector vTitle;
	private ResultSet rs;
	private ResultSetMetaData rsm;
	
	public PatientManagementView() {

		this.setTitle("Medical file ");
		this.setSize(1250, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(DoctorView.class.getResource("Medicalfile.png")));

		Font font = new Font("Arial", Font.BOLD, 15);
		
		//Load data from database to jTable:
		vData = null;
		vTitle = null;
		try {
			
			rs = new DBConnection().queryDB("SELECT * FROM patientfile");
			rsm = rs.getMetaData();
			int col_num = rsm.getColumnCount();
			vTitle = new Vector(col_num);
			for (int i = 1; i <= col_num; i++) {
				vTitle.add(rsm.getColumnLabel(i));
			}
			vData = new Vector(50,50);
			while (rs.next()) {
				Vector row = new Vector(col_num);
				for (int i = 1; i <= col_num; i++) {
					row.add(rs.getString(i));
				}
				vData.add(row);
			}
			System.out.println(vData.size());
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		model = new DefaultTableModel(vData, vTitle);
		jTable_patient = new JTable(model);
		JScrollPane jsp = new JScrollPane(jTable_patient, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// Generate button "Add" to add new patient:
		jPanel_button = new JPanel();
		jButton_add = new JButton("Add");
		jButton_add.setFont(font);
		jButton_add.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(PatientManagementView.class.getResource("Add.png"))));
		jButton_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Add")) {
					new AddPatientView();
				}
			}
		});
		
		// Generate button "Delete" to delete patient:
		jButton_delete = new JButton("Delete");
		jButton_delete.setFont(font);
		jButton_delete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(PatientManagementView.class.getResource("Delete2.png"))));
		jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Delete"))
				{
					delete();
				}
			}
		});
		
		// Generate button "Update" to modify information:
		jButton_update = new JButton("Update");
		jButton_update.setFont(font);
		jButton_update.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(PatientManagementView.class.getResource("Update.png"))));
		jButton_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Update")) {
					display_to_update();
				}
				
			}
		});
		
		// Generate button "Search" to search for patient:
		jButton_search = new JButton("Search");
		jButton_search.setFont(font);
		jButton_search.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(PatientManagementView.class.getResource("Search.png"))));
		jButton_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Search")) {
					new SearchPatient();
				}
				
			}
		});
	
		jButton_back = new JButton("Back");
		jButton_back.setFont(font);
		jButton_back.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DoctorView.class.getResource("Back.png"))));
		jButton_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Back")) {
					new HomePageView();
				}	
			}

		});
		jPanel_button.setLayout(new FlowLayout());
		jPanel_button.add(jButton_add);
		jPanel_button.add(jButton_delete);
		jPanel_button.add(jButton_update);
		jPanel_button.add(jButton_search);
		jPanel_button.add(jButton_back);
	
		
		this.setLayout(new BorderLayout());
		this.add(jsp, BorderLayout.CENTER);
		this.add(jPanel_button, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public void AddOrUpdatePatient(PatientModel pt) {
		try {
			// Add rows to table:
			model.addRow(new Object[] {
					pt.getID_patient(),
					pt.getName_patient(),
					pt.getGender(),
					pt.getDate(),
					pt.getAddress(),
					pt.getPhone(),
					pt.getID_room(),
					pt.getNumber_bed(),
					pt.getID_disease(),
					pt.getID_doctor(),
					pt.getDay_in(),
					pt.getDay_out()
			});
			model.fireTableDataChanged();
			// Add rows to Database:
			AddPatientDAO addPatientDAO = new AddPatientDAO();
			addPatientDAO.addPatient(pt);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
	//Delete a patient:
	public void delete() {
		try {
			selectedRow = jTable_patient.getSelectedRow();
			Vector pt = (Vector) this.vData.elementAt(selectedRow);
			String sql = "DELETE FROM patientfile where idPatient = \"" + pt.elementAt(0) + "\"";
			PreparedStatement pr = new DBConnection().conn.prepareStatement(sql);
			pr.executeUpdate(sql);
			vData.remove(selectedRow);
			model.fireTableDataChanged();
		}
		catch (Exception ect) {
			ect.printStackTrace();
		}	
	}
	// Display information of patient on jTextField / jComboBox to modify:
	public void display_to_update() {
		//Get information:
		model = (DefaultTableModel) jTable_patient.getModel();
		selectedRow = jTable_patient.getSelectedRow();
		id_patient = model.getValueAt(selectedRow, 0)+"";
		namePatient = model.getValueAt(selectedRow, 1)+"";
		gender =  model.getValueAt(selectedRow, 2)+"";
		date_of_birth =  model.getValueAt(selectedRow, 3)+"";
		address =  model.getValueAt(selectedRow, 4)+"";
		phone =  model.getValueAt(selectedRow, 5)+"";
		id_room =  model.getValueAt(selectedRow, 6)+"";
		numbed =  model.getValueAt(selectedRow, 7)+"";
		id_disease =  model.getValueAt(selectedRow, 8)+"";
		id_doctor =  model.getValueAt(selectedRow, 9)+"";
		dayIn =  model.getValueAt(selectedRow, 10)+"";
		dayOut =  model.getValueAt(selectedRow, 11)+"";
		
		//display information:
		UpdatePatientView updatePatientView = new UpdatePatientView();
		updatePatientView.jLable_idPatient.setText(id_patient);
		updatePatientView.jTextField_name.setText(namePatient);
		updatePatientView.jComboBox_gender.setSelectedItem(gender);
		updatePatientView.jTextField_dateOfBirth.setText(date_of_birth);
		updatePatientView.jTextField_address.setText(address);
		updatePatientView.jTextField_phone.setText(phone);
		updatePatientView.jComboBox_idRoom.setSelectedItem(id_room);
		updatePatientView.jComboBox_numBed.setSelectedItem(numbed);
		updatePatientView.jComboBox_idDisease.setSelectedItem(id_disease);
		updatePatientView.jTextField_idDoctor.setText(id_doctor);
		updatePatientView.jTextField_dayIn.setText(dayIn);
		updatePatientView.jTextField_dayOut.setText(dayOut);
		
		delete();

	}
}
