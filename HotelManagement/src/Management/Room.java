package Management;

public class Room {
	private String number;
	RoomType type;
	
	public Room(String number, RoomType type) {
		this.number = number;
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}
	
	
}
