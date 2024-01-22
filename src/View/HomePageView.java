package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class HomePageView extends JFrame {


	public HomePageView() {
		this.setTitle("Home page");
		this.setSize(615,460);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("IconHospital.png")));

		Font font = new Font("Arial", Font.CENTER_BASELINE, 15);

		//Generate menu:
		JMenuBar jMenuBar = new JMenuBar();

		JMenu jMenu_list = new JMenu("List");
		jMenu_list.setFont(font);
		JMenuItem jMenuItem_listRoom = new JMenuItem("Room");
		jMenuItem_listRoom.setFont(font);
		jMenuItem_listRoom.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("Room.png"))));
		jMenuItem_listRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Room")) {
					new RoomView();
				}

			}
		});
		JMenuItem jMenuItem_listDoctor = new JMenuItem("Doctor");
		jMenuItem_listDoctor.setFont(font);
		jMenuItem_listDoctor.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("Doctor.png"))));
		jMenuItem_listDoctor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Doctor")) {
					new DoctorView();
				}
				
			}
		});
		JMenuItem jMenuItem_listDepartment = new JMenuItem("Department");
		jMenuItem_listDepartment.setFont(font);
		jMenuItem_listDepartment.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("Department.png"))));
		jMenuItem_listDepartment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Department")) {
					new DepartmentView();
				}

			}
		});
		JMenuItem jMenuItem_medicalfile = new JMenuItem("Medical file");
		jMenuItem_medicalfile.setFont(font);
		jMenuItem_medicalfile.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("MedicalFile.png"))));
		jMenuItem_medicalfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String click = e.getActionCommand();
				if (click.equals("Medical file")) {
					new PatientManagementView();
				}

			}
		});

		jMenu_list.add(jMenuItem_listRoom);
		jMenu_list.add(jMenuItem_listDoctor);
		jMenu_list.add(jMenuItem_listDepartment);
		jMenu_list.add(jMenuItem_medicalfile);

		JMenu jMenu_File = new JMenu("File");
		jMenu_File.setFont(font);
		JMenuItem jMenuItem_Exit = new JMenuItem("Exit");
		jMenuItem_Exit.setFont(font);
		jMenuItem_Exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("Exit3.png"))));
		// Create key combination for button "Exit":
		jMenuItem_Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		jMenuItem_Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = e.getActionCommand();
				if (src.equals("Exit")) {
					System.exit(0);
				}

			}
		});

		jMenu_File.add(jMenuItem_Exit);
		
		jMenuBar.add(jMenu_list);
		jMenuBar.add(jMenu_File);

		JLabel jLabel_hospital = new JLabel();
		jLabel_hospital.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(HomePageView.class.getResource("hospital.jpg"))));
		
		this.setJMenuBar(jMenuBar);
		this.add(jLabel_hospital);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new HomePageView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
