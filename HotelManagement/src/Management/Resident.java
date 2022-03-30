package Management;

public class Resident {
	
	private Person credentials;
	private Room room;
	private String fname, lname;
	private int bill;
	
	public Resident(Person credentials, Room room, String fname, String lname, int bill) {
		this.credentials = credentials;
		this.room = room;
		this.fname = fname;
		this.lname = lname;
		this.bill=bill;
	}

	public Person getCredentials() {
		return credentials;
	}

	public void setCredentials(Person credentials) {
		this.credentials = credentials;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	
	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill += bill;
	}

	public String roomService() {
		return "Room service is on its way.";
	}
	
}
