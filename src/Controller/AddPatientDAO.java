package Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.PatientModel;

public class AddPatientDAO {

	public void addPatient(PatientModel pt) {
		try {
			String sql = "INSERT INTO patientfile VALUES ('" + pt.getID_patient() + "', '"
					+ pt.getName_patient() + "', '" 
					+ pt.getGender()+ "', '" 
					+ pt.getDate() + "', '"
					+ pt.getAddress() + "', '"
					+ pt.getPhone() + "', '"
					+ pt.getID_room() + "', '"
					+ pt.getNumber_bed() + "', '"
					+ pt.getID_disease() + "', '"
					+ pt.getID_doctor() + "', '"
					+ pt.getDay_in() + "', '"
					+ pt.getDay_out() + "')";
			PreparedStatement ps = new DBConnection().conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
