package Main;

import javax.swing.UIManager;

import View.AdminView;
import View.WelcomePage;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new WelcomePage();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
