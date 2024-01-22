package Model;

public class DiseaseModel {
	private String ID_disease;
	private String name_disease;

	public DiseaseModel() {

	}

	public DiseaseModel(String iD_disease, String name_disease) {
		super();
		ID_disease = iD_disease;
		this.name_disease = name_disease;
	}

	public String getID_disease() {
		return ID_disease;
	}

	public void setID_disease(String iD_disease) {
		ID_disease = iD_disease;
	}

	public String getName_disease() {
		return name_disease;
	}

	public void setName_disease(String name_disease) {
		this.name_disease = name_disease;
	}

	@Override
	public String toString() {
		return "Disease [ID_disease=" + ID_disease + ", name_disease=" + name_disease + "]";
	}
}
