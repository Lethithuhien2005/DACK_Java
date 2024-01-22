package Model;

public class RoomModel {
	private String ID_room;
	private int number_bed;
	private String type_room;
	
	public RoomModel() {

	}
	
	public RoomModel(String iD_room, int number_bed, String type_room) {
	ID_room = iD_room;
	this.number_bed = number_bed;
	this.type_room = type_room;
	}	
	
	public String getID_room() {
		return ID_room;
	}

	public void setID_room(String iD_room) {
		ID_room = iD_room;
	}

	public int getNumber_bed() {
		return number_bed;
	}

	public void setNumber_bed(int number_bed) {
		this.number_bed = number_bed;
	}

	public String getType_room() {
		return type_room;
	}

	public void setType_room(String type_room) {
		this.type_room = type_room;
	}

	@Override
	public String toString() {
		return "Room [ID_room=" + ID_room + ", number_bed=" + number_bed + ", type_room=" + type_room + "]";
	}
	
}
