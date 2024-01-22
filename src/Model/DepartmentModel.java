package Model;

public class DepartmentModel {
	private String ID_departmetn;
	private String name_departmetn;

	public DepartmentModel() {

	}

	public DepartmentModel(String iD_departmetn, String name_departmetn) {
		ID_departmetn = iD_departmetn;
		this.name_departmetn = name_departmetn;
	}

	public String getID_departmetn() {
		return ID_departmetn;
	}

	public void setID_departmetn(String iD_departmetn) {
		ID_departmetn = iD_departmetn;
	}

	public String getName_departmetn() {
		return name_departmetn;
	}

	public void setName_departmetn(String name_departmetn) {
		this.name_departmetn = name_departmetn;
	}

	@Override
	public String toString() {
		return "Department [ID_departmetn=" + ID_departmetn + ", name_departmetn=" + name_departmetn + "]";
	}
}
