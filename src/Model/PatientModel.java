package Model;

import java.sql.Date;

public class PatientModel {
	private String ID_patient;
	private String name_patient;
	private String gender;
	private String date;
	private String address;
	private String phone;
	private String ID_room;
	private String number_bed;
	private String ID_disease;
	private String ID_doctor;
	private String day_in;
	private String day_out;

	public PatientModel() {

	}

	public PatientModel(String iD_patient, String name_patient, String gender, String date, String address, String phone,
			String iD_room, String number_bed, String iD_disease, String iD_doctor, String day_in, String day_out) {
		ID_patient = iD_patient;
		this.name_patient = name_patient;
		this.gender = gender;
		this.date = date;
		this.address = address;
		this.phone = phone;
		ID_room = iD_room;
		this.number_bed = number_bed;
		ID_disease = iD_disease;
		ID_doctor = iD_doctor;
		this.day_in = day_in;
		this.day_out = day_out;
	}

	public String getID_patient() {
		return ID_patient;
	}
	
	public void setID_patient(String iD_patient) {
		ID_patient = iD_patient;
	}

	public String getName_patient() {
		return name_patient;
	}

	public void setName_patient(String name_patient) {
		this.name_patient = name_patient;
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

	public String getID_room() {
		return ID_room;
	}

	public void setID_room(String iD_room) {
		ID_room = iD_room;
	}

	public String getNumber_bed() {
		return number_bed;
	}

	public void setNumber_bed(String number_bed) {
		this.number_bed = number_bed;
	}

	public String getID_disease() {
		return ID_disease;
	}

	public void setID_disease(String iD_disease) {
		ID_disease = iD_disease;
	}

	public String getID_doctor() {
		return ID_doctor;
	}

	public void setID_doctor(String iD_doctor) {
		ID_doctor = iD_doctor;
	}

	public String getDay_in() {
		return day_in;
	}

	public void setDay_in(String day_in) {
		this.day_in = day_in;
	}

	public String getDay_out() {
		return day_out;
	}

	public void setDay_out(String day_out) {
		this.day_out = day_out;
	}

	@Override
	public String toString() {
		return "Patient [ID_patient=" + ID_patient + ", name_patient=" + name_patient + ", gender=" + gender + ", date="
				+ date + ", address=" + address + ", phone=" + phone + ", ID_room=" + ID_room + ", number_bed="
				+ number_bed + ", ID_disease=" + ID_disease + ", ID_doctor=" + ID_doctor + ", day_in=" + day_in
				+ ", day_out=" + day_out + "]";
	}
}