package Model;

import java.sql.Date;

public class DoctorModel {
	private String ID_doctor;
	private String name_doctor;
	private String gender;
	private String date;
	private String address;
	private String phone;
	private String ID_department;
	
	public DoctorModel() {

	}
	
	public DoctorModel(String iD_doctor, String name_doctor, String gender, String date, String address, String phone,
			String ID_department) {
		ID_doctor = iD_doctor;
		this.name_doctor = name_doctor;
		this.gender = gender;
		this.date = date;
		this.address = address;
		this.phone = phone;
		this.ID_department = ID_department;
	}
	
	public String getID_doctor() {
		return ID_doctor;
	}

	public void setID_doctor(String iD_doctor) {
		ID_doctor = iD_doctor;
	}
	public String getName_doctor() {
		return name_doctor;
	}
	public void setName_doctor(String name_doctor) {
		this.name_doctor = name_doctor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getID_department() {
		return ID_department;
	}
	public void setID_department(String ID_department) {
		this.ID_department = ID_department;
	}
	
	
}
