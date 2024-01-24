package View;

	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Date;
	import java.util.Enumeration;

	import javax.swing.AbstractButton;
	import javax.swing.ButtonGroup;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	import javax.swing.JScrollBar;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.JTextPane;
	import javax.swing.UIManager;
	import javax.swing.table.DefaultTableModel;

	import Controller.AddPatientDAO;
	import Model.PatientModel;

	public class UpdatePatientView extends JFrame{
		private PatientManagementView patientManagementView;
		
		private JLabel jLabel_img;
		private JLabel jLabel_id;
		public JLabel jLable_idPatient;
		private JLabel jLabel_name;
		public JTextField jTextField_name;
		private JLabel jLabel_gender;
		private JLabel jLabel_dateOfBirth;
		public JTextField jTextField_dateOfBirth;
		private JLabel jLabel_address;
		public JTextField jTextField_address;
		private JLabel jLabel_phone;
		public JTextField jTextField_phone;
		private JLabel jLabel_idRoom;
		public JLabel jLabel_numBed;
		private JLabel jLabel_idDisease;
		private JLabel jLabel_idDoctor;
		public JTextField jTextField_idDoctor;
		private JLabel jLabel_dayIn;
		public JTextField jTextField_dayIn;
		private JLabel jLabel_dayOut;
		public JTextField jTextField_dayOut;
		private JButton jButton_Reset;
		public JButton jButton_save;
		public JButton jButton_back;

		public JComboBox<String> jComboBox_idRoom;

		public JComboBox<String> jComboBox_numBed;

		public JComboBox<String> jComboBox_idDisease;
		
		public JComboBox<String> jComboBox_gender;	
		
		public UpdatePatientView() {
			this.setTitle("Update patient");
			this.setSize(400, 600);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setIconImage(Toolkit.getDefaultToolkit().createImage(AddPatientView.class.getResource("AddPatient.png")));

			Font font = new Font("Arial", Font.BOLD, 15);
			
			jLabel_img = new JLabel();
			jLabel_img.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(AddPatientView.class.getResource("AddNew.png"))));
			JPanel jPanel_img = new JPanel();
			jPanel_img.setLayout(new BorderLayout());
			jPanel_img.add(jLabel_img, BorderLayout.CENTER);
			
			jLabel_id = new JLabel("ID:");
			jLabel_id.setFont(font);
			jLable_idPatient = new JLabel();
			jLable_idPatient.setFont(font);
			jLabel_name = new JLabel("Name:");
			jLabel_name.setFont(font);
			jTextField_name = new JTextField();
			jTextField_name.setFont(font);
			jLabel_gender = new JLabel("Gender:");
			jLabel_gender.setFont(font);

			String[] gender = new String[] {"", "0", "1"};
			jComboBox_gender = new JComboBox<String>(gender);
			jComboBox_gender.setFont(font);
			

			jLabel_dateOfBirth = new JLabel("Date of birth:");
			jLabel_dateOfBirth.setFont(font);
			jTextField_dateOfBirth = new JTextField();
			jTextField_dateOfBirth.setFont(font);
			jLabel_address = new JLabel("Address:");
			jLabel_address.setFont(font);
			jTextField_address = new JTextField();
			jTextField_address.setFont(font);
			jLabel_phone = new JLabel("Phone:");
			jLabel_phone.setFont(font);
			jTextField_phone = new JTextField();
			jTextField_phone.setFont(font);
			jLabel_idRoom = new JLabel("ID Room:");
			jLabel_idRoom.setFont(font);
			
			String[] idRoom = new String[] {"", "DV01", "DV02", "DV03", "T01", "T02", "T03", "T04"};
			jComboBox_idRoom = new JComboBox<String>(idRoom);
			jComboBox_idRoom.setFont(font);
					
			jLabel_numBed = new JLabel("Number bed:");
			jLabel_numBed.setFont(font);	
			
			String[] numBed = new String[] {"", "1", "2", "3", "4"};
			jComboBox_numBed = new JComboBox<String>(numBed);
			jComboBox_numBed.setFont(font);
			
			jLabel_idDisease = new JLabel("ID disease:");
			jLabel_idDisease.setFont(font);
			String[] idDisease = new String[] {"", "DQ", "NDC", "NMCT", "RLDM", "RLNT", "ST", "STM", "STX", "TM", "VCT", "VH", "VMDU", "VTG", "VTQ", "XG", "XHDD"};
			jComboBox_idDisease = new JComboBox<String>(idDisease);
			jComboBox_idDisease.setFont(font);
			JScrollPane jScrollPane_idDisease = new JScrollPane(jComboBox_idDisease);
			
			jLabel_idDoctor = new JLabel("ID Doctor:");
			jLabel_idDoctor.setFont(font);
			jTextField_idDoctor = new JTextField();
			jTextField_idDoctor.setFont(font);
			jLabel_dayIn = new JLabel("Day in:");
			jLabel_dayIn.setFont(font);
			jTextField_dayIn = new JTextField();
			jTextField_dayIn.setFont(font);
			jLabel_dayOut = new JLabel("Day out:");
			jLabel_dayOut.setFont(font);
			jTextField_dayOut = new JTextField();
			jTextField_dayOut.setFont(font);
			
			JPanel jPanel_input = new JPanel(); 
			jPanel_input.setLayout(new GridLayout(12,2,5,5));
			jPanel_input.add(jLabel_id);
			jPanel_input.add(jLable_idPatient); 
			jPanel_input.add(jLabel_name);
			jPanel_input.add(jTextField_name);
			jPanel_input.add(jLabel_gender);
			jPanel_input.add(jComboBox_gender);
			jPanel_input.add(jLabel_dateOfBirth);
			jPanel_input.add(jTextField_dateOfBirth);
			jPanel_input.add(jLabel_address);
			jPanel_input.add(jTextField_address);
			jPanel_input.add(jLabel_phone);
			jPanel_input.add(jTextField_phone);
			jPanel_input.add(jLabel_idRoom);
			jPanel_input.add(jComboBox_idRoom);
			jPanel_input.add(jLabel_numBed);
			jPanel_input.add(jComboBox_numBed);
			jPanel_input.add(jLabel_idDisease);
			jPanel_input.add(jScrollPane_idDisease);
			jPanel_input.add(jLabel_idDoctor);
			jPanel_input.add(jTextField_idDoctor);
			jPanel_input.add(jLabel_dayIn);
			jPanel_input.add(jTextField_dayIn);
			jPanel_input.add(jLabel_dayOut);
			jPanel_input.add(jTextField_dayOut);
			
			jButton_Reset = new JButton("Reset");
			jButton_Reset.setFont(font);
			jButton_Reset.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(AddPatientView.class.getResource("Reset.png"))));
			jButton_Reset.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					deleteForm();
					
				}
				// delete all details in jTextField:
				private void deleteForm() {
						jTextField_name.setText("");
						jComboBox_gender.setSelectedIndex(-1);
						jTextField_dateOfBirth.setText("");
						jTextField_address.setText("");
						jTextField_phone.setText("");
						jComboBox_idRoom.setSelectedIndex(-1);
						jComboBox_numBed.setSelectedIndex(-1);
						jComboBox_idDisease.setSelectedIndex(-1);
						jTextField_idDoctor.setText("");
						jTextField_dayIn.setText("");
						jTextField_dayOut.setText("");	
				}
			});
			
			jButton_save = new JButton("Save");
			jButton_save.setFont(font);
			jButton_save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(AddPatientView.class.getResource("Save.png"))));
			jButton_save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("Save")) {
						JOptionPane.showMessageDialog(patientManagementView, "Successful saving!");
						try {
							// Get information for each attribute to save:
							String id_patient = jLable_idPatient.getText();
							String namePatient = jTextField_name.getText();
							String gender = jComboBox_gender.getSelectedItem().toString();
							String date_of_birth = jTextField_dateOfBirth.getText();
							String address = jTextField_address.getText();
							String phone = jTextField_phone.getText();
							String id_room = jComboBox_idRoom.getSelectedItem().toString();
							String numbed = jComboBox_numBed.getSelectedItem().toString();
							String id_disease = jComboBox_idDisease.getSelectedItem().toString();
							String id_doctor = jTextField_idDoctor.getText();
							String dayIn = jTextField_dayIn.getText();
							String dayOut = jTextField_dayOut.getText();
							PatientModel patientModel = new PatientModel(id_patient, namePatient, gender, date_of_birth, address, phone, id_room, numbed, id_disease, id_doctor, dayIn, dayOut);
							PatientManagementView patientManagementView = new PatientManagementView();
							patientManagementView.AddOrUpdatePatient(patientModel);
						}
						catch (Exception exc ) {
							exc.printStackTrace();
						}
					}
				}
				
			});
			jButton_back = new JButton("Back");
			jButton_back.setFont(new Font("Arial", Font.BOLD, 15));
			jButton_back.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DoctorView.class.getResource("Back.png"))));
			jButton_back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().equals("Back"))
					new PatientManagementView();		
				}
			} );
			
			JPanel jPanel_button = new JPanel();
			jPanel_button.setLayout(new FlowLayout());
			jPanel_button.add(jButton_Reset);
			jPanel_button.add(jButton_save);
			jPanel_button.add(jButton_back);
			
			this.setLayout(new BorderLayout());
			this.add(jPanel_img, BorderLayout.WEST);
			this.add(jPanel_input, BorderLayout.CENTER);
			this.add(jPanel_button, BorderLayout.SOUTH);
			this.setVisible(true);
		}
	}

