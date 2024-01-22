package Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.PatientModel;

public class AddPatientDAO {

	public void addPatient(PatientModel pt) {
		try {
			String sql = "INSERT INTO patientfile VALUES ('" + pt.getID_patient().toString() + "', '"
					+ pt.getName_patient().toString() + "', '" 
					+ pt.getGender().toString()+ "', '" 
					+ pt.getDate().toString() + "', '"
					+ pt.getAddress().toString() + "', '"
					+ pt.getPhone().toString() + "', '"
					+ pt.getID_room().toString() + "', '"
					+ pt.getNumber_bed().toString() + "', '"
					+ pt.getID_disease().toString() + "', '"
					+ pt.getID_doctor().toString() + "', '"
					+ pt.getDay_in().toString() + "', '"
					+ pt.getDay_out().toString() + "')";
			PreparedStatement ps = new DBConnection().conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
